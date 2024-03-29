package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-21-12:19
 * @remark: 分页返回结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult <T>{

    /**
     * 返回总数量
     */
    private long total;

    /**
     * 返回函数
     */
    private List<T> rows;

}