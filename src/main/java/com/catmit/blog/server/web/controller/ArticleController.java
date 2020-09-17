package com.catmit.blog.server.web.controller;

import com.catmit.blog.server.web.entity.po.ArticlePO;
import com.catmit.blog.server.web.entity.vo.ArticleVO;
import com.catmit.blog.server.web.entity.vo.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/articles")
public class ArticleController {

    @PostMapping("/articles")
    public ArticleVO write(@RequestBody ArticlePO article){
        return new ArticleVO();
    }

    @DeleteMapping("/articles/{articleId}")
    public void deleteArticle(@PathVariable int articleId){

    }

    @PutMapping("/articles/{articleId}")
    public ArticleVO editArticle(@PathVariable int articleId, @RequestBody ArticlePO articlePO){
        return new ArticleVO();
    }

    @GetMapping("/articles")
    public ArticleVO findArticleById(@PathVariable int articleId){
        return new ArticleVO();
    }

    @GetMapping("/articles?offset={offset}&limit={limit}")
    public Page<ArticleVO> listArticles(@PathVariable int offset, @PathVariable int limit){
        return new Page.PageBuilder<ArticleVO>().offset(offset).limit(limit).build();
    }
}
