package com.catmit.blog.server.web.controller;

import com.catmit.blog.server.web.model.po.ReplyPO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReplyController {

    @PostMapping("/replies")
    public void addReply(@RequestBody ReplyPO reply){

    }

    @DeleteMapping("/replies/{replyId}")
    public void deleteReply(@PathVariable int replyId){

    }

    @GetMapping("/replies?offset={offset}&limit={limit}")
    public void ListReplies(@PathVariable int offset, @PathVariable int limit){

    }
}
