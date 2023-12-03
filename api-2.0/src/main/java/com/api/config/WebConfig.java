package com.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.originPatterns:default}")
    private final String corsOriginPatterns = "";

    @Override
    public void addCorsMappings(CorsRegistry registry){
       var allowedOrigins = corsOriginPatterns.split(",");
       registry.addMapping("/**")
//               .allowedMethods("GET", "POST")
               .allowedMethods("*")
               .allowedOrigins(allowedOrigins)
               .allowCredentials(true);
    }


}
