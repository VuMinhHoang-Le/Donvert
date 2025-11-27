package com.donvert.upload_microservice.dto;

import java.time.LocalDateTime;

public record UploadReceiptResponse(long receiptId, long userId, String fileId, LocalDateTime uploadTime) {
}
