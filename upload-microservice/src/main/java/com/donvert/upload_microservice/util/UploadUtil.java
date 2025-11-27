package com.donvert.upload_microservice.util;


import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {

    public static String addFileExtension(MultipartFile file) {

        //Return content type else assign empty String
        String fileExtension = (file.getContentType() != null) ? file.getContentType() : "";

        return switch (fileExtension) {
            case "application/pdf" -> ".pdf";
            case "application/msword" -> ".doc";
            case "text/csv" -> ".csv";
            case "text/plain" -> ".txt";
            default -> "";
        };
    }
}
