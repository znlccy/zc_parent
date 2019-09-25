package com.znlccy.recruit.controller;

import com.znlccy.recruit.pojo.Recruit;
import com.znlccy.recruit.service.RecruitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 查找单个招聘
     * @param rid
     * @return
     */
    @RequestMapping(value = "/{rid}", method = RequestMethod.GET)
    public Result findById(String rid) {
        return new Result(true, StatusCode.OK, "查询成功", recruitService.findById(rid));
    }

    /**
     * 添加招聘信息
     * @param recruit
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Recruit recruit) {
        recruitService.save(recruit);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 更新招聘信息
     * @param recruit
     * @param rid
     * @return
     */
    @RequestMapping(value = "/{rid}", method = RequestMethod.PUT)
    public Result update(@RequestBody Recruit recruit, @PathVariable String rid) {
        recruitService.update(recruit, rid);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    /**
     * 删除招聘信息
     * @param rid
     * @return
     */
    @RequestMapping(value = "/{rid}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String rid) {
        recruitService.deleteById(rid);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 多条件查找招聘
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Recruit recruit) {
        List<Recruit> list = recruitService.findSearch(recruit);
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    /**
     * 分页查找招聘
     * @param recruit
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Recruit recruit, @PathVariable int page, int size) {
        Page<Recruit> recruits = recruitService.pageQuery(recruit, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Recruit>(recruits.getTotalElements(), recruits.getContent()));
    }
}
