package com.shoppingmall.shop.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(description = "리뷰 DTO")
public class ReviewDTO {
    
    @Schema(description = "리뷰 고유 번호")
    private int rno;
    
    @Schema(description = "고객 아이디")
    private String customerId;
    
    @Schema(description = "상품 고유 번호")
    private int pno;
    
    @Schema(description = "별점")
    private int rating;
    
    @Schema(description = "리뷰 내용")
    private String content;
    
    @Schema(description = "생성일")
    private Date regdate;

}
