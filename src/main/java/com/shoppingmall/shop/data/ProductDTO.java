package com.shoppingmall.shop.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(description = "상품 DTO")
public class ProductDTO {

    @Schema(description = "상품 고유 번호")
    private int pno;
    
    @Schema(description = "상품명")
    private String productName;
    
    @Schema(description = "상품 이미지 경로")
    private String productImage;
    
    @Schema(description = "상품 설명")
    private String description;
    
    @Schema(description = "원가")
    private int price;
    
    @Schema(description = "판매가")
    private int sellingPrice;
    
    @Schema(description = "재고 수량")
    private int quantity;
    
    @Schema(description = "사용여부", defaultValue = "Y", allowableValues = {"N", "Y"})
    private String useyn;
    
    @Schema(description = "생성일")
    private Date regdate;
    
    @Schema(description = "브랜드 고유 번호")
    private int bno;

    private BrandDTO brand;

}
