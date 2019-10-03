package com.znlccy.recruit.service;

import com.znlccy.recruit.pojo.Recruit;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-22-10:54
 * @remark: 招聘服务
 */
public interface RecruitService {

    /**
     * 推荐职位
     * @return
     */
    List<Recruit> recommend();

    /**
     * 最新职位
     * @return
     */
    List<Recruit> newList();

    /**
     * 查询所有招聘
     * @return
     */
    List<Recruit> findAll();


    /**
     * 查询单个招聘
     * @param rid
     * @return
     */
    Recruit findById(String rid);

    /**
     * 添加招聘信息
     * @param recruit
     */
    void save(Recruit recruit);

    /**
     * 更新招聘
     * @param recruit
     * @param rid
     */
    void update(Recruit recruit, String rid);

    /**
     * 删除招聘
     * @param rid
     */
    void deleteById(String rid);

    /**
     * 多条件查找招聘
     * @param recruit
     * @return
     */
    List<Recruit> findSearch(Recruit recruit);

    /**
     * 分页查找招聘
     * @param recruit
     * @param page
     * @param size
     * @return
     */
    Page<Recruit> pageQuery(Recruit recruit, int page, int size);
}
