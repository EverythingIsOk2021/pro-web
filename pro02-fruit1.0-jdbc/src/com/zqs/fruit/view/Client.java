package com.zqs.fruit.view;

import com.zqs.fruit.Menu;

/**
 * @author zhouqianshun
 * @create 2022-11-23 19:37
 * @date 2022/11/23 - 19:37
 * 最后的运行类
 */
public class Client {
    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean flag = true;
        while(flag){
            Integer menuNumber = menu.showMainMenu();
            switch (menuNumber){
                case 1:
                    menu.show();
                    break;
                case 2:
                    menu.addFruit();
                    break;
                case 3:
                    menu.checkFruit();
                    break;
                case 4:
                    menu.delFruit();
                    break;
                case 5:
                  flag = menu.Exit();
                    break;
                default:
                    System.out.println("what are you fucking doing?");
                    break;
            }
        }

    }
}
