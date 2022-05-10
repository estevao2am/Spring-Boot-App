package com.backoff.controllers;

import com.backoff.models.User;

public interface UserService {
  
 public User findUserByEmail(String email);
 
 public void saveUser(User user);
}
