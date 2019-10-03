package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-21-12:07
 * @remark: 返回结果类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    /**
     * 返回标签
     */
    private boolean flag;

    /**
     * 返回状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 构造方法
     * @param flag
     * @param code
     * @param message
     */
    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
}