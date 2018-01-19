package io.ryanliang.ryanet.config;

import com.fasterxml.jackson.databind.module.SimpleModule;
import io.ryanliang.ryanet.util.jackson.ISO8601Serializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Instant;
import java.util.List;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "io.ryanliang.ryanet")
public class WebConfig implements WebMvcConfigurer{

    // Notice since I am not using Spring Boot, I had to
    // implement this interface to customize ObjectMapper
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();

        // Adding ISO8601Serializer
        ISO8601Serializer iso8601Serializer = new ISO8601Serializer();
        SimpleModule iso8601Module = new SimpleModule();
        iso8601Module.addSerializer(Instant.class, iso8601Serializer);
        builder.modules(iso8601Module);

        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }
}

