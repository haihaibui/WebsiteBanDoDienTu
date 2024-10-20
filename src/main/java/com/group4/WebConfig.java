package com.group4;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Cho phép AngularJS truy cập các file trong /templates/QuanLy mà không cần Thymeleaf
        registry.addResourceHandler("/QuanLy/**")
                .addResourceLocations("classpath:/templates/QuanLy/");
    }
}
