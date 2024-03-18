package com.shoppingmall.shop.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(description = "장바구니 DTO")
public class CartDTO {

    @Schema(description = "장바구니 고유 번호")
    private int ctno;
    
    @Schema(description = "고객 아이디")
    private String customerId;
    
    @Schema(description = "상품 고유 번호")
    private int pno;
    
    @Schema(description = "재고 수량")
    private int quantity;
    
    @Schema(description = "주문 완료 여부", defaultValue = "N", allowableValues = {"N", "Y"})
    private String orderyn;
    
    @Schema(description = "생성일")
    private Date regdate;

}
