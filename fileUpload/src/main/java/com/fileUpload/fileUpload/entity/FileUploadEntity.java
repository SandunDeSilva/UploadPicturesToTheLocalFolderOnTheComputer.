package com.fileUpload.fileUpload.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "AiTable")
public class FileUploadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customId;
    private LocalDateTime uploadDateAndTime;
    private String fileName;
    private String savedFileName;
    private String identifiedObject;

    public FileUploadEntity(
            String pCustomerID,
            LocalDateTime pUploadDateTime,
            String pFileName,
            String pSavedFileName,
            String pIdentifiedObject) {
        this.customId = pCustomerID;
        this.uploadDateAndTime = pUploadDateTime;
        this.fileName = pFileName;
        this.savedFileName = pSavedFileName;
        this.identifiedObject = pIdentifiedObject;
    }

}
