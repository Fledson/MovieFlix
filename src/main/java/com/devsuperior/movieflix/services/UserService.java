package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.entities.dtos.UserAuthenticatedDTO;
import com.devsuperior.movieflix.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

  @Autowired
  private UserRepository repository;

  @Autowired
  private AuthService authService;

  public UserAuthenticatedDTO getProfile() {
    User userAuthenticated = authService.authenticated();
    return new UserAuthenticatedDTO(userAuthenticated);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = repository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("Email not found"));
    return user;
  }

}
