package com.donvert.user_microservice.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(value = "user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {
    @Id
    private String userId;
    private String userName;
    private String userPassword;
    private boolean userEnabled;
    private Integer subscriptionTier;
    private LocalDateTime dateCreated;

}
