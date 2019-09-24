package com.znlccy.recruit.controller;

import com.znlccy.recruit.service.RecruitService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-21-20:02
 * @remark: 控制器
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/recruit")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    /**
     * 查询所有招聘信息
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", recruitService.findAll());
    }
}
