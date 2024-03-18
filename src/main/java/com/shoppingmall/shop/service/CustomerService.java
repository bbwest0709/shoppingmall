package com.shoppingmall.shop.service;

import com.shoppingmall.shop.data.AddressDTO;
import com.shoppingmall.shop.data.CustomerDTO;
import com.shoppingmall.shop.mapper.CustomerMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    public void insertCustomer(CustomerDTO customerDTO) {
        customerMapper.insertCustomer(customerDTO);
    }

    public void addAddress(AddressDTO addressDTO) {
        customerMapper.addAddress(addressDTO);
    }

    public void updateAddress(AddressDTO addressDTO) {
        AddressDTO addressInfo = customerMapper.getAddressById(addressDTO.getAddrno());
        System.out.println("기존 주소 정보: " + addressInfo);

        AddressDTO update = new AddressDTO();
        BeanUtils.copyProperties(addressDTO, update);

        if (update.getRecipientName() == null) {
            update.setRecipientName(addressInfo.getRecipientName());
        }
        if (update.getPostalCode() == null) {
            update.setPostalCode(addressInfo.getPostalCode());
        }
        if (update.getAddress() == null) {
            update.setAddress(addressInfo.getAddress());
        }
        if (update.getAddressDetails() == null) {
            update.setAddressDetails(addressInfo.getAddressDetails());
        }
        if (update.getRecipientPhoneNumber() == null) {
            update.setRecipientPhoneNumber(addressInfo.getRecipientPhoneNumber());
        }
        if (update.getDeliveryRequest() == null) {
            update.setDeliveryRequest(addressInfo.getDeliveryRequest());
        }
        if (update.getDefaultAddress() == null) {
            update.setDefaultAddress(addressInfo.getDefaultAddress());
        }

        System.out.println("주소 수정 정보 : " + update);

        customerMapper.updateAddress(update);
    }

    public CustomerDTO getCustomerById(String loginId) {

        CustomerDTO customerDTO = customerMapper.getCustomerById(loginId);

        return customerDTO;
    }
}
