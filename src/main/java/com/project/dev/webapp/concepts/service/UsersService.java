package com.project.dev.webapp.concepts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.dev.webapp.concepts.entity.Users;
import com.project.dev.webapp.concepts.repository.UsersJpaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {

	private final UsersJpaRepository usersJpaRepository;

	public List<Users> getAllCreds() {
		return usersJpaRepository.findAll();
	}

}
