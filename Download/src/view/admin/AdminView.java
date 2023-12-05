package view.admin;

import bean.Goods;
import dao.ShoppingDao;
import service.AdminService;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description 管理员界面
 * @Author
 * @Date 2022-12-24
 * @Version 1.0
 */
public class AdminView {

    /**
     * 展示功能选项信息
     *  1.添加商品
     *  2.修改商品
     *  3.商品分类
     *  4.删除商品
     *  5.退出登录
     */
    public static void showOptions() {
        Scanner input=new Scanner(System.in);
        ShoppingDao shoppingDao=new ShoppingDao();
        ArrayList<Goods> goods=shoppingDao.getStorage();
        while (true){
            System.out.println("1.添加商品\n" +
                    "2.修改商品\n" +
                   // "3.商品分类\n" +
                    "3.删除商品\n" +
                    "4.退出登录");
            System.out.println("请输入你的操作：");
            int op=input.nextInt();
            switch (op){
                case 1:
                    AdminService.addGoods();
                    break;
                case 2:
                    new AdminService().changeGoodsInfo();
                    break;
                case 3:
                    AdminService.deleteGoods();
                    break;
                case 4:
                    return;
                case 5:
                    return;
                case 0:
                    break;
                default:
                    System.out.println("输入有错误，请重新输入");
                    break;
            }
            if(op==0){
                break;
            }
        }
        goods=shoppingDao.getStorage();
        for (int i = 0; i < goods.size(); i++) {
            System.out.println("第"+(i+1)+"个商品："+goods.get(i).getGoodsID()+"\t"+goods.get(i).getGoodsName()+"\t"+goods.get(i).getPrice()+"\t"+goods.get(i).getCategory()+"\t"+goods.get(i).getNumber());
        }
    }

    public static void showSelectInfo(){
        AdminService.select();
    }


    //删除
    public static void deleteGoods(String goodsID) {
        if (goodsID != null) {
            dao.ShoppingDao shoppingStorage = new dao.ShoppingDao();
            ArrayList<Goods> goodsStorage = shoppingStorage.getStorage();
            String objectGoodsID;
            for (Goods goods :goodsStorage) {
                objectGoodsID = goods.getGoodsID();
                if(objectGoodsID.equals(goodsID)) {                 //在仓库中找到与传入商品ID相同的商品
                    goodsStorage.remove(goods);                     //删除目标商品
                    break;
                }
            }
        }else {
            System.out.println("请输入商品ID");
        }
}
}
