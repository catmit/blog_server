package com.catmit.blog.server.web.controller;

import com.catmit.blog.server.web.model.po.ArticlePO;
import com.catmit.blog.server.web.model.vo.ArticleVO;
import com.catmit.blog.server.web.model.vo.Page;
import com.catmit.blog.server.web.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping("/articles")
    public ArticleVO write(@RequestBody ArticlePO article){
       return articleService.write(article);
    }

    @DeleteMapping("/articles/{articleId}")
    public void deleteArticle(@PathVariable int articleId){
        articleService.deleteArticle(articleId);
    }

    @PutMapping("/articles/{articleId}")
    public ArticleVO editArticle(@RequestBody ArticlePO articlePO){
        return articleService.updateArticle(articlePO);
    }

    @GetMapping("/articles/{urlTitle}")
    public ArticleVO findArticleByTitle(@PathVariable String urlTitle){
        return articleService.getArticleVOByUrlTitle(urlTitle);
    }

    @GetMapping("/articles?offset={offset}&limit={limit}")
    public Page<ArticleVO> listArticles(@PathVariable int offset, @PathVariable int limit){
        return articleService.listArticles(offset, limit);
    }
}
