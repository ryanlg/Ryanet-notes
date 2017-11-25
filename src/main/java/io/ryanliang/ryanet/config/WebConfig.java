package io.ryanliang.ryanet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "io.ryanliang.ryanet")
public class WebConfig{
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/" );
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    public void configurePathMatch(PathMatchConfigurer configurer) {
        final boolean DO_NOT_USE_SUFFIX_PATTERN_MATCHING = false;
        configurer.setUseSuffixPatternMatch(DO_NOT_USE_SUFFIX_PATTERN_MATCHING);
    }
}
