package com.shoppingmall.shop.controller.order;

import com.shoppingmall.shop.data.CategoryDTO;
import com.shoppingmall.shop.data.OrderDetailDTO;
import com.shoppingmall.shop.data.OrdersDTO;
import com.shoppingmall.shop.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.*;

@Tag(name="주문 기능 모음", description = "여러가지 주문 기능 테스트가 가능합니다.")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "상품 주문", description = "상품을 주문할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "상품 주문 성공", content = @Content(schema = @Schema(implementation = OrdersDTO.class))),
            @ApiResponse(responseCode = "500", description = "상품 주문 실패", content = @Content(schema = @Schema(implementation = OrdersDTO.class))),
    })
    @PostMapping("/order/add")
    public String addOrder(@RequestBody OrdersDTO ordersDTO){
        orderService.addOrder(ordersDTO);
        return ordersDTO.getCustomerId() + "의 주문 완료";
    }

    @Operation(summary = "주문 취소", description = "주문을 취소할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "주문 취소 성공", content = @Content(schema = @Schema(implementation = OrdersDTO.class))),
            @ApiResponse(responseCode = "500", description = "주문 취소 실패", content = @Content(schema = @Schema(implementation = OrdersDTO.class))),
    })
    @PostMapping("/order/cancel")
    public String cancelOrder(@RequestBody OrdersDTO ordersDTO) {
        orderService.cancelOrder(ordersDTO);
        return ordersDTO.getOno() + " 주문 취소 완료";
    }

    @Operation(summary = "주문 목록", description = "주문 목록을 불러올 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "주문 목록 불러오기 성공", content = @Content(schema = @Schema(implementation = OrdersDTO.class))),
            @ApiResponse(responseCode = "500", description = "주문 목록 불러오기 실패", content = @Content(schema = @Schema(implementation = OrdersDTO.class))),
    })
    @GetMapping("/order/list")
    public String orderList(@RequestParam String customerId, Model model){
        List<OrdersDTO> orderlist = orderService.getOrderList(customerId);
        model.addAttribute("orderlist", orderlist);
        return orderlist.toString();
    }

    @Operation(summary = "주문 상세", description = "주문 상세 정보를 확인할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "주문 상세 불러오기 성공", content = @Content(schema = @Schema(implementation = OrderDetailDTO.class))),
            @ApiResponse(responseCode = "500", description = "주문 상세 불러오기 실패", content = @Content(schema = @Schema(implementation = OrderDetailDTO.class))),
    })
    @GetMapping("/order/detail")
    public String orderDetailList(@RequestParam int ono, Model model){
        List<OrderDetailDTO> orderDetailList = orderService.getOrderDetailList(ono);
        model.addAttribute("orderDetailList",orderDetailList);
        return orderDetailList.toString();
    }

    @Operation(summary = "주문 상태 변경", description = "주문 상태를 변경할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "주문 상태 변경 성공", content = @Content(schema = @Schema(implementation = OrdersDTO.class))),
            @ApiResponse(responseCode = "500", description = "주문 상태 변경 실패", content = @Content(schema = @Schema(implementation = OrdersDTO.class))),
    })
    @PostMapping("/order/update")
    public String updateOrderStatus(@RequestBody OrdersDTO ordersDTO) {
        orderService.updateOrderStatus(ordersDTO);
        return ordersDTO.getOno() + " 주문 상태를 변경하였습니다.";
    }

    @Operation(summary = "주문 상태 확인", description = "주문 상태를 확인할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "주문 상태 불러오기 성공", content = @Content(schema = @Schema(implementation = OrdersDTO.class))),
            @ApiResponse(responseCode = "500", description = "주문 상태 불러오기 실패", content = @Content(schema = @Schema(implementation = OrdersDTO.class))),
    })
    @GetMapping("/order/orderStatus")
    public String getOrderStatus(@RequestParam int ono){
        String deliveryStatus = orderService.getOrderStatus(ono);
        return deliveryStatus.toString();
    }

    @Operation(summary = "환불 처리", description = "환불 처리할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "환불 처리 성공", content = @Content(schema = @Schema(implementation = OrdersDTO.class))),
            @ApiResponse(responseCode = "500", description = "환불 처리 실패", content = @Content(schema = @Schema(implementation = OrdersDTO.class))),
    })
    @PostMapping("/order/refund")
    public String refund(@RequestBody OrdersDTO ordersDTO){
        orderService.refund(ordersDTO);
        return ordersDTO.getOno() + " 환불처리 완료";
    }

}
