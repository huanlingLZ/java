package service;
import bean.Goods;
import bean.User;
import dao.LoginDao;
import dao.ShoppingDao;
//import sun.rmi.runtime.Log;
import view.buyer.BuyerView;
import view.buyer.ChargeView;
import view.buyer.ShoppingChartView;
import view.buyer.ShoppingView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * @Description 买家交互逻辑
 * @Author
 * @Date 2022-12-24
 * @Version 1.0
 */
public class BuyerService {

    /**
     * 功能：根据用户不同的选择，跳转到不同的界面
     */
    public static void buyerSelect() {
        Scanner input=new Scanner(System.in);
        ShoppingDao shoppingDao=new ShoppingDao();
        ArrayList<Goods> goods=shoppingDao.getStorage();
        ArrayList<Goods> shoppingChart=shoppingDao.getShoppingChart();
//        int s=0;
//        while (true){
//            System.out.println("BuyerService");
//            for (int i = s; i < s+5; i++) {
//                System.out.println("第"+(i+1)+"个商品："+goods.get(i).getGoodsID()+"\t"+goods.get(i).getGoodsName()
//                        +"\t"+goods.get(i).getPrice()+"\t"+goods.get(i).getCategory()+"\t"+goods.get(i).getNumber());
//            }
//            System.out.println("1.上一页\n"+"2.下一页\n");
//            int op=input.nextInt();
//            if(op==1){
//                if(s-5<0){
//                    s=0;
//                }else {
//                    s-=5;
//                }
//            }else if(op==2){
//                if(s+10<=goods.size()){
//                    s+=5;
//                    System.out.println("123444");
//
//                }else {System.out.println("444");
//                    s=goods.size()-5;
//                }
//            }else{
//                break;
//            }
//        }
        while (true){
            System.out.println("选择你想要的商品：（输入0为退出）");
            int x=input.nextInt();
            if(x==0){
                return;
            }
            if(LoginDao.loginedUser.getBalance()==null){
                System.out.println("你的余额为零，无法选择商品");
                return;
            }
            try {
                Double price=goods.get(x-1).getPrice();
//            System.out.println(LoginDao.loginedUser.getBalance()+"\t"+price);
                if(goods.get(x-1).getNumber()>0){
                    if(LoginDao.loginedUser.getBalance()>=price){
                        LoginDao.loginedUser.setBalance(LoginDao.loginedUser.getBalance()-price);
    //                    shoppingChart.add(new Goods(goods.get(x-1).getGoodsID(),goods.get(x-1).getGoodsName()
    //                            ,goods.get(x-1).getPrice(),goods.get(x-1).getCategory(),1));
                        addGoods(goods.get(x-1).getGoodsID());
                        goods.get(x-1).setNumber(goods.get(x-1).getNumber()-1);
                        System.out.println("该商品存货为："+goods.get(x-1).getNumber());
                    }else {
                        System.out.println("你的余额不足!");
                    }
                }else {
                    System.out.println("该商品没有存货");
                }
                for (int i = 0; i < shoppingChart.size(); i++) {
                    System.out.println("第"+(i+1)+"个商品："+shoppingChart.get(i).getGoodsID()+"\t"
                            +shoppingChart.get(i).getGoodsName()+"\t"+shoppingChart.get(i).getPrice()
                            +"\t"+shoppingChart.get(i).getCategory()+"\t"+shoppingChart.get(i).getNumber());
                }
            } catch (Exception e) {
                System.out.println("请输入正确的商品序号，已有商品的序号为1~" + goods.size());
            }
        }
    }

    /**
     * 在购物区界面进行的选择，跳转到不同界面
     */
    public static void shoppingSelect() {

    }

    /**
     * 功能：根据商品id，将对应的商品加入到购物车
     */
    public static void addGoods(String goodsID) {
        Goods objectGoods = new Goods();
        ShoppingDao storage = new ShoppingDao();
        ArrayList<Goods> storageGoods = storage.getStorage();       //仓库对象
        String objectID;
        for (Goods goods :storageGoods) {
            objectID = goods.getGoodsID();
            if (objectID.equals(goodsID)) {
                for (int i = 0; i < ShoppingDao.shoppingChart.size(); i++) {
                    if(ShoppingDao.shoppingChart.get(i).getGoodsID().equals(goodsID)){
                        ShoppingDao.shoppingChart.get(i).setNumber(ShoppingDao.shoppingChart.get(i).getNumber()+1);
                        return;
                    }
                }
                objectGoods = goods;
                objectGoods.setNumber(1);
                break;
            }
        }
        ShoppingDao.shoppingChart.add(objectGoods);
    }

    /**
     * 购物车选择
     *   1. 购物
     *   2. 结算
     *   3，删除商品
     *   4. 返回上一层
     */
    public static void shoppingChartSelect() {
        System.out.println("请选择要进行的功能：");
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();
        if(select == 1) {
            ShoppingView.showShoppingInfo();
        } else if(select == 2) {
            settleAccounts();
            shoppingChartSelect();
        } else if(select == 3) {
            System.out.println("请输入要删除的商品ID：");
            String goodsID = sc.next();
            deleteGoods(goodsID);
            shoppingChartSelect();
        } else if(select == 4) {
            return;
//            BuyerView.showOptions();
        } else {
            System.out.println("请输入正确的功能选择！");
            shoppingChartSelect();
        }
    }
    /**
     * 结算功能
     */
    public static void settleAccounts() {
        if (ShoppingDao.shoppingChart.isEmpty()) {
            System.out.println("该购物车为空！");
        }else {
            double sumPrice = 0;
            for (Goods goods :ShoppingDao.shoppingChart) {
                sumPrice += goods.getPrice();
            }
            double userBalance;
            try {
                userBalance = LoginDao.loginedUser.getBalance();
                if(userBalance >= sumPrice) {
                    System.out.println("结算成功,总计" + sumPrice + "元");
                    LoginDao.loginedUser.setBalance(userBalance - sumPrice);
                    ShoppingDao.shoppingChart.clear();
                }else {
                    System.out.println("很抱歉，您的余额不足，请充值");
                }
            } catch (NullPointerException e) {
                System.out.println("该账户余额为0，请充值");
            }
        }

    }

    /**
     * 根据传入的商品ID删除购物车中的物品
     */
    public static void deleteGoods(String goodsID) {
        if(goodsID == null) {
            System.out.println("商品名不能为空");
            shoppingChartSelect();                      //如果商品名为空则返回选择商品功能界面
        }else {
            String objectID;
            for (Goods goods :ShoppingDao.shoppingChart) {
                objectID = goods.getGoodsID();
                if(objectID.equals(goodsID)) {
                    ShoppingDao.shoppingChart.remove(goods);
                    System.out.println("删除成功！");
                    return;
                }
            }
            System.out.println("购物车中找不到该商品");
        }
    }

    /**
     * 充值逻辑
     */
    public static void charge() {

    }

}
