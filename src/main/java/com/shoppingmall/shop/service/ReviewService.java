package com.shoppingmall.shop.service;

import com.shoppingmall.shop.data.ReviewDTO;
import com.shoppingmall.shop.mapper.OrderMapper;
import com.shoppingmall.shop.mapper.ReviewMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private OrderMapper orderMapper;


    public void addReview(ReviewDTO reviewDTO) throws Exception {
        // 주문 상품인지 확인
        boolean isOrdered = orderMapper.isProductOrdered(reviewDTO.getPno(), reviewDTO.getCustomerId());

        System.out.println("확인용: " + isOrdered);

        if (isOrdered) {
            reviewMapper.addReview(reviewDTO);
        } else {
            throw new Exception("이 상품을 구매한 이력이 없습니다.");
        }
    }

    public List<ReviewDTO> getReviewList(String customerId){
        return reviewMapper.getReviewList(customerId);
    }

    public void updateReview(ReviewDTO reviewDTO) {
        // 리뷰 목록
        ReviewDTO reviewInfo = reviewMapper.getReviewById(reviewDTO.getRno());

        System.out.println("기존 리뷰 정보: " + reviewInfo);

        ReviewDTO update = new ReviewDTO();
        BeanUtils.copyProperties(reviewDTO, update);

        if(update.getRating() == 0) {
            update.setRating(reviewInfo.getRating());
        }
        if(update.getContent() == null) {
            update.setContent(reviewInfo.getContent());
        }
        System.out.println("수정된 리뷰: " + update);
        reviewMapper.updateReview(update);
    }
}
