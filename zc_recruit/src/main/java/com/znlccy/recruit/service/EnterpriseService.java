package com.znlccy.recruit.service;

import com.znlccy.recruit.pojo.Enterprise;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-21-21:37
 * @remark: 企业服务接口层
 */
public interface EnterpriseService {

    /**
     * 查询热门企业
     * @param isShot
     * @return
     */
    List<Enterprise> findByIsShot(String isShot);

    /**
     * 查询所有企业
     * @return
     */
    List<Enterprise> findAll();

    /**
     * 查询单个企业
     * @param eid
     * @return
     */
    Enterprise findById(String eid);

    /**
     * 添加企业
     * @param enterprise
     */
    void save(Enterprise enterprise);

    /**
     * 更新企业
     * @param eid
     * @param enterprise
     */
    void update(String eid, Enterprise enterprise);

    /**
     * 删除企业
     * @param eid
     */
    void deleteById(String eid);

    /**
     * 多条件查找企业
     * @param enterprise
     * @return
     */
    List<Enterprise> findSearch(Enterprise enterprise);

    /**
     * 分页查找企业
     * @param enterprise
     * @param page
     * @param size
     * @return
     */
    Page<Enterprise> pageQuery(Enterprise enterprise, int page, int size);
}
