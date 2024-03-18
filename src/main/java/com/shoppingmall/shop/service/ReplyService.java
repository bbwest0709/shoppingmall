package com.shoppingmall.shop.service;

import com.shoppingmall.shop.data.ReplyDTO;
import com.shoppingmall.shop.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    public void addReply(ReplyDTO replyDTO) {
        replyMapper.addReply(replyDTO);
    }

    public void updateReply(ReplyDTO replyDTO) {
        replyMapper.updateReply(replyDTO);
    }

    public void deleteReply(ReplyDTO replyDTO) {
        replyMapper.deleteReply(replyDTO);
    }

    public List<ReplyDTO> getReplyList() {
        return replyMapper.getReplyList();
    }
}
