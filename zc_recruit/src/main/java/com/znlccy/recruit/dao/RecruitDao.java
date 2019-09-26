package com.znlccy.recruit.dao;

import com.znlccy.recruit.pojo.Recruit;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-22-10:10
 * @remark: 招聘Dao层
 */
public interface RecruitDao extends JpaRepository<Recruit,String>, JpaSpecificationExecutor<Recruit> {

    /**
     * 热门职业
     * @param state
     * @return
     */
    /*List<Recruit> findTop6ByStateOrderByCreateTimeDesc(String state);*/

    /**
     * 最新职业
     * @param state
     * @return
     */
    /*List<Recruit> findTop6ByStateNotOrderByCreateTimeDesc(String state);*/
}
