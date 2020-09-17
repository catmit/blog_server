package com.catmit.blog.server.web.controller;

import com.catmit.blog.server.web.entity.po.CommentPO;
import com.catmit.blog.server.web.entity.vo.CommentVO;
import com.catmit.blog.server.web.entity.vo.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentController {

    @GetMapping("/comments?offset={offset}&limit={limit}")
    public Page<CommentVO> listComments(@PathVariable int offset, @PathVariable int limit){
        Page<CommentVO> comments = new Page.PageBuilder<CommentVO>().offset(offset).limit(limit).build();
        return comments;
    }

    @PostMapping("/comments")
    public void addComment(@RequestBody CommentPO comment){

    }
    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable int commentId){
        return;
    }
}
