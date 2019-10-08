package com.znlccy.qa.service;

import com.znlccy.qa.pojo.Problem;

import java.util.List;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-10-04 15:21
 * @remark: 
 */
public interface ProblemService {

    /**
     * 查找所有问答
     * @return
     */
    List<Problem> findAll();

    /**
     * 查找单个问答
     * @param id
     * @return
     */
    Problem findById(String id);

    /**
     * 保存问答
     * @param problem
     */
    void save(Problem problem);

    /**
     * 更新问答
     * @param id
     * @param problem
     */
    void update(String id, Problem problem);

    /**
     * 删除问答
     * @param id
     */
    void deleteById(String id);

    /**
     * 多条件查找问答
     * @param problem
     * @return
     */
    List<Problem> findSearch(Problem problem);

    /**
     * 分页查找问答
     * @param problem
     * @param page
     * @param size
     * @return
     */
    List<Problem> pageQuery(Problem problem, int page, int size);
}
