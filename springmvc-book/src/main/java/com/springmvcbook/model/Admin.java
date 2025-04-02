package com.springmvcbook.model;

public class Admin {
  private String username;
  private String password;

  public Admin(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public boolean login (String inputUsername, String inputPassword) {
    return this.username.equals(inputUsername) && this.password.equals(inputPassword);
  }

  public String getUsername() {
    return username;
  }

}
