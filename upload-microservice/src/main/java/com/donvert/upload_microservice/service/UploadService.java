package com.donvert.upload_microservice.service;

import com.donvert.upload_microservice.model.File;
import com.donvert.upload_microservice.repository.FileRepository;
import com.donvert.upload_microservice.repository.UploadReceiptRepository;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UploadService {

    @Autowired
    private final MinioService minioService;
    @Autowired
    private final PostgresService postgresService;
    @Autowired
    private final MongoService mongoService;

    //Update the file to SQL, MongoDB and MinIO
    public String uploadFileToDatabases(MultipartFile multipartFile) throws Exception {

        String fileMongoId = mongoService.createFileObject(multipartFile);
        File file = mongoService.getFileFromId(fileMongoId);
        postgresService.createUploadReceipt(fileMongoId);
        return minioService.createFile(multipartFile, file.getFileId());
    }
}
