package com.shoppingmall.shop.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(description = "주문 상세 DTO")
public class OrderDetailDTO {

    @Schema(description = "주문 상세 고유 번호")
    private int odno;
    
    @Schema(description = "주문 고유 번호")
    private int ono;
    
    @Schema(description = "상품 고유 번호")
    private int pno;

    @Schema(description = "주문 수량")
    private int quantity;

}
