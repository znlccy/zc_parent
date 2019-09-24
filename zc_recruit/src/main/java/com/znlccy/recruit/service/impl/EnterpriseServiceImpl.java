package com.znlccy.recruit.service.impl;

import com.znlccy.recruit.dao.EnterpriseDao;
import com.znlccy.recruit.pojo.Enterprise;
import com.znlccy.recruit.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-22-10:09
 * @remark: 企业服务实现类
 */
@Service
@Transactional
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询热门企业
     * @param isShot
     * @return
     */
    @Override
    public List<Enterprise> findByIsShot(String isShot) {
        return enterpriseDao.findByIsShot(isShot);
    }

    /**
     * 查询所有企业
     * @return
     */
    @Override
    public List<Enterprise> findAll() {
        return enterpriseDao.findAll();
    }

    /**
     * 查找单个企业
     * @param eid
     * @return
     */
    @Override
    public Enterprise findById(String eid) {
        return enterpriseDao.findById(eid).get();
    }

    /**
     * 添加企业
     * @param enterprise
     */
    @Override
    public void save(Enterprise enterprise) {
        enterprise.setId(idWorker.nextId() + "");
        enterpriseDao.save(enterprise);
    }

    /**
     * 更新企业
     * @param eid
     * @param enterprise
     */
    @Override
    public void update(String eid, Enterprise enterprise) {
        enterprise.setId(eid);
        enterpriseDao.save(enterprise);
    }

    /**
     * 删除企业
     * @param eid
     */
    @Override
    public void deleteById(String eid) {
        enterpriseDao.deleteById(eid);
    }

    /**
     * 多条件查找企业
     * @param enterprise
     * @return
     */
    @Override
    public List<Enterprise> findSearch(Enterprise enterprise) {
        return enterpriseDao.findAll(new Specification<Enterprise>() {
            @Override
            public Predicate toPredicate(Root<Enterprise> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        });
    }

    /**
     * 分页查找企业
     * @param enterprise
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Enterprise> pageQuery(Enterprise enterprise, int page, int size) {
        return null;
    }
}
