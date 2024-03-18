package com.shoppingmall.shop.controller.cart;

import com.shoppingmall.shop.data.CartDTO;
import com.shoppingmall.shop.data.CustomerDTO;
import com.shoppingmall.shop.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="장바구니 기능 모음", description = "여러가지 장바구니 기능 테스트가 가능합니다.")
@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @Operation(summary = "장바구니 상품 추가", description = "장바구니에 상품을 추가할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "장바구니 상품 추가 성공", content = @Content(schema = @Schema(implementation = CartDTO.class))),
            @ApiResponse(responseCode = "500", description = "장바구니 상품 추가 실패", content = @Content(schema = @Schema(implementation = CartDTO.class))),
    })
    @PostMapping("/cart/add")
    public String addCart(@RequestBody CartDTO cartDTO){
        cartService.addCart(cartDTO);
        return cartDTO.getPno() + " 장바구니에 담기 완료";
    }

    @Operation(summary = "장바구니 상품 삭제", description = "장바구니에 상품을 삭제할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "장바구니 상품 삭제 성공", content = @Content(schema = @Schema(implementation = CartDTO.class))),
            @ApiResponse(responseCode = "500", description = "장바구니 상품 삭제 실패", content = @Content(schema = @Schema(implementation = CartDTO.class))),
    })
    @PostMapping("/cart/delete")
    public String deleteCart(@RequestBody CartDTO cartDTO){
        cartService.deleteCart(cartDTO);
        return cartDTO.getPno() + " 장바구니에서 삭제 완료";
    }

    @Operation(summary = "장바구니 상품 목록", description = "장바구니에 상품 목록을 불러올 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "장바구니 상품 목록 불러오기 성공", content = @Content(schema = @Schema(implementation = CartDTO.class))),
            @ApiResponse(responseCode = "500", description = "장바구니 상품 목록 불러오기 실패", content = @Content(schema = @Schema(implementation = CartDTO.class))),
    })
    @GetMapping("/cart/list")
    public String cartList(@RequestParam String customerId, Model model){
        List<CartDTO> cartlist = cartService.getCartList(customerId);
        model.addAttribute("cartlist", cartlist);
        System.out.println(customerId + "의 장바구니 목록: " + cartlist);
        return cartlist.toString();
    }

}
