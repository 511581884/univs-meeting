package com.whut.basiccentre.frame.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author ysw
 * @email 1461182123@qq.com
 * @date 2020/12/12 2:48 下午
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TableResponseBean extends ResponseBean {
    /**
     * 总数据量
     */
    private long total;


    /**
     * 已默认返回码的方式渲染数据表格结果
     *
     * @param data  具体数据值
     * @param total 数据总条数
     * @return 对应实体类
     */
    public static TableResponseBean success(Object data, long total) {
        return new TableResponseBean(data, total);
    }

    /**
     * 构造函数
     *
     * @param data  返回的数据
     * @param total 总条数
     */
    public TableResponseBean(Object data, long total) {
        super("", data, System.currentTimeMillis());
        this.total = total;
    }

}
