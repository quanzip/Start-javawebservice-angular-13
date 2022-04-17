package com.example.backend.config;

import com.example.backend.service.ConditionOnEnv;
import com.example.backend.service.condition.ConditionalOnSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AppConfig {

    @Value(value = "${quanaqt.name: no name}")
    private String myName;

    @Bean
    @Conditional(ConditionalOnSystem.class)
    // create this bean when app is running with java version 8
    @ConditionalOnJava(JavaVersion.EIGHT)
    // create this bean when  quanaqt.isSent = true và quanzip.enable = true
    // Every thing in  {} must be compare to true: dont use: ${quanaqt.isSent:FALSE} and ${quanzip.enable:true}
    @ConditionalOnExpression("${quanaqt.isSent:true} and ${quanzip.enable:true}")
    public QuanaqtConfig getAqtConfig() {
        return new QuanaqtConfig();
    }

    @Bean
    // Custom Conditional
    @ConditionOnEnv
    // create this bean when QuanzipConfig did not get created yet
    @ConditionalOnMissingBean
    // create this class when QuanzipConfig did not get created yet
    @ConditionalOnMissingClass
    public QuanzipConfig getZipConfig() {
        return new QuanzipConfig();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnMissingClass
    public Docket declareApis(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any()) //basePackage("com/example/backend")
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(getApiEndpointInfo());
    }

    private ApiInfo getApiEndpointInfo(){
        return new ApiInfoBuilder().title(myName)
                .description("Apis management platform")
                .contact(new Contact("Pham Hong Quanzip",
                        "https://www.facebook.com/friends",
                        "quanph1998@gmail.com"))
                .license("Quanzip-quanaqt")
                .licenseUrl("https://www.facebook.com/pham.hongquan.3591")
                .version("1.0.0")
                .build();
    }
}
