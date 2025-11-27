package com.donvert.upload_microservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "upload-file")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {

    @Id
    private String fileId;

    private String fileName;
    private String fileType;
    private long fileSize;
}
