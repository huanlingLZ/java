package view.buyer;

import bean.Goods;
import dao.ShoppingDao;
import service.BuyerService;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description 购物界面
 * @Author
 * @Date 2022-12-24
 * @Version 1.0
 */
public class ShoppingView {

    /**
     * 功能：展示商品信息
     */
    public static void showShoppingInfo() {
        Scanner input=new Scanner(System.in);
        ShoppingDao shoppingDao=new ShoppingDao();
        ArrayList<Goods> goods=shoppingDao.getStorage();
        int s=0;
        while (true){
//            System.out.println("BuyerService");
            for (int i = s; i < s+5; i++) {
                System.out.println("第"+(i+1)+"个商品："+goods.get(i).getGoodsID()+"\t"+goods.get(i).getGoodsName()
                        +"\t"+goods.get(i).getPrice()+"\t"+goods.get(i).getCategory()+"\t"+goods.get(i).getNumber());
            }
            System.out.println("1.上一页\n"+"2.下一页\n3.去购物");
            int op=input.nextInt();
            if(op==1){
                if(s-5<0){
                    System.out.println("这是第一页，没有上一页");
                    s=0;
                }else {
                    s-=5;
                }
            }else if(op==2){
                if(s+10<=goods.size()){
                    s+=5;
                }else {
                    if(s == goods.size() - 5) {
                        System.out.println("这是最后一页，没有下一页了");
                    }else s=goods.size()-5;
                }
            }else{
                break;
            }
        }
    }


    /**
     * 功能：展示购物界面的选项，供用户进行选择
     *      1. 购物
     *      2. 结算
     *      3. 返回上一层
     */
    public static void showOptions() {
        System.out.println("这里是购物界面");
        while (true) {
            System.out.println("============购物界面============");
            System.out.println("        购物:1 ");
            System.out.println("        结算:2 ");

            System.out.println("        返回上一层:3 ");
            Scanner sc = new Scanner(System.in);
            System.out.println("        请输入您想要进行的操作 ");
            int number = sc.nextInt();
            switch (number){
                case 1:
//                    while ()
                    BuyerService.buyerSelect();
                    break;
                case 2:
                    BuyerService.settleAccounts();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("输入有误，需重新输入");

            }
        }
    }
}




