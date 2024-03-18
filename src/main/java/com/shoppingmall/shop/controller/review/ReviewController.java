package com.shoppingmall.shop.controller.review;

import com.shoppingmall.shop.data.ReplyDTO;
import com.shoppingmall.shop.data.ReviewDTO;
import com.shoppingmall.shop.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="리뷰 기능 모음", description = "여러가지 리뷰 기능 테스트가 가능합니다.")
@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Operation(summary = "리뷰 등록", description = "리뷰를 등록할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "리뷰 등록 성공", content = @Content(schema = @Schema(implementation = ReviewDTO.class))),
            @ApiResponse(responseCode = "500", description = "리뷰 등록 실패", content = @Content(schema = @Schema(implementation = ReviewDTO.class))),
    })
    @PostMapping("/review/add")
    public String addReview(@RequestBody ReviewDTO reviewDTO){
        try{
            reviewService.addReview(reviewDTO);
            return reviewDTO.getPno() + " 리뷰 등록 완료";
        } catch (Exception e){
            return "리뷰 등록 실패";
        }
    }

    @Operation(summary = "리뷰 목록", description = "리뷰 목록을 불러올 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "리뷰 목록 불러오기 성공", content = @Content(schema = @Schema(implementation = ReviewDTO.class))),
            @ApiResponse(responseCode = "500", description = "리뷰 목록 불러오기 실패", content = @Content(schema = @Schema(implementation = ReviewDTO.class))),
    })
    @GetMapping("/review/list")
    public String getReviewList(@RequestParam String customerId, Model model){
        List<ReviewDTO> reviewlist = reviewService.getReviewList(customerId);
        model.addAttribute("reviewlist",reviewlist);
        System.out.println(customerId + "의 리뷰 목록 : " + reviewlist);
        return reviewlist.toString();
    }

    @Operation(summary = "리뷰 수정", description = "리뷰를 수정할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "리뷰 수정 성공", content = @Content(schema = @Schema(implementation = ReviewDTO.class))),
            @ApiResponse(responseCode = "500", description = "리뷰 수정 실패", content = @Content(schema = @Schema(implementation = ReviewDTO.class))),
    })
    @PostMapping("/review/update")
    public String updateReview(@RequestBody ReviewDTO reviewDTO) {
        reviewService.updateReview(reviewDTO);
        return reviewDTO.getRno() + " 리뷰 수정 완료";
    }

}
