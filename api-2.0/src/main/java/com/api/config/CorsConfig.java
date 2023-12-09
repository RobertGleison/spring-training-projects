package com.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Value("${cors.originPatterns:default}")
    private String corsOriginPatterns = "";

    @Override
    public void addCorsMappings(CorsRegistry registry){
       var allowedOrigins = corsOriginPatterns.split(",");
       registry.addMapping("/**")
//               .allowedMethods("GET", "POST")
               .allowedMethods("GET", "POST", "PUT", "DELETE")
               .allowedOrigins(allowedOrigins)
               .allowedHeaders("*")
               .allowCredentials(true);
    }


}
