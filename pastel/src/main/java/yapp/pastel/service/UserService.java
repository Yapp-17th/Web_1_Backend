package yapp.pastel.service;

import org.springframework.beans.factory.annotation.Autowired;

import yapp.pastel.repository.UserRepository;

public class UserService {
  @Autowired
  private UserRepository userRepository;

}
