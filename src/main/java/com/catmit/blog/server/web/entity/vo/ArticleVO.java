package com.catmit.blog.server.web.entity.vo;

import com.catmit.blog.server.web.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ArticleVO extends BaseEntity {
    private String contentUrl;
    private String coverUrl;
    private String brief;

    private UserVO user;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private LocalDateTime updateTime;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CommentVO> comments;
}
