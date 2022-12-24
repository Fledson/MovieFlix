package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devsuperior.movieflix.entities.dtos.UserAuthenticatedDTO;
import com.devsuperior.movieflix.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping("/profile")
  public ResponseEntity<UserAuthenticatedDTO> getProfile() {
    UserAuthenticatedDTO dto = service.getProfile();
    return ResponseEntity.ok().body(dto);
  }

}
