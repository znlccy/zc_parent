package com.znlccy.recruit.controller;

import com.znlccy.recruit.pojo.Enterprise;
import com.znlccy.recruit.service.EnterpriseService;
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

    /**
     * 多条件查找企业
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Enterprise enterprise) {
        List<Enterprise> list = enterpriseService.findSearch(enterprise);
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    /**
     * 分页查找企业
     * @return
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Enterprise enterprise, @PathVariable int page, @PathVariable int size) {
        Page<Enterprise> enterprisePage = enterpriseService.pageQuery(enterprise, page, size);
        return new Result(true, StatusCode.OK,"查询成功", new PageResult<Enterprise>(enterprisePage.getTotalElements(), enterprisePage.getContent()));
    }
}
