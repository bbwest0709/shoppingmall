package com.shoppingmall.shop.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(description = "브랜드 DTO")
public class BrandDTO {

    @Schema(description = "브랜드 고유번호")
    private int bno;

    @Schema(description = "브랜드명")
    private String brandName;

    @Schema(description = "브랜드 이미지 경로")
    private String brandImage;

    @Schema(description = "카테고리 고유 번호")
    private int cgno;

}
