package com.znlccy.qa.service.impl;

import com.znlccy.qa.dao.ProblemDao;
import com.znlccy.qa.pojo.Problem;
import com.znlccy.qa.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-10-08 09:38
 * @remark: 问答实现模块
 */
@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private ProblemDao problemDao;

    /**
     * 查找所有
     * @return
     */
    @Override
    public List<Problem> findAll() {
        return problemDao.findAll();
    }

    @Override
    public Problem findById(String id) {
        return problemDao.findById(id).get();
    }

    @Override
    public void save(Problem problem) {
        problem.setId(idWorker.nextId() + "");
        problemDao.save(problem);
    }

    @Override
    public void update(String id, Problem problem) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public List<Problem> findSearch(Problem problem) {
        return null;
    }

    @Override
    public List<Problem> pageQuery(Problem problem, int page, int size) {
        return null;
    }
}
