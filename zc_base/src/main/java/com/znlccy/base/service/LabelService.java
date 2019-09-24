package com.znlccy.base.service;

import com.znlccy.base.pojo.Label;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-21-14:26
 * @remark: 标签服务接口类
 */
public interface LabelService {

    /**
     * 查询所有标签
     * @return
     */
    List<Label> findAll();

    /**
     * 主键查找标签
     * @param labelId
     * @return
     */
    Label findById(String labelId);

    /**
     * 保存标签
     * @param label
     */
    void save(Label label);

    /**
     * 更新标签
     * @param label
     */
    void update(Label label);

    /**
     * 删除标签
     * @param labelId
     */
    void deleteById(String labelId);

    /**
     * 多条件查找标签
     * @param label
     * @return
     */
    List<Label> findSearch(Label label);

    /**
     * 分页查找标签
     * @param label
     * @param page
     * @param size
     * @return
     */
    Page<Label> pageQuery(Label label, int page, int size);
}
