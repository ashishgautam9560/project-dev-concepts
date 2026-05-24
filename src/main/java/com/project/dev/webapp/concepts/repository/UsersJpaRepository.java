package com.project.dev.webapp.concepts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dev.webapp.concepts.entity.Users;

@Repository
public interface UsersJpaRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByUsername(String username);

}
