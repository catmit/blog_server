package com.catmit.blog.server.web.service;

import com.catmit.blog.server.web.dao.ReplyDAO;
import com.catmit.blog.server.web.model.po.ReplyPO;
import com.catmit.blog.server.web.model.vo.ApiResult;
import com.catmit.blog.server.web.model.vo.Page;
import com.catmit.blog.server.web.model.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    @Autowired
    ReplyDAO replyDAO;

    public ReplyVO addReply(ReplyPO reply){
        return replyDAO.addReply(reply);
    }
    public ApiResult deleteResult(int id){
        replyDAO.deleteReply(id);
        return ApiResult.success("删除成功");
    }
    public Page listReply(int replyId, int offset, int limit){
        Page.PageBuilder pageBuilder = new Page.PageBuilder().offset(offset).limit(limit);
        return pageBuilder.data(replyDAO.listReplies(pageBuilder))
                .count(replyDAO.countArticleReplies(replyId))
                .build();
    }
}
