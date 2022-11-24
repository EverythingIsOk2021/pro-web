package com.zqs.fruit.dao;

import com.zqs.fruit.pojo.Fruit;

import java.util.List;

/**
 * @author zhouqianshun
 * @create 2022-11-23 19:58
 * @date 2022/11/23 - 19:58
 */
public interface FruitDAO {
    //查看库存
    List<Fruit> getFruitList();
    //添加库存
    boolean addFruit(Fruit fruit);

    //修改
    boolean updateFruit(Fruit fruit);

    //根据名称查询
    Fruit getFruitByName(String fname);

    //删除特定库存记录
    boolean delFruit(String fname);
}
