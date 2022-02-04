//package com.inventorymanagementsystemrestservices.configuration;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
////@Import(BeanValidatorPluginsConfiguration.class)
//public class SwaggerConfig {
//
//    @Bean
//    public Docket api(){
//        return  new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//    //swagger metadata: http://localhost:8080/v2/api-docs
//    //swagger UI URL: http://localhost:8080/swagger-ui.html
//}
//
////    @Bean
////    public Docket api(){
////        return new Docket(DocumentationType.SWAGGER_2)
////                .apiInfo(getApiInfo())
////                .select()
////                .apis(RequestHandlerSelectors.basePackage("com.inventorymanagementsystemrestservices."))
////                .paths(PathSelectors.ant("**"))
////                .build();
////    }
////
////    //swagger metadata: http://localhost:8080/v2/api-docs
////    //swagger UI URL: http://localhost:8080/swagger-ui.html
////
////    private ApiInfo getApiInfo(){
////        return new ApiInfoBuilder()
////                .title("Inventory Management Service")
////                .description("This page lists all API's of Inventory Management")
////                .version("2.0")
////                .contact(new Contact("Rabeeka Sadiq", "https://www.inventory.com","rbksdq@gmail.com"))
////                .license("License 2.0")
////                .licenseUrl("https://www.inventory.com/license.html")
////                .build();
////    }
////}
