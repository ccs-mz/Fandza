package com.fandza.ccs.Fandza.mappers;

import com.fandza.ccs.Fandza.dtos.document.DocumentResponseDTO;
import com.fandza.ccs.Fandza.entities.Document;
import org.springframework.stereotype.Service;

@Service
public class DocumentMapper {


    public DocumentResponseDTO toResponse(Document document){
        return new DocumentResponseDTO(
                document.getIdDocument(),
                document.getDocumentType(),
                document.getFileUrl(),
                document.getStatus(),
                document.getUploadedAt(),
                document.getRejectionReason(),
                document.getReviewedAt()
        );

    }


}
