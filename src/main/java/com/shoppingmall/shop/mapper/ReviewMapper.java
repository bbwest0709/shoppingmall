package com.shoppingmall.shop.mapper;

import com.shoppingmall.shop.data.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface ReviewMapper {
    void addReview(ReviewDTO reviewDTO);

    List<ReviewDTO> getReviewList(String customerId);

    void updateReview(ReviewDTO reviewDTO);

    ReviewDTO getReviewById(int pno);
}
