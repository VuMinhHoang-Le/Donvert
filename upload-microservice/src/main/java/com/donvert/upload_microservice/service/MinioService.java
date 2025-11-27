package com.donvert.upload_microservice.service;

import com.donvert.upload_microservice.util.UploadUtil;
import io.minio.PutObjectArgs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class MinioService {

    @Value("${minio.bucket_file}")
    private String bucket_file;

    public String createFile(MultipartFile file, String fileMongoId) throws Exception {
        InputStream fileStream = file.getInputStream();
        String fileExtension = UploadUtil.addFileExtension(file);
        PutObjectArgs.builder()
                .bucket(bucket_file).object(fileMongoId + fileExtension)
                .stream(fileStream, file.getSize(), -1)
                .contentType(file.getContentType())
                .build();

        return "Successfully upload to MinIO: " + fileMongoId + fileExtension;
    }
}
