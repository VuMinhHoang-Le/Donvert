package com.donvert.user_microservice.repository;

import com.donvert.user_microservice.model.UserPostgres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPostgresRepository extends JpaRepository<UserPostgres, String> {
}
