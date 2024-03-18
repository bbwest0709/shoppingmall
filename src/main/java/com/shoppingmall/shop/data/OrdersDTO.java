package com.shoppingmall.shop.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(description = "주문 DTO")
public class OrdersDTO {
    
    @Schema(description = "주문 고유 번호")
    private int ono;
    
    @Schema(description = "장바구니 고유 번호")
    private int ctno;
    
    @Schema(description = "고객 아이디")
    private String customerId;
    
    @Schema(description = "주문 상태", defaultValue = "결제 완료", allowableValues = {"결제 완료", "배송중", "배송완료", "주문취소"})
    private String orderStatus;
    
    @Schema(description = "총 주문 금액")
    private BigDecimal totalPrice;
    
    @Schema(description = "결제 방식")
    private String paymentInfo;
    
    @Schema(description = "환불여부", defaultValue = "N", allowableValues = {"N", "Y"})
    private String refundStatus;
    
    @Schema(description = "생성일")
    private Date regdate;

}
