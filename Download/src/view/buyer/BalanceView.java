package view.buyer;
import bean.User;

import java.util.Scanner;
/**
 * @Description 余额界面
 * @Author
 * @Date 2022-12-24
 * @Version 1.0
 */
public class BalanceView {
    /**
     * 功能:展示用户余额剩余多少
     */
    public static void ShowBalance(){
        System.out.println("=========余额界面=========");
        User user = new User();
        System.out.println("该用户的余额为:  " + user.getBalance());
        System.out.println("是否要进行充值?请输入Yes/No");
        Scanner scanner = new Scanner(System.in);
        String isCharge =  scanner.next();
        switch (isCharge){
            case "Yes":
                ChargeView.showOptions();
                break;
            case "No":
                BuyerView.showOptions();
                break;
            default:
                System.out.println("您的输入有误,已自动为您返回余额界面");
                ShowBalance();
                break;
        }
    }
}
