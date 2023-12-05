package view.buyer;

import bean.User;
import dao.LoginDao;
import dao.ShoppingDao;

import java.util.Scanner;

/**
 * @Description 买家界面
 * @Author
 * @Date 2022-12-24
 * @Version 1.0
 */
public class BuyerView {

    /**
     * 功能：展示买家选项，调用BuyerService的select方法进行选择跳转
     */
    public static void showOptions() {
        System.out.println("这里是买家界面");
        Scanner input=new Scanner(System.in);
        LoginDao loginDao=new LoginDao();
        while (true) {
            System.out.println("============买家功能界面============");
            System.out.println("        购物:1 ");
            System.out.println("        充值:2 ");
            System.out.println("        余额:3 ");
            System.out.println("        购物车:4 ");
            System.out.println("        退出登录:5 ");
            Scanner sc = new Scanner(System.in);
            System.out.println("        请输入您想要进行的操作 ");
            int number = sc.nextInt();
            switch (number){
                case 1:
                    ShoppingView.showShoppingInfo();
                    ShoppingView.showOptions();
                    break;
                case 2:
                    ChargeView.showOptions();
                    ChargeView.showChargeInfo();
                    break;
                case 3:
//                    Balanceview();
                    if(loginDao.loginedUser.getBalance()==null){
                        System.out.println("你的余额为：0\n请充值");
                    }else {
                        System.out.println("你的余额为："+loginDao.loginedUser.getBalance());
                    }

                    break;
                case 4:
                    ShoppingChartView.showShoppingChartInfo();
                    ShoppingChartView.showOptions();
                    break;
                case 5:
                    System.out.println("退出成功");
                    return;
                default:
                    System.out.println("输入有误，需重新输入");

            }
        }

    }
    }


