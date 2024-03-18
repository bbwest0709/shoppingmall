package com.shoppingmall.shop.service;

import com.shoppingmall.shop.data.CartDTO;
import com.shoppingmall.shop.data.ProductDTO;
import com.shoppingmall.shop.mapper.CartMapper;
import com.shoppingmall.shop.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartMapper cartMapper;
    @Autowired
    ProductMapper productMapper;

    public List<CartDTO> getCartList(String customerId) {
        return cartMapper.getCartList(customerId);
    }

    public void addCart(CartDTO cartDTO) {
        // 재고 수량 확인
        ProductDTO productInfo = productMapper.getProductById(cartDTO.getPno());

        if (productInfo != null && productInfo.getQuantity() > 0) {
            cartMapper.addCart(cartDTO);
        } else {
            throw new RuntimeException("품절 상품입니다.");
        }
    }

    public void deleteCart(CartDTO cartDTO) {
        cartMapper.deleteCart(cartDTO);
    }

}
