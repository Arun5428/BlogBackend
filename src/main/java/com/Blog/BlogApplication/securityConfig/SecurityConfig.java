package com.Blog.BlogApplication.securityConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class SecurityConfig {
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
