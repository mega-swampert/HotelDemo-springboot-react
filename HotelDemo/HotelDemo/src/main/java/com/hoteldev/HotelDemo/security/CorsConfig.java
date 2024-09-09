package com.hoteldev.HotelDemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: CorsConfig
 * Package: com.hoteldev.HotelDemo.security
 * Description:
 *
 * @Author MegaSwampert
 * @Create 5/09/2024 4:20 pm
 * @Version 1.0
 */
@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
       return new WebMvcConfigurer() {
           @Override
           public void addCorsMappings(CorsRegistry registry) {
               registry.addMapping("/**")
                       .allowedMethods("GET","POST","PUT","DELETE")
                       .allowedOrigins("*");
           }
       };
    }
}
