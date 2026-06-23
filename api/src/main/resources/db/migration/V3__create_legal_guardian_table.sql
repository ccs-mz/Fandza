CREATE TABLE legal_guardian(
    id_legal_guardian UUID PRIMARY KEY REFERENCES app_users(id_user) ON DELETE CASCADE
);