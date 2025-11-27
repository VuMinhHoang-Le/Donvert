package com.donvert.upload_microservice.repository;

import com.donvert.upload_microservice.model.File;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends MongoRepository<File, String> {
    File findByFileName(String fileName);
    File findByFileId(String fileId);
}
