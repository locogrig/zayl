package com.baizhi.common.entity;

/**
 * Created by Administrator on 2017/12/3.
 */
public class Count {
    private Integer value;
    private String name;

    @Override
    public String toString() {
        return "Count{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Count() {

    }

    public Count(Integer value, String name) {

        this.value = value;
        this.name = name;
    }
}
