package com.znlccy.recruit.controller;

import com.znlccy.recruit.pojo.Enterprise;
import com.znlccy.recruit.service.EnterpriseService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-22-11:01
 * @remark: 企业控制器
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * 查询所有企业
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", enterpriseService.findAll());
    }

    /**
     * 查询单个企业
     * @param eid
     * @return
     */
    @RequestMapping(value = "/{eid}",method = RequestMethod.GET)
    public Result findById(String eid) {
        return new Result(true, StatusCode.OK, "查询成功", enterpriseService.findById(eid));
    }

    /**
     * 添加企业
     * @param enterprise
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Enterprise enterprise) {
        enterpriseService.save(enterprise);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 更新企业
     * @param eid
     * @param enterprise
     * @return
     */
    @RequestMapping(value = "/{eid}", method = RequestMethod.PUT)
    public Result update(@PathVariable("eid") String eid, @RequestBody Enterprise enterprise) {
        enterpriseService.update(eid,enterprise);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    /**
     * 删除企业
     * @param eid
     * @return
     */
    @RequestMapping(value = "/{eid}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("eid") String eid) {
        enterpriseService.deleteById(eid);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    public Result findSearch() {
        return new Result(true, StatusCode.OK, "查询成功");
    }

    public Result pageQuery() {
        return new Result(true, StatusCode.OK,"查询成功");
    }
}
