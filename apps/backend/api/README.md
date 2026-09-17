# Fandza

**Plataforma digital para procura e reserva de transporte escolar.**

Fandza é uma aplicação mobile que liga **encarregados de educação** a **motoristas e operadores de transporte escolar**. Através dela, o encarregado pode pesquisar rotas, conhecer quem conduz e quais as viaturas disponíveis, reservar lugares com antecedência e avaliar a qualidade do serviço — sempre com um processo de validação documental transparente e seguro.

---

## Porquê o Fandza?

O transporte escolar em muitas cidades funciona de forma informal: os encarregados não têm uma forma fiável de comparar opções, verificar a credibilidade dos motoristas e das viaturas nem reservar lugares com antecedência. O Fandza resolve esse problema ao centralizar numa só plataforma:

- Registo e validação de **motoristas** e **viaturas** (documentos, carta de condução, capacidade).
- Publicação de **rotas escolares** com vagas disponíveis em tempo real.
- Pesquisa de rotas e **reserva de lugares** pelos encarregados de educação.
- **Avaliação** dos motoristas (classificação + comentário) após cada viagem.
- Gestão de **estudantes** vinculados a cada encarregado.

---

## Arquitectura do Projecto

O repositório adopta uma estrutura **monorepo**, organizada por domínios da aplicação:

```
Fandza/
├── apps/
│   ├── backend/
│   │   └── api/                 # API REST (Spring Boot)
│   └── frontend/
│       ├── mobile/              # Aplicação mobile do encarregado
│       └── web/                 # Painel web (motorista/admin) — em planeamento
├── infra/
│   └── docker/                  # Dockerfiles e docker-compose
├── docs/
│   ├── setup.md                 # Guia de instalação
│   └── deployment.md            # Guia de deploy
└── api/                         # (legado) cópia anterior do backend
```

**Estado actual:** o backend está em desenvolvimento activo (CRUDs implementados no padrão Controller → Service → Repository). Os frontends mobile e web ainda não foram implementados — existe apenas a estrutura de pastas.

---

## Stack Tecnológica

### Backend (`apps/backend/api`)

| Camada | Tecnologia |
|--------|-----------|
| Linguagem | Java 21 |
| Framework | Spring Boot 4.1 |
| Persistência | Spring Data JPA (Hibernate) |
| Migrações | Flyway |
| Base de dados | PostgreSQL |
| Segurança | Spring Security, BCrypt e OAuth2 Client |
| Dependências | Lombok, `uuid-creator` (UUID v7), Bean Validation |

### Frontend (planeado)

- **Mobile:** aplicação destinada ao encarregado de educação (tecnologia a definir).
- **Web:** painel de gestão para motoristas e administradores (tecnologia a definir).

---

## Modelo de Domínio

O modelo organiza os usuários numa hierarquia com **herança JOINED**: a entidade base `AppUser` é abstrata e dá origem a `Driver` e `LegalGuardian`.

| Entidade | Descrição |
|----------|-----------|
| `AppUser` | Usuário base: nome, email, telefone, senha, tipo (`DRIVER` ou `LEGAL_GUARDIAN`). |
| `Driver` | Motorista: n.º da carta, data de emissão, status, rating médio, viatura e documentos. |
| `LegalGuardian` | Encarregado de educação: lista de estudantes, reservas e avaliações. |
| `Student` | Estudante: nome, data de nascimento, classe, escola e endereço. |
| `School` | Escola associada a um estudante. |
| `Address` | Endereço: bairro, quarteirão/bloco e n.º de casa. |
| `Vehicle` | Viatura: matrícula, marca, modelo, cor, capacidade e motorista. |
| `Route` | Rota escolar: descrição e vagas disponíveis (com controlo de concorrência `@Version`). |
| `VehicleRoute` | Associação N:N entre viaturas e rotas. |
| `Reservation` | Reserva de lugar: data, status e relação com encarregado e rota. |
| `Assessment` | Avaliação do motorista: classificação, comentário e data. |
| `Document` | Documento (carta, BI, foto de perfil, registo do veículo) com fluxo de aprovação. |

### Estados (enums)

- `UserType` - `DRIVER`, `LEGAL_GUARDIAN`
- `DriverStatus` - `PENDING`, `APPROVED`, `REJECTED`
- `DocumentStatus` - `PENDING`, `APPROVED`, `REJECTED`
- `DocumentType` - `DRIVING_LICENCE`, `BI`, `PROFILE_PHOTO`, `VEHICLE_REGISTRATION`
- `ReservationStatus` - `PENDING`, `CONFIRMED`, `CANCELLED`, `REJECTED`

> **IDs:** todas as entidades usam **UUID v7** (ordenável por tempo), gerado através da biblioteca `uuid-creator`.

---

## API REST

Os controladores disponíveis em `controller/` seguem o padrão **Controller → Service → Repository**, com **DTOs** de request/response e **mappers** dedicados por entidade, o que desacopla a API do modelo de persistência.

| Recurso | Base URI | Operações |
|---------|----------|-----------|
| Motoristas | `/api/driver` | Listagem, detalhe, criação, actualização e remoção |
| Viaturas | `/api/vehicle` | Listagem, detalhe, criação, actualização e remoção |
| Encarregados | `/api/guardian` | Listagem, detalhe, criação, actualização e remoção |
| Estudantes | `/api/guardian/{guardianID}/student[/{studentID}]` | CRUD aninhado ao encarregado |
| Endereços | `/api/address` | Listagem, detalhe, criação, actualização e remoção |
| Documentos | `/api/document` | Upload para motorista (`/driver/{id}`) e para viatura (`/vehicle/{id}`) |

---

## Migrações de Base de Dados (Flyway)

As migrações em `src/main/resources/db/migration` são aplicadas automaticamente no arranque da aplicação:

```
V1  app_users          V7  vehicle
V2  address            V8  route
V3  legal_guardian     V9  vehicle_route
V4  driver            V10 reservation
V5  school            V11 assessment
V6  student           V12 document
```

O Hibernate opera com `ddl-auto: validate`, o que garante que o esquema real é **sempre** controlado pelas migrações e nunca pelo mapeamento das entidades.

---

## Como Executar Localmente

### Pré-requisitos

- **Java 21+**
- **Maven 3.9+**
- **PostgreSQL** (base `fandza` criada localmente)

### Passos

1. **Base de dados** — crie a base `fandza`. A configuração actual em `application.yaml` usa `postgres/070239` em `localhost:5432/fandza`. Ajuste as credenciais ao seu ambiente.

2. **Executar o backend**

   ```bash
   cd apps/backend/api
   mvn spring-boot:run
   ```

   A aplicação arranca em `localhost:8080` e aplica as migrações Flyway automaticamente.

3. **Executar testes**

   ```bash
   mvn test
   ```

---
