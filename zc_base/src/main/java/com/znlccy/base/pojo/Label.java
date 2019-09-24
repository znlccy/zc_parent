package com.znlccy.base.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-21-14:06
 * @remark: 标签实体类
 */
@Entity
@Table(name = "tb_label")
@Data
public class Label implements Serializable {

    /**
     * 标签主键
     */
    @Id
    private String id;

    /**
     * 标签名称
     */
    private String labelName;

    /**
     * 标签状态
     */
    private String state;

    /**
     * 使用数量
     */
    private Long count;

    /**
     * 关注度数
     */
    private Long fans;

    /**
     * 是否推荐
     */
    private String recommend;


}
