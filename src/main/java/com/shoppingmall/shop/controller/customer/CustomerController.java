package com.shoppingmall.shop.controller.customer;

import com.shoppingmall.shop.data.AddressDTO;
import com.shoppingmall.shop.data.CategoryDTO;
import com.shoppingmall.shop.data.CustomerDTO;
import com.shoppingmall.shop.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

@Tag(name="고객 기능 모음", description = "여러가지 고객 기능 테스트가 가능합니다.")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Operation(summary = "회원가입", description = "회원가입을 할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "회원가입 성공", content = @Content(schema = @Schema(implementation = CustomerDTO.class))),
            @ApiResponse(responseCode = "500", description = "회원가입 실패", content = @Content(schema = @Schema(implementation = CustomerDTO.class))),
    })
    @PostMapping("/customer/join")
    public String join(@RequestBody CustomerDTO customerDTO) {
        customerService.insertCustomer(customerDTO);
        System.out.println(customerDTO);
        return customerDTO.getCustomerId() + " 회원 가입 완료";
    }

    @Operation(summary = "로그인", description = "로그인을 할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "로그인 성공", content = @Content(schema = @Schema(implementation = CustomerDTO.class))),
            @ApiResponse(responseCode = "500", description = "로그인 실패", content = @Content(schema = @Schema(implementation = CustomerDTO.class))),
    })
    @PostMapping("/customer/login")
    public String login(@RequestBody CustomerDTO customerDTO, HttpServletRequest request) {
        String loginId = customerDTO.getCustomerId();
        String password = customerDTO.getPassword();

        CustomerDTO checkUser = customerService.getCustomerById(loginId);

        if (checkUser != null && checkUser.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", checkUser);

            return loginId + " 로그인 성공";
        } else {
            return "아이디 또는 비밀번호가 일치하지 않습니다.";
        }
    }

    @Operation(summary = "로그아웃", description = "로그아웃을 할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "로그아웃 성공", content = @Content(schema = @Schema(implementation = CustomerDTO.class))),
            @ApiResponse(responseCode = "500", description = "로그아웃 실패", content = @Content(schema = @Schema(implementation = CustomerDTO.class))),
    })
    @GetMapping("/customer/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "로그아웃 완료";
    }

    @Operation(summary = "주소지 추가", description = "주소지를 추가할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "주소지 추가 성공", content = @Content(schema = @Schema(implementation = AddressDTO.class))),
            @ApiResponse(responseCode = "500", description = "주소지 추가 실패", content = @Content(schema = @Schema(implementation = AddressDTO.class))),
    })
    @PostMapping("/customer/address")
    public String addAddress(@RequestBody AddressDTO addressDTO) {
        customerService.addAddress(addressDTO);
        System.out.println(addressDTO);
        return addressDTO.getCustomerId() + "의 주소 저장 완료";
    }

    @Operation(summary = "주소지 수정", description = "주소지를 수정할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "주소지 수정 성공", content = @Content(schema = @Schema(implementation = AddressDTO.class))),
            @ApiResponse(responseCode = "500", description = "주소지 수정 실패", content = @Content(schema = @Schema(implementation = AddressDTO.class))),
    })
    @PostMapping("/customer/updateAddress")
    public String updateAddress(@RequestBody AddressDTO addressDTO) {
        customerService.updateAddress(addressDTO);
        System.out.println(addressDTO);
        return addressDTO.getAddrno() + " 주소 수정 완료";
    }

}
