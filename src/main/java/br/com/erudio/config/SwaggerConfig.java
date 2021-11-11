package br.com.erudio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String TAG_BOOK = "BOOKER ENDPOINT";
    public static final String TAG_PERSON = "PERSON ENDPOINT";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.erudio"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(TAG_BOOK, "Entry point do BOOK."))
                .tags(new Tag(TAG_PERSON, "Entry point do PERSON."))
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Estudando Spring Boot")
                .description("Vamos aprender spring")
                .version("0.0.1").build();
    }


}
