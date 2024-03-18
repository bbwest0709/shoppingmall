package com.shoppingmall.shop.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(description = "카테고리 DTO")
public class CategoryDTO {

    @Schema(description = "카테고리 고유 번호")
    private int cgno;
    
    @Schema(description = "카테고리명")
    private String categoryName;
    
    @Schema(description = "사용여부", defaultValue = "Y", allowableValues = {"N", "Y"})
    private String useyn;
}
