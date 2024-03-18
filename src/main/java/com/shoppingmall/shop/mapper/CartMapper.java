package com.shoppingmall.shop.mapper;

import com.shoppingmall.shop.data.CartDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;

@Mapper
public interface CartMapper {
    void addCart(CartDTO cartDTO);

    void deleteCart(CartDTO cartDTO);

    List<CartDTO> getCartList(String customerId);
    List<CartDTO> getCartByCtno(int ctno);

    void updateOrderyn(int ctno);
}
