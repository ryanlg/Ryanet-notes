package io.ryanliang.ryanet.config;

import io.ryanliang.markdownconverter.DefaultPandocMarkdownConverter;
import io.ryanliang.markdownconverter.PandocSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.ryanliang.markdownconverter.PandocMarkdownConverter;

@Configuration
public class MarkdownConverterConfig {

    @Bean
    public PandocMarkdownConverter getPandocMarkdownConverter() {

        return new DefaultPandocMarkdownConverter() {

            @Override
            public PandocSettings getSettings() {

                return new PandocSettings() {

                    @Override
                    public String getPandocLocation() {

                        return "pandoc";
                    }

                    @Override
                    public String getParameters() {

                        return "--from=markdown --to=html --mathjax";
                    }
                };
            }
        };
    }
}
