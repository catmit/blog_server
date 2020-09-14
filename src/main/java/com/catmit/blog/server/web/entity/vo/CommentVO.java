package com.catmit.blog.server.web.entity.vo;

import com.catmit.blog.server.web.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentVO extends BaseEntity {
    private String content;
    private UserVO user;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ReplyVO> replies;
}
