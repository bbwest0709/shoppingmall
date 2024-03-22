package com.shoppingmall.shop.controller.product;

import com.shoppingmall.shop.data.BrandDTO;
import com.shoppingmall.shop.data.CategoryDTO;
import com.shoppingmall.shop.data.ProductDTO;
import com.shoppingmall.shop.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Tag(name="상품 기능 모음", description = "여러가지 상품 기능 테스트가 가능합니다.")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Operation(summary = "카테고리 등록", description = "상품 카테고리를 추가할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "카테고리 등록 성공", content = @Content(schema = @Schema(implementation = CategoryDTO.class))),
            @ApiResponse(responseCode = "500", description = "카테고리 등록 실패", content = @Content(schema = @Schema(implementation = CategoryDTO.class))),
    })
    @PostMapping("/category/add")
    public String addCategory(@RequestBody CategoryDTO categoryDTO) {
        productService.addCategory(categoryDTO);
        return "카테고리 등록 완료";
    }

    @Operation(summary = "카테고리 삭제", description = "카테고리를 삭제할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "카테고리 삭제 성공", content = @Content(schema = @Schema(implementation = CategoryDTO.class))),
            @ApiResponse(responseCode = "500", description = "카테고리 삭제 실패", content = @Content(schema = @Schema(implementation = CategoryDTO.class))),
    })
    @PostMapping("/category/delete")
    public String deleteCategory(@RequestBody CategoryDTO categoryDTO){
        productService.deleteCategory(categoryDTO);
        return categoryDTO.getCategoryName() + " 카테고리 삭제 완료";
    }

    @Operation(summary = "브랜드 등록", description = "상품 브랜드를 추가할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "브랜드 등록 성공", content = @Content(schema = @Schema(implementation = BrandDTO.class))),
            @ApiResponse(responseCode = "500", description = "브랜드 등록 실패", content = @Content(schema = @Schema(implementation = BrandDTO.class))),
    })
    @PostMapping("/brand/add")
    public String addBrand(@RequestBody BrandDTO brandDTO) {
        productService.addBrand(brandDTO);
        return "브랜드 등록 완료";
    }

    @Operation(summary = "브랜드 삭제", description = "상품 브랜드를 삭제할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "브랜드 삭제 성공", content = @Content(schema = @Schema(implementation = BrandDTO.class))),
            @ApiResponse(responseCode = "500", description = "브랜드 삭제 실패", content = @Content(schema = @Schema(implementation = BrandDTO.class))),
    })
    @PostMapping("/brand/delete")
    public String deleteBrand(@RequestBody BrandDTO brandDTO){
        productService.deleteBrand(brandDTO);
        return brandDTO.getBrandName() + " 브랜드 삭제 완료";
    }

    @Operation(summary = "상품 등록", description = "상품을 추가할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "상품 등록 성공", content = @Content(schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "500", description = "상품 등록 실패", content = @Content(schema = @Schema(implementation = ProductDTO.class))),
    })
    @PostMapping("/product/add")
    public String addProduct(@RequestBody ProductDTO productDTO) {
        productService.addProduct(productDTO);
        return productDTO.getProductName() + " 등록 완료";
    }

    @Operation(summary = "상품 목록", description = "상품 목록을 불러올 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "상품 목록 불러오기 성공", content = @Content(schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "500", description = "상품 목록 불러오기 실패", content = @Content(schema = @Schema(implementation = ProductDTO.class))),
    })
    @GetMapping("/product/list")
    public String productList(Model model) {
        List<ProductDTO> productlist = productService.getProductList();
        model.addAttribute("productlist",productlist);
        return productlist.toString();
    }

    @Operation(summary = "상품 상세 보기", description = "상품 상세 정보를 확인할 수 있습니다.")
    @GetMapping("/product/detail")
    public String productWithBrand(@RequestParam int pno, Model model){
        ProductDTO productDetail = productService.getProductWithBrand(pno);
        model.addAttribute("productDetail", productDetail);
        System.out.println(productDetail);
        return pno + " 상품 상세 보기: " + productDetail;
    }

    @Operation(summary = "상품 수정", description = "상품 정보를 수정할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "상품 수정 성공", content = @Content(schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "500", description = "상품 수정 실패", content = @Content(schema = @Schema(implementation = ProductDTO.class))),
    })
    @PostMapping("/product/update")
    public String updateProduct(@RequestBody ProductDTO productDTO) {
        productService.updateProduct(productDTO);
        return productDTO.getPno() + " 상품 수정 완료";
    }

    @Operation(summary = "상품 삭제", description = "상품을 삭제할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "상품 삭제 성공", content = @Content(schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "500", description = "상품 삭제 실패", content = @Content(schema = @Schema(implementation = ProductDTO.class))),
    })
    @PostMapping("/product/delete")
    public String deleteProduct(@RequestBody ProductDTO productDTO) {
        productService.deleteProduct(productDTO);
        return productDTO.getPno() + " 상품 삭제 완료";
    }

}
