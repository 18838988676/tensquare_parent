package com.tensquare.article.controller;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.service.CommentService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 * date: 2018/11/28 11:51
 * author: loveLy
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    //根据文章ID查询评论列表
    @RequestMapping(value = "/article/{articleid}",method = RequestMethod.GET)
    public Result findByArticleid(@PathVariable String articleid){
        return new Result(true,StatusCode.OK.getCode(),"查询成功",commentService.findByArticleid(articleid));
    }
//POST body raw JSON(application/json) http://localhost:9004/comment/
/*{
    "_id":"2",
        "articleid":"erq",
        "content":"erqw",
        "userid":"erq",
        "parentid":"re",
        "publishdate":"56454"
}*/

    //文章评论新增
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Comment comment){
        commentService.add(comment);
        return new Result(true,StatusCode.OK.getCode(),"提交成功");
    }
}
