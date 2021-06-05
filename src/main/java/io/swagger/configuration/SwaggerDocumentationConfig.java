package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Predicate;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-05T16:35:07.675362500+02:00[Europe/Paris]")
@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.swagger.api"))
                    .build()
                .directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Subsistema 3: gestión de trabajos de un taller")
            .description("Asignatura AOS: grupo 1")
            .license("AOSGrupo1")
            .licenseUrl("https://github.com/miguel-benito-martin/practica1_AOS")
            .termsOfServiceUrl("https://moodle.upm.es/titulaciones/oficiales/mod/assign/view.php?id&#x3D;1320916")
            .version("1.0.0")
            .contact(new Contact("","", "alberto.romartin@alumnos.upm.es"))
            .build();
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title("Subsistema 3: gestión de trabajos de un taller")
                .description("Asignatura AOS: grupo 1")
                .termsOfService("https://moodle.upm.es/titulaciones/oficiales/mod/assign/view.php?id&#x3D;1320916")
                .version("1.0.0")
                .license(new License()
                    .name("AOSGrupo1")
                    .url("https://github.com/miguel-benito-martin/practica1_AOS"))
                .contact(new io.swagger.v3.oas.models.info.Contact()
                    .email("alberto.romartin@alumnos.upm.es")));
    }

}
