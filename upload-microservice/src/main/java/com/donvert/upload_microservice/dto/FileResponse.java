package com.donvert.upload_microservice.dto;

public record FileResponse(String fileId, String fileName, String fileType, long fileSize) {
}
