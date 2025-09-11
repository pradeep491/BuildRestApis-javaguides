package com.test.blog.service;

import com.test.blog.dtos.LoginDTO;
import com.test.blog.dtos.RegisterDTO;

public interface AuthService {
String login(LoginDTO loginDTO);
String register(RegisterDTO registerDTO);
}
