package com.donvert.upload_microservice.dto;

import java.time.LocalDateTime;

public record UploadReceiptRequest(long receiptId, long userId, String fileId, LocalDateTime uploadTime) {
}
