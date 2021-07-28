package io.asiam.tansiq.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSWebConfig {
    private final Dotenv dotenv;

    @Autowired
    public CORSWebConfig(Dotenv dotenv) {
        this.dotenv = dotenv;
    }

    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(dotenv.get("UI_ORIGIN"))
                        .allowedMethods("*")
                        .allowCredentials(true);
            }
        };
    }
}
