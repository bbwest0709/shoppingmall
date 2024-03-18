package com.shoppingmall.shop.mapper;

import com.shoppingmall.shop.data.AddressDTO;
import com.shoppingmall.shop.data.CustomerDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    void insertCustomer(CustomerDTO customerDTO);

    void addAddress(AddressDTO addressDTO);

    void updateAddress(AddressDTO addressDTO);

    AddressDTO getAddressById(int addrno);

    CustomerDTO getCustomerById(String loginId);
}
