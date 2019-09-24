package com.znlccy.base.service.impl;

import com.znlccy.base.dao.LabelDao;
import com.znlccy.base.pojo.Label;
import com.znlccy.base.service.LabelService;
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
import java.util.List;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-21-14:27
 * @remark:
 */
@Service
@Transactional
public class LabelServiceImpl implements LabelService {

    /**
     * 依赖注入label标签Dao
     */
    @Autowired
    private LabelDao labelDao;

    /**
     * 依赖注入雪花算法
     */
    @Autowired
    private IdWorker idWorker;

    /**
     * 查找所有标签
     * @return
     */
    @Override
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    /**
     * 通过主键查找标签
     * @param labelId
     * @return
     */
    @Override
    public Label findById(String labelId) {
        return labelDao.findById(labelId).get();
    }

    /**
     * 添加标签
     * @param label
     */
    @Override
    public void save(Label label) {
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    /**
     * 更新标签
     * @param label
     */
    @Override
    public void update(Label label) {
        labelDao.save(label);
    }

    /**
     * 更新标签
     * @param labelId
     */
    @Override
    public void deleteById(String labelId) {
        labelDao.deleteById(labelId);
    }

    /**
     * 多条件查找标签
     * @param label
     * @return
     */
    @Override
    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            /**
             * @param root 根对象，也就是要把条件封装到哪个对象，where 类名=label.getId
             * @param query 封装的都是查询关键词，比如group by order by等
             * @param cb 用来封装条件对象
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //new一个list集合，来存放所有条件
                List<Predicate> list = new ArrayList<>();

                if (label.getLabelName()!=null && !"".equals(label.getLabelName())) {
                    Predicate predicate = cb.like(root.get("labelName").as(String.class), "%" + label.getLabelName() + "%");//where labelName like "%小明%"
                    list.add(predicate);
                }

                if (label.getState()!=null && !"".equals(label.getState())) {
                    Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }

                //new一个数组作为最终返回值的条件
                Predicate[] parr = new Predicate[list.size()];
                //把list直接转成数组
                parr = list.toArray(parr);
                return cb.and(parr);
            }
        });
    }

    /**
     *
     * @param label
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Label> pageQuery(Label label, int page, int size) {
        //封装一个分页类
        Pageable pageable = PageRequest.of(page-1, size);
        return labelDao.findAll(new Specification<Label>() {
            /**
             * @param root 根对象，也就是要把条件封装到哪个对象，where 类名=label.getId
             * @param query 封装的都是查询关键词，比如group by order by等
             * @param cb 用来封装条件对象
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //new一个list集合，来存放所有条件
                List<Predicate> list = new ArrayList<>();

                if (label.getLabelName()!=null && !"".equals(label.getLabelName())) {
                    Predicate predicate = cb.like(root.get("labelName").as(String.class), "%" + label.getLabelName() + "%");//where labelName like "%小明%"
                    list.add(predicate);
                }

                if (label.getState()!=null && !"".equals(label.getState())) {
                    Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }

                //new一个数组作为最终返回值的条件
                Predicate[] parr = new Predicate[list.size()];
                //把list直接转成数组
                parr = list.toArray(parr);
                return cb.and(parr);
            }
        }, pageable);
    }
}
