package com.tensquare.recruit.controller;

import com.tensquare.recruit.pojo.Label;
import com.tensquare.recruit.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@CrossOrigin            // 跨域
@RefreshScope   // 这是在spring cloud config 管理的配置文件在修改后，仍然需要重新启动服务器后的解决办法；
@RequestMapping("/label")
public class LabelController {
    @Resource(name = "labelService")
    private LabelService service;
    @Value("${sms.ip}")
    private String ip;

    @RequestMapping(value = "/ip", method = RequestMethod.GET)
    public String ip() {
        return ip;
    }

    //GET http://localhost:9001/label
    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.OK.getCode(), "查询成功", service.findAll());
    }
    //GET http://localhost:9001/label/2
    @GetMapping("/{labelId}")
    public Result findById(@PathVariable("labelId") String id) {
        System.out.println("9901");
        return new Result(true, StatusCode.OK.getCode(), "查询成功", service.findById(id));
    }
    // POST  Body   http://localhost:9001/label/  raw   JSON(application/json)
/*{
    "id": "10",
        "labelname": "addTest",
        "state": "0",
        "count": 9,
        "recommend": "a"
}*/
    @PostMapping
    public Result save(@RequestBody Label label) {
        service.save(label);
        return new Result(true, StatusCode.OK.getCode(), "添加成功");
    }

    //    PUT body http://localhost:9001/label/1156838842108547072 raw ...
/*
    {
        "id": "",
            "labelname": "00",
            "state": "0",
            "count": 9,
            "recommend": "b"
    }*/
    @PutMapping("/{labelId}")
    public Result update(@PathVariable("labelId") String id, @RequestBody Label label) {
        label.setId(id);
        service.update(label);
        return new Result(true, StatusCode.OK.getCode(), "修改成功");
    }
    //DELETE .. http://localhost:9001/label/1156838842108547072
    @DeleteMapping("/{labelId}")
    public Result deleteById(@PathVariable("labelId") String id) {
        service.deleteById(id);
        return new Result(true, StatusCode.OK.getCode(), "删除成功");
    }
// POST http://localhost:9001/label/search

    /*{
        "labelname": "4"
    }*/
    @PostMapping("/search")
    public Result findSearch(@RequestBody Label label) {
        List<Label> list = service.findSearch(label);
        return new Result(true, StatusCode.OK.getCode(), "查询成功", list);
    }
    // POST http://localhost:9001/label/search/1/2
/*{
    "labelname": ""
}
*/
/*{
    "labelname": "4"
}*/
    @PostMapping("/search/{page}/{size}")
    public Result pageQuery(@RequestBody Label label, @PathVariable("page") int currentPage, @PathVariable("size") int pageSize) {
        Page<Label> pageData = service.pageQuery(label, currentPage, pageSize);
        return new Result(true, StatusCode.OK.getCode(), "查询成功",
                new PageResult<>(pageData.getTotalElements(), pageData.getContent()));
    }
}
