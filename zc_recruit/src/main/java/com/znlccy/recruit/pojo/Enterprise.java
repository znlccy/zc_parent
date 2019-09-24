package com.znlccy.recruit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-21-20:54
 * @remark: 企业实体类
 */
@Entity
@Table(name = "tb_enterprise")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enterprise implements Serializable {

    /**
     * 企业主键
     */
    @Id
    private String id;

    /**
     * 企业名称
     */
    private String name;

    /**
     * 企业概要
     */
    private String summary;

    /**
     * 企业地址
     */
    private String address;

    /**
     * 企业标签
     */
    private String labels;

    /**
     * 企业坐标
     */
    private String coordinate;

    /**
     * 是否热门
     */
    private String isShot;

    /**
     * 企业Logo
     */
    private String logo;

    /**
     * 企业职位数量
     */
    private Integer jobCount;

    /**
     * 企业URL
     */
    private String url;
}
