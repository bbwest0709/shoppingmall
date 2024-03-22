package com.shoppingmall.shop.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    Server server = new Server().url("https://catdoor.shop");
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().servers(List.of(server))
                .info(new Info()
                .title("쇼핑몰 프로젝트 API")
                .description("백엔드")
                .version("1.0"));
    }

    // 그룹화
    @Bean
    public GroupedOpenApi group1(){
        return GroupedOpenApi.builder()
                .group("고객 기능")
                .pathsToMatch("/customer/*")
                .packagesToScan("com.shoppingmall.shop.controller.customer")
                .build();
    }

    @Bean
    public GroupedOpenApi group2(){
        return GroupedOpenApi.builder()
                .group("상품 기능")
                .pathsToMatch("/product/*")
                .packagesToScan("com.shoppingmall.shop.controller.product")
                .build();
    }

    @Bean
    public GroupedOpenApi group3(){
        return GroupedOpenApi.builder()
                .group("장바구니 기능")
                .pathsToMatch("/cart/*")
                .packagesToScan("com.shoppingmall.shop.controller.cart")
                .build();
    }

    @Bean
    public GroupedOpenApi group4(){
        return GroupedOpenApi.builder()
                .group("주문 기능")
                .pathsToMatch("/order/*")
                .packagesToScan("com.shoppingmall.shop.controller.order")
                .build();
    }

    @Bean
    public GroupedOpenApi group5(){
        return GroupedOpenApi.builder()
                .group("리뷰 기능")
                .pathsToMatch("/review/*")
                .packagesToScan("com.shoppingmall.shop.controller.review")
                .build();
    }

    @Bean
    public GroupedOpenApi group6(){
        return GroupedOpenApi.builder()
                .group("문의글 기능")
                .pathsToMatch("/inquiry/*")
                .packagesToScan("com.shoppingmall.shop.controller.inquiry")
                .build();
    }

    @Bean
    public GroupedOpenApi group7(){
        return GroupedOpenApi.builder()
                .group("답변 기능")
                .pathsToMatch("/reply/*")
                .packagesToScan("com.shoppingmall.shop.controller.reply")
                .build();
    }

    @Bean
    public GroupedOpenApi group8(){
        return GroupedOpenApi.builder()
                .group("상품 찜 기능")
                .pathsToMatch("/favorite/*")
                .packagesToScan("com.shoppingmall.shop.controller.favorite")
                .build();
    }

}
