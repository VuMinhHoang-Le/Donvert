package com.donvert.upload_microservice.dto;

public record FileRequest(String fileId, String fileName, String fileType, long fileSize) {
}
