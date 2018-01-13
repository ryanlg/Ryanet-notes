package io.ryanliang.ryanet.config;

import io.ryanliang.markdownconverter.DefaultPandocMarkdownConverter;
import io.ryanliang.markdownconverter.PandocSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.ryanliang.markdownconverter.PandocMarkdownConverter;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

@Configuration
public class MarkdownConverterConfig implements ServletContextAware{

    private ServletContext servletContext;

    @Bean
    public PandocMarkdownConverter getPandocMarkdownConverter() {

        return new DefaultPandocMarkdownConverter() {

            @Override
            public PandocSettings getSettings() {

                return new PandocSettings() {

                    @Override
                    public String getPandocLocation() {

                        return servletContext.getRealPath("/WEB-INF/resource/pandoc/pandoc");
                    }

                    @Override
                    public String getParameters() {

                        return "--from=markdown-tex_math_dollars-raw_tex --to=html --mathjax";
                    }
                };
            }
        };
    }

    @Override
    public void setServletContext(ServletContext servletContext) {

        this.servletContext = servletContext;
    }
}
