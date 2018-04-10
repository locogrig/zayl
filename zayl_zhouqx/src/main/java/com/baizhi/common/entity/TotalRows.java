package com.baizhi.common.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/11/14.
 */
public class TotalRows {
    private Integer total;
    private List<User> rows;

    @Override
    public String toString() {
        return "TotalRows{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<User> getRows() {
        return rows;
    }

    public void setRows(List<User> rows) {
        this.rows = rows;
    }

    public TotalRows(Integer total, List<User> rows) {

        this.total = total;
        this.rows = rows;
    }

    public TotalRows() {

    }
}
