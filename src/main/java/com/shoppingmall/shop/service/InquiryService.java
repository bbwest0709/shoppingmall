package com.shoppingmall.shop.service;

import com.shoppingmall.shop.data.InquiryDTO;
import com.shoppingmall.shop.mapper.InquiryMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryService {

    @Autowired
    private InquiryMapper inquiryMapper;


    public void addInquiry(InquiryDTO inquiryDTO) {
        inquiryMapper.addInquiry(inquiryDTO);
    }

    public void updateInquiry(InquiryDTO inquiryDTO) {
        // 기존 문의글 정보
        InquiryDTO inquiryInfo = inquiryMapper.getInquiryById(inquiryDTO.getIno(), inquiryDTO.getCustomerId());

        System.out.println("기존 문의글 정보 : " + inquiryInfo);

        InquiryDTO update = new InquiryDTO();
        BeanUtils.copyProperties(inquiryDTO, update);
        if (update.getCategory() == null) {
            update.setContent(inquiryInfo.getCategory());
        }
        if (update.getTitle() == null) {
            update.setTitle(inquiryInfo.getTitle());
        }
        if (update.getCategory() == null) {
            update.setCategory(inquiryInfo.getContent());
        }

        System.out.println("상품 수정 정보 : " + update);
        inquiryMapper.updateInquiry(update);
    }

    public void deleteInquiry(InquiryDTO inquiryDTO) {
        inquiryMapper.deleteInquiry(inquiryDTO);
    }

    public List<InquiryDTO> getInquiryList(String customerId) {
        return inquiryMapper.getInquiryList(customerId);
    }
}
