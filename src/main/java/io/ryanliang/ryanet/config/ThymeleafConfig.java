package io.ryanliang.ryanet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ThymeleafConfig  {

//    private ApplicationContext applicationContext;
//
//    public void setApplicationContext(ApplicationContext applicationContext) {
//
//        this.applicationContext = applicationContext;
//    }
//
//    @Bean
//    public ViewResolver thymeleafViewResolver() {
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine());
//        resolver.setCharacterEncoding("UTF-8");
//        return resolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine engine = new SpringTemplateEngine();
//        engine.setEnableSpringELCompiler(true);
//        engine.setTemplateResolver(templateResolver());
//        return engine;
//    }
//
//    @Autowired
//    private ITemplateResolver templateResolver() {
//        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//        resolver.setApplicationContext(applicationContext);
//        resolver.setPrefix("/WEB-INF/views/thymeleaf/");
//        resolver.setTemplateMode(TemplateMode.HTML);
//        return resolver;
//    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        return templateEngine;
    }

    @Bean
    public SpringResourceTemplateResolver thymeleafTemplateResolver() {
        SpringResourceTemplateResolver templateResolver
                = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }
}
