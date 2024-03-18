package com.shoppingmall.shop.controller.favorite;

import com.shoppingmall.shop.data.CategoryDTO;
import com.shoppingmall.shop.data.FavoriteDTO;
import com.shoppingmall.shop.service.FavoriteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="상품 찜 기능 모음", description = "상품 찜 기능 테스트가 가능합니다.")
@RestController
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Operation(summary = "상품 찜 등록", description = "상품 찜할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "상품 찜 성공", content = @Content(schema = @Schema(implementation = FavoriteDTO.class))),
            @ApiResponse(responseCode = "500", description = "상품 찜 실패", content = @Content(schema = @Schema(implementation = FavoriteDTO.class))),
    })
    @PostMapping("/favorite/add")
    public String addFavorite(@RequestBody FavoriteDTO favoriteDTO){
        favoriteService.addFavorite(favoriteDTO);
        return favoriteDTO.getPno()+ "상품을 찜하였습니다.";
    }

    @Operation(summary = "상품 찜 삭제", description = "찜 상품을 삭제할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "찜 상품 삭제 성공", content = @Content(schema = @Schema(implementation = FavoriteDTO.class))),
            @ApiResponse(responseCode = "500", description = "찜 상품 삭제 실패", content = @Content(schema = @Schema(implementation = FavoriteDTO.class))),
    })
    @PostMapping("/favorite/delete")
    public String deleteFavorite(@RequestBody FavoriteDTO favoriteDTO){
        favoriteService.deleteFavorite(favoriteDTO);
        return favoriteDTO.getFno() + "찜 상품을 삭제하였습니다.";
    }

    @Operation(summary = "찜 상품 목록", description = "찜 상품 목록을 불러올 수 있습니다", responses = {
            @ApiResponse(responseCode="200", description = "찜 상품 목록 불러오기 성공", content = @Content(schema = @Schema(implementation = FavoriteDTO.class))),
            @ApiResponse(responseCode = "500", description = "찜 상품 목록 불러오기 실패", content = @Content(schema = @Schema(implementation = FavoriteDTO.class))),
    })
    @GetMapping("/favorite/list")
    public String getFavoriteList(@RequestParam String customerId, Model model){
        List<FavoriteDTO> favoritelist = favoriteService.getFavoriteList(customerId);
        model.addAttribute("favoritelist", favoritelist);
        return favoritelist.toString();
    }

}
