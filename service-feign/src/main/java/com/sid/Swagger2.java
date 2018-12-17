package com.sid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
/**
* @ClassName: swagger2配置
* @Description: TODO
* @author 刘圈圈
* @date 2018年7月5日
*/
 
@Configuration
@EnableSwagger2
public class Swagger2 {
 
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("小猪2号")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sid.web.UserController"))
                .paths(PathSelectors.any())
                .build();
    }
   @Bean
    public Docket Iuser() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("小猪")
                .apiInfo(Iuserz())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sid.web.Iuser"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试")
                .description("-------------------")
                //.termsOfServiceUrl("https://blog.csdn.net/ityqing")
                //.contact("刘圈圈")
                .version("0.1.1")
                .build();
    }


    private ApiInfo Iuserz() {
        return new ApiInfoBuilder()
                .title("朱")
                .description("-------------------")
                //.termsOfServiceUrl("https://blog.csdn.net/ityqing")
                //.contact("刘圈圈")
                .version("0.1.1")
                .build();
    }
 
}
