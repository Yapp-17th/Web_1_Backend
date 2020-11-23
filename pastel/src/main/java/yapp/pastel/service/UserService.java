package yapp.pastel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yapp.pastel.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

}
