package com.zqs.fruit.pojo;

import java.util.Objects;

/**
 * @author zhouqianshun
 * @create 2022-11-23 19:27
 * @date 2022/11/23 - 19:27
 */
public class Fruit {
    private Integer fid;
    private String fname;
    private Integer fcount;
    private Integer price;
    private String remark;

    public Fruit() {
    }

    public Fruit(Integer fid, String fname,  Integer price,Integer fcount, String remark) {
        this.fid = fid;
        this.fname = fname;
        this.fcount = fcount;
        this.price = price;
        this.remark = remark;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getFcount() {
        return fcount;
    }

    public void setFcount(Integer fcount) {
        this.fcount = fcount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return this.getFid()+"\t\t"+this.getFname()+"\t\t"+this.getPrice()+"\t\t"+this.getFcount()+"\t\t"+this.getRemark();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return fname.equals(fruit.fname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fname);
    }
}
