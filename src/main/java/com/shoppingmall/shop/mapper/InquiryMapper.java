package com.shoppingmall.shop.mapper;

import com.shoppingmall.shop.data.InquiryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InquiryMapper {

    void addInquiry(InquiryDTO inquiryDTO);

    void updateInquiry(InquiryDTO inquiryDTO);

    InquiryDTO getInquiryById(int ino, String customerId);

    void deleteInquiry(InquiryDTO inquiryDTO);

    List<InquiryDTO> getInquiryList(String customerId);
}
