package com.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
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
