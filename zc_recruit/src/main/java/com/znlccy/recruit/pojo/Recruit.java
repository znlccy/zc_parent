package com.znlccy.recruit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-21-21:33
 * @remark: 招聘实体类
 */
@Entity
@Table(name = "tb_recruit")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Recruit implements Serializable {

    /**
     * 招聘主键
     */
    @Id
    private String id;

    /**
     * 招聘职位
     */
    private String jobName;

    /**
     * 薪资范围
     */
    private String salary;

    /**
     * 经验要求
     */
    private String condition;

    /**
     * 学历要求
     */
    private String education;

    /**
     * 任职方式
     */
    private String type;

   /**
     * 办公地址
     */
    private String address;

    /**
     * 企业ID
     */
    private String eid;

    /**
     * 发布状态
     */
    private String state;

    /**
     * 原网址
     */
    private String url;

    /**
     * 标签
     */
    private String label;

    /**
     * 职业描述
     *
     */
    private String description;

    /**
     * 职位要求
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

}
