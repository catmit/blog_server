package com.catmit.blog.server.web.controller;

import com.catmit.blog.server.web.model.po.CommentPO;
import com.catmit.blog.server.web.model.vo.ApiResult;
import com.catmit.blog.server.web.model.vo.CommentVO;
import com.catmit.blog.server.web.model.vo.Page;
import com.catmit.blog.server.web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/comments/user/{userId}?offset={offset}&limit={limit}")
    public CommentVO addComment(@RequestBody CommentPO comment, @PathVariable int userId, @PathVariable int offset, @PathVariable int limit){
        return commentService.addComment(comment);
    }
    @DeleteMapping("/comments/{commentId}")
    public ApiResult deleteComment(@PathVariable int commentId){
        return commentService.deleteComment(commentId);
    }

    @GetMapping("/comments/article/{articleId}?offset={offset}&limit={limit}")
    public Page listArticleComments(@PathVariable int articleId, @PathVariable int offset, @PathVariable int limit){
        return commentService.listArticleComments(articleId, offset, limit);
    }

    @GetMapping("/comments/user/{userId}?offset={offset}&limit={limit}")
    public Page listUserComment(@PathVariable int userId, @PathVariable int offset, @PathVariable int limit){
        return commentService.listUserComments(userId, offset, limit);
    }


}
