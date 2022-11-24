package com.zqs.jdbc;

/**
 * @author zhouqianshun
 * @create 2022-11-23 13:56
 * @date 2022/11/23 - 13:56
 * @decription 用来封装从数据库中取出的数据。
 */
public class Fruit {
    private Integer fid;
    private String name;
    private Integer price;
    private Integer fcount;
    private String remark;

    public Fruit() {
    }

    public Fruit(Integer fid, String name, Integer price, Integer fcount, String remark) {
        this.fid = fid;
        this.name = name;
        this.price = price;
        this.fcount = fcount;
        this.remark = remark;
    }

    public Fruit(Integer fid, String name, String remark) {
        this.fid = fid;
        this.name = name;
        this.price = price;
        this.remark = remark;
    }

    public Integer getFcount() {
        return fcount;
    }

    public void setFcount(Integer fcount) {
        this.fcount = fcount;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Fruit{" +
                "fid=" + fid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", remark='" + remark + '\'' +
                '}';
    }
}
