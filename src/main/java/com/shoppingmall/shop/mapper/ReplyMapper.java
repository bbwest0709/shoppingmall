package com.shoppingmall.shop.mapper;

import com.shoppingmall.shop.data.ReplyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {

    void addReply(ReplyDTO replyDTO);

    void updateReply(ReplyDTO replyDTO);

    void deleteReply(ReplyDTO replyDTO);

    List<ReplyDTO> getReplyList();
}
