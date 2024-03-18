package com.shoppingmall.shop.controller.reply;

import com.shoppingmall.shop.data.CategoryDTO;
import com.shoppingmall.shop.data.ReplyDTO;
import com.shoppingmall.shop.service.ReplyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="답변 기능 모음", description = "여러가지 답변 기능 테스트가 가능합니다.")
@RestController
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @Operation(summary = "답변 등록", description = "답변을 등록할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "답변 등록 성공", content = @Content(schema = @Schema(implementation = ReplyDTO.class))),
            @ApiResponse(responseCode = "500", description = "답변 등록 실패", content = @Content(schema = @Schema(implementation = ReplyDTO.class))),
    })
    @PostMapping("/reply/add")
    public String addReply(@RequestBody ReplyDTO replyDTO){
        replyService.addReply(replyDTO);
        return replyDTO.getResponseId() + " 답변 완료";
    }

    @Operation(summary = "답변 수정", description = "답변을 수정할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "답변 수정 성공", content = @Content(schema = @Schema(implementation = ReplyDTO.class))),
            @ApiResponse(responseCode = "500", description = "답변 수정 실패", content = @Content(schema = @Schema(implementation = ReplyDTO.class))),
    })
    @PostMapping("/reply/update")
    public String updateReply(@RequestBody ReplyDTO replyDTO){
        replyService.updateReply(replyDTO);
        return replyDTO.getRpno() + "를 수정하였습니다.";
    }

    @Operation(summary = "답변 삭제", description = "답변을 삭제할 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "답변 삭제 성공", content = @Content(schema = @Schema(implementation = ReplyDTO.class))),
            @ApiResponse(responseCode = "500", description = "답변 삭제 실패", content = @Content(schema = @Schema(implementation = ReplyDTO.class))),
    })
    @PostMapping("/reply/delete")
    public String deleteReply(@RequestBody ReplyDTO replyDTO){
        replyService.deleteReply(replyDTO);
        return replyDTO.getRpno() + "를 삭제하였습니다.";
    }

    @Operation(summary = "답변 목록", description = "답변 목록을 불러올 수 있습니다.", responses = {
            @ApiResponse(responseCode="200", description = "답변 목록 불러오기 성공", content = @Content(schema = @Schema(implementation = ReplyDTO.class))),
            @ApiResponse(responseCode = "500", description = "답변 목록 불러오기 실패", content = @Content(schema = @Schema(implementation = ReplyDTO.class))),
    })
    @GetMapping("/reply/list")
    public String getReplyList(Model model) {
        List<ReplyDTO> replylist = replyService.getReplyList();
        model.addAttribute("replylist", replylist);
        return replylist.toString();
    }

}
