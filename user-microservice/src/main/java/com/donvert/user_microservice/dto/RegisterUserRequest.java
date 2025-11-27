package com.donvert.user_microservice.dto;

import java.time.LocalDateTime;

public record RegisterUserRequest(String userId, String userName, String userPassword, boolean userEnabled, Integer subscriptionTier, LocalDateTime dateCreated) {
}
