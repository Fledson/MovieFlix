package com.devsuperior.movieflix.entities.dtos;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entities.User;

public class UserAuthenticatedDTO {

  @NotBlank
  private Long id;
  @NotBlank
  private String name;
  @NotBlank
  private String email;

  public UserAuthenticatedDTO() {
  }

  public UserAuthenticatedDTO(Long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public UserAuthenticatedDTO(User entity) {
    id = entity.getId();
    name = entity.getName();
    email = entity.getEmail();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    UserAuthenticatedDTO other = (UserAuthenticatedDTO) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
