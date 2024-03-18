package com.shoppingmall.shop.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(description = "답변 DTO")
public class ReplyDTO {

    @Schema(description = "답변 고유 번호")
    private int rpno;

    @Schema(description = "관리자 아이디")
    private String adminId;

    @Schema(description = "답변 타입", allowableValues = {"inquiry", "review"})
    private String replyType;

    @Schema(description = "문의 또는 리뷰 고유 번호")
    private int responseId;
    
    @Schema(description = "답변 내용")
    private String content;
    
    @Schema(description = "생성일")
    private Date regdate;

}
