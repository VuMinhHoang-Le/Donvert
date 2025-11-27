package com.donvert.upload_microservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "upload_receipt")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long receiptId;

    private long userId;
    private String fileId;
    private LocalDateTime uploadTime;
}
