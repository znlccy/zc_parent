package com.znlccy.recruit.service;

import com.znlccy.recruit.pojo.Recruit;

import java.util.List;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-22-10:54
 * @remark: 招聘服务
 */
public interface RecruitService {

    /**
     * 查询所有招聘
     * @return
     */
    List<Recruit> findAll();


}
