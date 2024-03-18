package com.shoppingmall.shop.service;

import com.shoppingmall.shop.data.CartDTO;
import com.shoppingmall.shop.data.OrderDetailDTO;
import com.shoppingmall.shop.data.OrdersDTO;
import com.shoppingmall.shop.mapper.CartMapper;
import com.shoppingmall.shop.mapper.OrderMapper;
import com.shoppingmall.shop.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    @Transactional
    public void addOrder(OrdersDTO ordersDTO) {

        // 총 가격 계산
        int totalPriceInt = calculateTotalPrice(ordersDTO.getCtno());
        BigDecimal totalPrice = BigDecimal.valueOf(totalPriceInt);
        ordersDTO.setTotalPrice(totalPrice);

        // 주문 생성
        orderMapper.addOrder(ordersDTO);

        // 주문 번호 가져오기
        String customerId = ordersDTO.getCustomerId();
        int ono = orderMapper.getLastInsertOneById(customerId);

        // 주문 상세 추가
        List<CartDTO> cartList = cartMapper.getCartByCtno(ordersDTO.getCtno());

        for(CartDTO cart : cartList) {
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            orderDetailDTO.setOno(ono);
            orderDetailDTO.setPno(cart.getPno());
            orderDetailDTO.setQuantity(cart.getQuantity());

            // 주문 상세 추가
            orderMapper.addOrderDetail(orderDetailDTO);

            // 주문 완료된 상품 재고 -1 업데이트
            productMapper.updateProductQuantity(cart.getPno());
        }

        // 주문 완료된 장바구니 orderyn 업데이트
        cartMapper.updateOrderyn(ordersDTO.getCtno());
    }

    private int calculateTotalPrice(int ctno) {
        int totalPrice = 0;
        List<CartDTO> cartList = cartMapper.getCartByCtno(ctno);
        for(CartDTO cart : cartList){
            int sellingPrice = productMapper.getSellingPriceByPno(cart.getPno());
            totalPrice += (sellingPrice * cart.getQuantity());
        }
        return totalPrice;
    }

    public void cancelOrder(OrdersDTO ordersDTO) {
        orderMapper.cancelOrder(ordersDTO);
    }

    public List<OrdersDTO> getOrderList(String customerId) {
        return orderMapper.getOrderList(customerId);
    }

    public List<OrderDetailDTO> getOrderDetailList(int ono) {
        return orderMapper.getOrderDetailList(ono);
    }

    public String getOrderStatus(int ono) {
        return orderMapper.getOrderStatus(ono);
    }

    public void updateOrderStatus(OrdersDTO ordersDTO) {
        orderMapper.updateOrderStatus(ordersDTO);
    }

    public void refund(OrdersDTO ordersDTO) {
        orderMapper.refund(ordersDTO);
    }

}
