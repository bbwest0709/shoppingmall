package com.shoppingmall.shop.controller.inquiry;

import com.shoppingmall.shop.data.CategoryDTO;
import com.shoppingmall.shop.data.InquiryDTO;
import com.shoppingmall.shop.service.InquiryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="문의글 기능 모음", description = "여러가지 문의글 기능 테스트가 가능합니다.")
@RestController
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    @Operation(summary = "문의글 등록", description = "문의글을 등록할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "문의글 등록 성공", content = @Content(schema = @Schema(implementation = InquiryDTO.class))),
            @ApiResponse(responseCode = "500", description = "문의글 등록 실패", content = @Content(schema = @Schema(implementation = InquiryDTO.class))),
    })
    @PostMapping("/inquiry/add")
    public String addInquiry(@RequestBody InquiryDTO inquiryDTO) {
        inquiryService.addInquiry(inquiryDTO);
        return inquiryDTO.getCategory() + "글 등록 완료";
    }

    @Operation(summary = "문의글 수정", description = "문의글을 수정할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "문의글 수정 성공", content = @Content(schema = @Schema(implementation = InquiryDTO.class))),
            @ApiResponse(responseCode = "500", description = "문의글 수정 실패", content = @Content(schema = @Schema(implementation = InquiryDTO.class))),
    })
    @PostMapping("/inquiry/update")
    public String updateInquiry(@RequestBody InquiryDTO inquiryDTO) {
        inquiryService.updateInquiry(inquiryDTO);
        return inquiryDTO.getIno() + " 문의글 수정 완료";
    }

    @Operation(summary = "문의글 삭제", description = "문의글을 삭제할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "문의글 삭제 성공", content = @Content(schema = @Schema(implementation = InquiryDTO.class))),
            @ApiResponse(responseCode = "500", description = "문의글 삭제 실패", content = @Content(schema = @Schema(implementation = InquiryDTO.class))),
    })
    @PostMapping("/inquiry/delete")
    public String deleteInquiry(@RequestBody InquiryDTO inquiryDTO) {
        inquiryService.deleteInquiry(inquiryDTO);
        return inquiryDTO.getIno() + " 문의글 삭제 완료";
    }

    @Operation(summary = "문의글 목록", description = "문의글 목록을 불러올 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "문의글 목록 불러오기 성공", content = @Content(schema = @Schema(implementation = InquiryDTO.class))),
            @ApiResponse(responseCode = "500", description = "문의글 목록 불러오기 실패", content = @Content(schema = @Schema(implementation = InquiryDTO.class))),
    })
    @GetMapping("/inquiry/list")
    public String getInquiryList(@RequestParam String customerId, Model model){
        List<InquiryDTO> inquirylist = inquiryService.getInquiryList(customerId);
        model.addAttribute("inquirylist", inquirylist);
        return inquirylist.toString();
    }

}
