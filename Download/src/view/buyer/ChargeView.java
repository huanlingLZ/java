package view.buyer;

import bean.User;
import dao.LoginDao;

import java.util.Scanner;

/**
 * @Description 充值界面
 * @Author
 * @Date 2022-12-24
 * @Version 1.0
 */
public class ChargeView {


    /**
     * 展示充值界面信息
     */
    public static void showChargeInfo() {
        Scanner sc = new Scanner(System.in);
        Double money = sc.nextDouble();
        if(LoginDao.loginedUser.getBalance()==null){
            LoginDao.loginedUser.setBalance(money);
        }else {
            LoginDao.loginedUser.setBalance(LoginDao.loginedUser.getBalance()+money);
        }

        System.out.println("你当前余额为"+LoginDao.loginedUser.getBalance());
    }

    /**
     * 展示充值界面的选项
     */
    public static void showOptions() {
        System.out.println("=============充值界面==============");
        System.out.println("       请输入您想要充值的金额     ");

    }
}
