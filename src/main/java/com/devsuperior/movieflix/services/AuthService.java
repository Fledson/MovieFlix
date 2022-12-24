package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;

@Service
public class AuthService {

  @Autowired
  private UserRepository repository;

  public User authenticated() {
    // pegando o usuario logado reconhecido pelo spring security
    String username = SecurityContextHolder.getContext().getAuthentication().getName();

    return repository.findByEmail(username)
        .orElseThrow(() -> new UnauthorizedException("Invalid user"));
  }

}
