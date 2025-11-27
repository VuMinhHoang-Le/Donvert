package com.donvert.upload_microservice.repository;

import com.donvert.upload_microservice.model.UploadReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadReceiptRepository extends JpaRepository<UploadReceipt, Long> {
}
