package com.shoppingmall.shop.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(description = "관리자 DTO")
public class AdminDTO {

    @Schema(description = "관리자 아이디")
    private String adminId;
    
    @Schema(description = "비밀번호")
    private String password;
    
    @Schema(description = "이메일")
    private String emaill;
}
