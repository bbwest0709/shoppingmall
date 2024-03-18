package com.shoppingmall.shop.mapper;

import com.shoppingmall.shop.data.OrderDetailDTO;
import com.shoppingmall.shop.data.OrdersDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    void addOrder(OrdersDTO ordersDTO);

    void addOrderDetail(OrderDetailDTO orderDetailDTO);

    void cancelOrder(OrdersDTO ordersDTO);

    int getLastInsertOneById(String customerId);

    List<OrdersDTO> getOrderList(String customerId);

    List<OrderDetailDTO> getOrderDetailList(int ono);

    boolean isProductOrdered(int pno, String customerId);

    String getOrderStatus(int ono);

    void updateOrderStatus(OrdersDTO ordersDTO);

    void refund(OrdersDTO ordersDTO);
}
