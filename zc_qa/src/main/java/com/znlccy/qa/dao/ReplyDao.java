package com.znlccy.qa.dao;

import com.znlccy.qa.pojo.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-10-08 13:27
 * @remark: 回复Dao层
 */
public interface ReplyDao extends JpaRepository<Reply, String>, JpaSpecificationExecutor<Reply> {

}
