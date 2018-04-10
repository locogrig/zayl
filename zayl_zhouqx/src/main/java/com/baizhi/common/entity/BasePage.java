package com.baizhi.common.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
public class BasePage<T> {
    private Integer total;
    private List<T> rows;

    @Override
    public String toString() {
        return "BasePage{" +
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

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public BasePage(Integer total, List<T> rows) {

        this.total = total;
        this.rows = rows;
    }

    public BasePage() {

    }
}
