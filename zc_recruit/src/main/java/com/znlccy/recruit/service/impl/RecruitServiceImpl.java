package com.znlccy.recruit.service.impl;

import com.znlccy.recruit.dao.RecruitDao;
import com.znlccy.recruit.pojo.Enterprise;
import com.znlccy.recruit.pojo.Recruit;
import com.znlccy.recruit.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-22-10:10
 * @remark: 招聘服务实现类
 */
@Service
@Transactional
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 推荐职位
     * @return
     */
    @Override
    public List<Recruit> recommend() {
        return recruitDao.findTop6ByStateOrderByCreateTimeDesc("2");
    }

    /**
     * 最新职位
     * @return
     */
    @Override
    public List<Recruit> newList() {
        return recruitDao.findTop6ByStateNotOrderByCreateTimeDesc("0");
    }

    /**
     * 查询所有招聘
     * @return
     */
    @Override
    public List<Recruit> findAll() {
        return recruitDao.findAll();
    }

    /**
     * 查找单个招聘
     * @param rid
     * @return
     */
    @Override
    public Recruit findById(String rid) {
        return recruitDao.findById(rid).get();
    }

    /**
     * 添加招聘信息
     * @param recruit
     */
    @Override
    public void save(Recruit recruit) {
        recruit.setId(idWorker.nextId() + "");
        recruitDao.save(recruit);
    }

    /**
     * 更新招聘信息
     * @param recruit
     * @param rid
     */
    @Override
    public void update(Recruit recruit, String rid) {
        recruit.setId(rid);
        recruitDao.save(recruit);
    }

    /**
     * 删除招聘信息
     * @param rid
     */
    @Override
    public void deleteById(String rid) {
        recruitDao.deleteById(rid);
    }

    /**
     * 多条件查找招聘
     * @param recruit
     * @return
     */
    @Override
    public List<Recruit> findSearch(Recruit recruit) {
        return recruitDao.findAll(new Specification<Recruit>() {
            @Override
            public Predicate toPredicate(Root<Recruit> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();

                /*if (recruit.getAddress() != null && !"".equals(recruit.getAddress())) {
                    Predicate address = cb.like(root.get("address").as(String.class), "%" + recruit.getAddress() + "%");
                    list.add(address);
                }
                
                if (recruit.getCondition() != null && !"".equals(recruit.getCondition())) {
                    Predicate condition = cb.like(root.get("condition").as(String.class), "%" + recruit.getCondition() + "%");
                    list.add(condition);
                }

                if (recruit.getContent() != null && !"".equals(recruit.getContent())) {
                    Predicate content = cb.like(root.get("content").as(String.class), "%" + recruit.getContent() + "%");
                    list.add(content);
                }

                if (recruit.getDescription() != null && !"".equals(recruit.getDescription())) {
                    Predicate description = cb.like(root.get("description").as(String.class), "%" + recruit.getDescription() + "%");
                    list.add(description);
                }*/

                if (recruit.getJobName() != null && !"".equals(recruit.getJobName())) {
                    Predicate jobName = cb.like(root.get("jobName").as(String.class), "%" + recruit.getJobName() + "%");
                    list.add(jobName);
                }

                Predicate[] predicates = new Predicate[list.size()];
                predicates = list.toArray(predicates);
                return cb.and(predicates);
            }
        });
    }

    /**
     * 分页查找招聘
     * @param recruit
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Recruit> pageQuery(Recruit recruit, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return recruitDao.findAll(new Specification<Recruit>() {
            @Override
            public Predicate toPredicate(Root<Recruit> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();

                /*if (recruit.getAddress() != null && !"".equals(recruit.getAddress())) {
                    Predicate address = cb.like(root.get("address").as(String.class), "%" + recruit.getAddress() + "%");
                    list.add(address);
                }

                if (recruit.getCondition() != null && !"".equals(recruit.getCondition())) {
                    Predicate condition = cb.like(root.get("condition").as(String.class), "%" + recruit.getCondition() + "%");
                    list.add(condition);
                }

                if (recruit.getContent() != null && !"".equals(recruit.getContent())) {
                    Predicate content = cb.like(root.get("content").as(String.class), "%" + recruit.getContent() + "%");
                    list.add(content);
                }

                if (recruit.getDescription() != null && !"".equals(recruit.getDescription())) {
                    Predicate description = cb.like(root.get("description").as(String.class), "%" + recruit.getDescription() + "%");
                    list.add(description);
                }*/

                if (recruit.getJobName() != null && !"".equals(recruit.getJobName())) {
                    Predicate jobName = cb.like(root.get("jobName").as(String.class), "%" + recruit.getJobName() + "%");
                    list.add(jobName);
                }

                Predicate[] predicates = new Predicate[list.size()];
                predicates = list.toArray(predicates);
                return cb.and(predicates);
            }
        }, pageable);
    }
}
