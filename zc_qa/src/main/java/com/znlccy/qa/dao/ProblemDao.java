package com.znlccy.qa.dao;

import com.znlccy.qa.pojo.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-10-04 15:10
 * @remark: 
 */
public interface ProblemDao extends JpaRepository<Problem,String>, JpaSpecificationExecutor<Problem> {

}
