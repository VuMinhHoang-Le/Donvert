package com.donvert.upload_microservice.service;

import com.donvert.upload_microservice.model.File;
import com.donvert.upload_microservice.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MongoService {

    @Autowired
    private FileRepository fileRepository;

    public String createFileObject(MultipartFile multipartFile) throws Exception {
        File file = File.builder()
                .fileName(multipartFile.getOriginalFilename())
                .fileType(multipartFile.getContentType())
                .fileSize(multipartFile.getSize())
                .build();
        file = fileRepository.save(file);
        return file.getFileId();
    }

    public File getFileFromId(String fileId) {
        return fileRepository.findByFileId(fileId);
    }
}
