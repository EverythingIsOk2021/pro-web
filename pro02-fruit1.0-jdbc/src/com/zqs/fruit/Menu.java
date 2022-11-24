package com.zqs.fruit;

import com.zqs.fruit.dao.FruitDAO;
import com.zqs.fruit.dao.impl.FruitDAOImpl;
import com.zqs.fruit.pojo.Fruit;

import java.util.List;
import java.util.Scanner;

/**
 * @author zhouqianshun
 * @create 2022-11-23 19:27
 * @date 2022/11/23 - 19:27
 *
 * 用来显示系统主要的操作界面
 */
public class Menu {
    Scanner sc = new Scanner(System.in);
    FruitDAOImpl fruitDao = new FruitDAOImpl();
    //显示主菜单
    public Integer showMainMenu(){
        System.out.println("=================欢迎使用水果库存系统=====================");
        System.out.println("1.查看水果库存列表");
        System.out.println("2.添加水果库存信息");
        System.out.println("3.查看特定水果库存信息");
        System.out.println("4.水果下架");
        System.out.println("5.退出");
        System.out.println("======================================================");
        System.out.print("请输入您要操作的选项:");
        int number = sc.nextInt();
        return number;
    }
    public boolean Exit(){
        System.out.print("是否确认退出？（Y/N）");
        String slt = sc.next();
        return !"Y".equalsIgnoreCase(slt);
    }
    //查看水果库存
    public void show(){

        List<Fruit> fruitList = fruitDao.getFruitList();
        System.out.println("------------------------------------------------------");
        System.out.println("FID\t\t名称\t\t单价\t\t库存\t\t备注");
        if(fruitList == null || fruitList.size()<0){
            System.out.println("库存为空");
        }
        for (int i = 0; i < fruitList.size(); i++) {
            Fruit fruit = fruitList.get(i);
            System.out.println(fruit);
        }
        System.out.println("------------------------------------------------------");
    }
    //添加水果库存信息
    public void addFruit(){
        List<Fruit> fruitList = fruitDao.getFruitList();
        System.out.print("请输入水果名称：");
        String fname = sc.next();

        boolean isHave = false;
        Fruit fruit = null;
        for (int i = 0; i < fruitList.size(); i++) {
            fruit = fruitList.get(i);
            if(fruit.getFname().equalsIgnoreCase(fname)){
                isHave = true;
            }
        }
        if(isHave){
            System.out.print("请输入追加的库存量：");
            int fcount = sc.nextInt();
            Fruit fruit1 = new Fruit(fruit.getFid(),fruit.getFname(),fruit.getPrice(),fruit.getFcount()+fcount,fruit.getRemark());
            fruitDao.updateFruit(fruit1);
        }else{
            System.out.println("库存中没有该水果，请添加！");
                System.out.print("请输入追加的水果名称：");
                String fname1 = sc.next();
                System.out.print("请输入水果的单价");
                int price = sc.nextInt();
                System.out.print("请输入追加的水果库存数量：");
                int fcount1 = sc.nextInt();
                System.out.print("请输入水果的备注：");
                String remark = sc.next();
                Fruit fruit1 = new Fruit(0,fname1,price,fcount1,remark);
                boolean isSuccess = fruitDao.addFruit(fruit1);
                if(isSuccess){
                    System.out.println("添加成功");
                }else{
                    System.out.println("添加失败");
                }
        }
    }
    //查看特定水果库存信息
    public void checkFruit(){
        System.out.print("请输入您要查询的水果名称：");
        String fname = sc.next();
        Fruit fruit = fruitDao.getFruitByName(fname);
        if(fruit == null){
            System.out.println("------------------------------------------------------");
            System.out.println("库存中没有您要查询的水果！");
        }else{
            System.out.println("------------------------------------------------------");
            System.out.println("FID\t\t名称\t\t单价\t\t库存\t\t备注");
            System.out.println(fruit);
        }
        System.out.println("------------------------------------------------------");
    }
    //删除水果库存信息
    public void delFruit(){
        System.out.println("请输入您要删除的水果名称：");
        String fname = sc.next();
        Fruit fruit = fruitDao.getFruitByName(fname);
        if(fruit == null){
            System.out.println("------------------------------------------------------");
            System.out.println("库存中没有您要删除的水果！");
        }else{
            System.out.print("是否确认删除（Y/N）");
            String choose = sc.next();
            if("Y".equalsIgnoreCase(choose)){
                System.out.println("------------------------------------------------------");
                fruitDao.delFruit(fname);
                System.out.println("删除成功！");
            }else{
                System.out.println("------------------------------------------------------");

            }
        }
        System.out.println("------------------------------------------------------");
    }
}
