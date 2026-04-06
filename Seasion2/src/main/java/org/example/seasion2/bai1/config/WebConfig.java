package org.example.seasion2.bai1.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
public class WebConfig {


    @Configuration
    @EnableWebMvc
    @ComponentScan(basePackages = "org.example.seasion2")
    public class WebConfig {

        @Bean
        public InternalResourceViewResolver viewResolver() {
            InternalResourceViewResolver resolver =
                    new InternalResourceViewResolver();

            resolver.setPrefix("/WEB-INF/views/");
            resolver.setSuffix(".jsp");

            return resolver;
        }
    }
}
