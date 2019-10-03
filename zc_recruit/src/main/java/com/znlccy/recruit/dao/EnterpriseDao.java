package com.znlccy.recruit.dao;

import com.znlccy.recruit.pojo.Enterprise;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-21-21:35
 * @remark: 企业Dao层
 */
public interface EnterpriseDao extends JpaRepository<Enterprise,String>, JpaSpecificationExecutor<Enterprise> {

    /**
     * 查找热门企业
     * @param isShot
     * @return
     */
    List<Enterprise> findByIsShot(String isShot);

//    List<Enterprise> findBy
}
