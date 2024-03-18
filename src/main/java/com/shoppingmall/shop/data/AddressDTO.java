package com.shoppingmall.shop.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(description = "주소지 DTO")
public class AddressDTO {

    @Schema(description = "주소지 고유번호")
    private int addrno;

    @Schema(description = "고객 아이디")
    private String customerId;

    @Schema(description = "받는 이 이름")
    private String recipientName;

    @Schema(description = "우편번호")
    private String postalCode;

    @Schema(description = "주소")
    private String address;

    @Schema(description = "상세주소")
    private String addressDetails;

    @Schema(description = "받는 이 전화번호")
    private String recipientPhoneNumber;

    @Schema(description = "배송 요청 사항")
    private String deliveryRequest;

    @Schema(description = "기본 배송지 여부", allowableValues = {"N", "Y"})
    private String defaultAddress;

}
