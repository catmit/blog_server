package com.catmit.blog.server.web.service;

import com.catmit.blog.server.web.dao.CommentDAO;
import com.catmit.blog.server.web.model.po.CommentPO;
import com.catmit.blog.server.web.model.vo.ApiResult;
import com.catmit.blog.server.web.model.vo.CommentVO;
import com.catmit.blog.server.web.model.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentDAO commentDAO;

    public CommentVO addComment(CommentPO comment){
        return commentDAO.addComment(comment);
    }

    public ApiResult deleteComment(int id){
        commentDAO.deleteComment(id);
        return ApiResult.success("删除成功");
    }

    public Page listArticleComments(int articleId, int offset, int limit){
        Page.PageBuilder pageBuilder = new Page.PageBuilder<>().offset(offset).limit(limit);
        return pageBuilder.data(commentDAO.listArticleComments(pageBuilder))
                .count(commentDAO.countArticleComments(articleId))
                .build();
    }

    public Page listUserComments(int userId, int offset, int limit){
        Page.PageBuilder pageBuilder = new Page.PageBuilder<>().offset(offset).limit(limit);
        return pageBuilder.data(commentDAO.listUserComments(pageBuilder))
                .count(commentDAO.countUserComments(userId))
                .build();
    }
}
