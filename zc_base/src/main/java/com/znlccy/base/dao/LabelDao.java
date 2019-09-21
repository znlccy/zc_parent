package com.znlccy.base.dao;

import com.znlccy.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-21-14:24
 * @remark: 标签Dao层
 */
public interface LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {

}
