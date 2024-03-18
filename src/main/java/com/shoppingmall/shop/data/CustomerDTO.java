package com.shoppingmall.shop.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(description = "고객 DTO")
public class CustomerDTO {

    @Schema(description = "고객 아이디")
    private String customerId;
    
    @Schema(description = "고객명")
    private String customerName;
    
    @Schema(description = "이메일")
    private String email;
    
    @Schema(description = "비밀번호")
    private String password;
    
    @Schema(description = "전화번호")
    private String phoneNumber;
    
    @Schema(description = "성별", allowableValues = {"여성", "남성"})
    private String gender;
    
    @Schema(description = "사용여부", defaultValue = "Y", allowableValues = {"N", "Y"})
    private String useyn;
    
    @Schema(description = "회원탈퇴 여부", defaultValue = "N", allowableValues = {"N", "Y"})
    private String withdrawn;

}
