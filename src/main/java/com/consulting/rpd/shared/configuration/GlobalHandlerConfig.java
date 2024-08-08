package com.consulting.rpd.shared.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalHandlerConfig{
        
    @Bean
    public WebMvcConfigurer addCorsMappings() {
       return new WebMvcConfigurer() {
            @SuppressWarnings("null")
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000/**", "https://rpd-consulting.netlify.app/**", "http://localhost:3000", "https://rpd-consulting.netlify.app","https://frontrpd-h6cwanasa8h9azcf.eastus-01.azurewebsites.net/**", "https://frontrpd-h6cwanasa8h9azcf.eastus-01.azurewebsites.net")
                .allowedMethods(
                    HttpMethod.GET.name(),
                    HttpMethod.POST.name(),
                    HttpMethod.PUT.name(),
                    HttpMethod.DELETE.name(), 
                    HttpMethod.OPTIONS.name()
                )
                .allowedHeaders(HttpHeaders.CONTENT_TYPE,HttpHeaders.AUTHORIZATION)
                .allowCredentials(true)
                .maxAge(3600);
            }
       };
    }
}
