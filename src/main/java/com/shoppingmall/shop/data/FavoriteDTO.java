package com.shoppingmall.shop.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(description = "상품 찜 DTO")
public class FavoriteDTO {
    @Schema(description = "찜 상품 고유 번호")
    private int fno;
    
    @Schema(description = "고객 아이디")
    private String customerId;
    
    @Schema(description = "상품 고유 번호")
    private int pno;
}
