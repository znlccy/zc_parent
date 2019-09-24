package com.znlccy.recruit.service.impl;

import com.znlccy.recruit.dao.RecruitDao;
import com.znlccy.recruit.pojo.Recruit;
import com.znlccy.recruit.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-22-10:10
 * @remark: 招聘服务实现类
 */
@Service
@Transactional
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有招聘
     * @return
     */
    @Override
    public List<Recruit> findAll() {
        return recruitDao.findAll();
    }
}
