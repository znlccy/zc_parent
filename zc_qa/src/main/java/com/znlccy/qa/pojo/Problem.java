package com.znlccy.qa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-10-04 15:07
 * @remark: 问答实体类
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Problem implements Serializable {

    /**
     * 问答主键
     */
    private String id;

    /**
     * 问答标题
     */
    private String title;
}
