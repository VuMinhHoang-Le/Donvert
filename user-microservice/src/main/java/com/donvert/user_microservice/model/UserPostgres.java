package com.donvert.user_microservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPostgres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userPostgresId;

    private String userUserName;
    private String userPassword;
    private Integer userSubscriptionMode;
    private LocalDateTime userTimeCreated;

}
