package io.ryanliang.ryanet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@ComponentScan(basePackages = "io.ryanliang.ryanet")
@PropertySource("/WEB-INF/resource/properties/multipart.properties")
public class MultipartConfig {

    private Environment environment;

    @Autowired
    public MultipartConfig(Environment environment) {

        this.environment = environment;
    }

    @Bean(name="multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(
                Long.parseLong(environment.getProperty("multipart.upload.size.max")));
        resolver.setMaxUploadSizePerFile(
                Long.parseLong(environment.getProperty("multipart.upload.size.max.per_file")));

        return resolver;
    }

}
