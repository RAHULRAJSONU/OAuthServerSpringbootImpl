package com.silvertech.OAuthServerSpringbootImpl.repository;

import com.silvertech.OAuthServerSpringbootImpl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
