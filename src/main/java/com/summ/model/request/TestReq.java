package com.summ.model.request;

/**
 * Created by jygj_7500 on 17/11/17.
 */
public class TestReq {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "TestReq{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
