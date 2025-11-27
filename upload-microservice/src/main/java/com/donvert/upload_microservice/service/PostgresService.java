package com.donvert.upload_microservice.service;

import com.donvert.upload_microservice.model.UploadReceipt;
import com.donvert.upload_microservice.repository.UploadReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostgresService {

    @Autowired
    private UploadReceiptRepository uploadReceiptRepository;

    public void createUploadReceipt(String fileMongoId) {
        LocalDateTime uploadTime = LocalDateTime.now();
        UploadReceipt uploadReceipt = new UploadReceipt(0, 0, fileMongoId, uploadTime);
        uploadReceiptRepository.save(uploadReceipt);
    }
}
