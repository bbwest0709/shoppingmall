package com.shoppingmall.shop.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(description = "문의글 DTO")
public class InquiryDTO {

    @Schema(description = "문의글 고유 번호")
    private int ino;
    
    @Schema(description = "고객 아이디")
    private String customerId;
    
    @Schema(description = "문의글 종류 카테고리")
    private String category;
    
    @Schema(description = "문의글 제목")
    private String title;
    
    @Schema(description = "문의글 내용")
    private String content;
    
    @Schema(description = "생성일")
    private Date regdate;

    @Schema(description = "문의글 상태 여부", defaultValue = "문의중", allowableValues = {"문의중", "답변완료"})
    private String status;
}
