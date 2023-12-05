package view;

import bean.User;
import dao.LoginDao;
import view.admin.AdminView;
import view.buyer.BuyerView;

import java.util.ArrayList;
import java.util.Scanner;

import static view.buyer.ShoppingChartView.showShoppingChartInfo;

/**
 * @Description 登录界面
 * @Author Freasy
 * @Date 2022-12-24
 * @Version 1.0
 */
public class Login<flag2> {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while (true){
            System.out.println("1. 登录\n"+"2. 退出");
            int op=input.nextInt();
            switch (op){
                case 1:
                    login();
                    break;
                case 2:
                    return;
                default:
                    return;
            }
        }
    }



    /**
     * 登录，登录成功后，根据user的admin属性，调用不同的方法
     */
    public static void login() {
//        AdminService.deleteGoods("10001");
//        AdminService.addGoods();
// 测试添加商品到购物车
//        BuyerService.addGoods("10001");
//        BuyerService.addGoods("10002");

        System.out.println("-------------登录界面--------------");
        System.out.println("请输入用户名：");
        String name = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
//        LoginDao dao = new LoginDao();
        LoginDao loginDao=new LoginDao();
        ArrayList<User> users_list=loginDao.getUsers();
        for (int i = 0; i < users_list.size(); i++) {
            if(users_list.get(i).getAdmin()=='1'&&users_list.get(i).getUsername().equals(name)&&users_list.get(i).getPassword().equals(password)){
                loginDao.loginedUser=users_list.get(i);
                AdminView.showOptions();
                return;
            }
            if(users_list.get(i).getUsername().equals(name)&&users_list.get(i).getPassword().equals(password)){
                loginDao.loginedUser=users_list.get(i);
                BuyerView.showOptions();
                return;
            }
        }
    }


        /*for (int i = 0; i < dao.getUsers().size(); i++) {
            if (dao.getUsers().get(i).getUsername().equals(name)) {
                flag = true;
                System.out.println("验证成功。");
            } else {
                System.out.println("输入用户不存在。");
            }
            if (dao.getUsers().get(i).getPassword().equals(password)) {
                flag2 = true;
                System.out.println("密码验证成功。");

                break;

            } else {
                System.out.println("输入密码错误。");
            }
            if(dao.getUsers().get(i).getAdmin()==1){
                flag3 =true;
            }else {}
        }

        }
        if(flag2==true){
        view.buyer.BuyerView.showOptions();
    }else if(flag2 == true&&)*/
    }

