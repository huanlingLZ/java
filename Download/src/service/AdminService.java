package service;

import bean.Goods;
import dao.ShoppingDao;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description 管理员的交互逻辑
 * @Author
 * @Date 2022-12-24
 * @Version 1.0
 */
public class AdminService {

    /**
     * 根据用户不同的选择，做不同的逻辑处理
     *  1.添加商品
     *  2.修改商品
     *  3.删除商品
     *  4.退出登录
     */
    public static void select() {
        while (true) {
            System.out.println("============卖家功能界面============");
            System.out.println("        添加商品:1 ");
            System.out.println("        修改商品:2 ");
            System.out.println("        删除商品:3 ");
            System.out.println("        退出登录:4 ");
            Scanner sc = new Scanner(System.in);
            System.out.println("        请输入您想要进行的操作 ");
            int number = sc.nextInt();
            switch (number){
                case 1:
                    addGoods();

                    break;
                case 2:
                    changeGoodsInfo();
                    break;
                case 3:

                    deleteGoods();
                    break;
                case 4:
                    System.out.println("退出成功");
                    return;
                default:
                    System.out.println("输入有误，需重新输入");

            }

    }}

    /**
     * 给仓库中添加商品
     */
    public static void addGoods() {

        ShoppingDao storage = new ShoppingDao();
        ArrayList<Goods> goods = storage.getStorage();
       // int i = 0;
        while (true) {
            System.out.println("请您依次输入想要添加的商品信息");
            Scanner sc = new Scanner(System.in);
            System.out.println("商品编号");
            String id = sc.nextLine();
            System.out.println("商品名");
            String name = sc.nextLine();
            System.out.println("价格");
            double price = sc.nextDouble();
            System.out.println("类别");
            String category = sc.next();
            System.out.println("商品数量");
            int number = sc.nextInt();
            Goods good = new Goods();
            good.setGoodsID(id);
            good.setGoodsName(name);
            good.setCategory(category);
            good.setNumber(number);
            good.setPrice(price);
            goods.add(good);

            //测试
            for (Goods goods1 :goods) {
                System.out.println(goods1.getGoodsID() + " " + goods1.getGoodsName() + " " + goods1.getCategory()
                        + " " + goods1.getPrice() + " " + goods1.getNumber());
            }
            System.out.println("输入是否添加0：是 1：否");
            int i=sc.nextInt();
            if(i==1){
                break;
            }
        }
    }
    /**
     * 修改商品参数
     */
    public static void changeGoodsInfo() {
        Scanner input=new Scanner(System.in);
        ShoppingDao shoppingDao=new ShoppingDao();
        ArrayList<Goods> goods=shoppingDao.getStorage();
        int s=0;
        while (true){
            System.out.println("BuyerService");
            for (int i = s; i < s+5; i++) {
                System.out.println("第"+(i+1)+"个商品："+goods.get(i).getGoodsID()+"\t"+goods.get(i).getGoodsName()
                        +"\t"+goods.get(i).getPrice()+"\t"+goods.get(i).getCategory()+"\t"+goods.get(i).getNumber());
            }
            System.out.println("1.上一页\n"+"2.下一页\n");
            int op=input.nextInt();
            if(op==1){
                if(s-5<0){
                    s=0;
                }else {
                    s-=5;
                }
            }else if(op==2){
                if(s+10<=goods.size()){
                    s+=5;
                }else {
                    s=goods.size()-5;
                }
            }else{
                break;
            }
        }
        while(true){
            System.out.println("请输入要修改为第几号商品，输入0为退出");
            int op=input.nextInt();
            if(op==0){
                break;
            }
            System.out.println("第"+(op)+"个商品："+goods.get(op-1).getGoodsID()+"\t"+goods.get(op-1).getGoodsName()
                    +"\t"+goods.get(op-1).getPrice()+"\t"+goods.get(op-1).getCategory()+"\t"+goods.get(op-1).getNumber());
            System.out.println("请输入商品的ID");
            String id=input.next();
            System.out.println("请输入商品的商品名");
            String name=input.next();
            System.out.println("请输入商品的价格");
            Double price=input.nextDouble();
            System.out.println("请输入商品的类别");
            String category=input.next();
            System.out.println("请输入商品的数量");
            Integer number=input.nextInt();
            goods.set(op-1,new Goods(id,name,price,category,number));
            System.out.println("该商品已修改：");
            System.out.println("第"+(op)+"个商品："+goods.get(op-1).getGoodsID()+"\t"+goods.get(op-1).getGoodsName()
                    +"\t"+goods.get(op-1).getPrice()+"\t"+goods.get(op-1).getCategory()+"\t"+goods.get(op-1).getNumber());
        }
    }

    /**
     * 删除商品 通过输入商品ID来删除指定商品
     */
    public static void deleteGoods() {
        System.out.println("输入删除商品ID");
        Scanner oo = new Scanner(System.in);
        String goodsID= oo.next();
        if (goodsID != null) {
            ShoppingDao shoppingStorage = new ShoppingDao();
            ArrayList<Goods> goodsStorage = shoppingStorage.getStorage();
            String objectGoodsID;
            for (Goods goods :goodsStorage) {
                objectGoodsID = goods.getGoodsID();
                if(objectGoodsID.equals(goodsID)) {                 //在仓库中找到与传入商品ID相同的商品
                    goodsStorage.remove(goods);                     //删除目标商品
                    System.out.println("商品删除成功");
                    break;
                }

            }
        }else {
            System.out.println("商品没有查询该商品");

        }
    }

//    /**
//     * 删除商品 根据商品ID和待删除的商品数量可以删除相关数量的该商品
//     */
//
//    public static void deleteGoods(String goodsID,int deleteNumber) {
//        if (goodsID != null) {
//            ShoppingDao shoppingStorage = new ShoppingDao();
//            ArrayList<Goods> goodsStorage = shoppingStorage.getStorage();
//            String objectGoodsID;
//            int goodsNumber;
//            for (Goods goods :goodsStorage) {
//                objectGoodsID = goods.getGoodsID();
//                if(objectGoodsID.equals(goodsID)) {                 //在仓库中找到与传入商品ID相同的商品
//                    goodsNumber = goods.getNumber();
//                    if(goodsNumber < deleteNumber) {
//                        System.out.println("该商品剩余数量较少，剩余：" + goodsNumber);
//                    }else {
//                        goods.setNumber(goodsNumber - deleteNumber);          //删除相应数量的该商品
//                        goodsNumber = goods.getNumber();
//                        if(goodsNumber == 0)
//                            AdminService.deleteGoods(objectGoodsID);
//                    }
//                    break;
//                }
//            }
//            //以下遍历为检验删除功能是否正常
//            for (Goods goods :goodsStorage) {
//                System.out.println(goods.getGoodsID() + " " + goods.getGoodsName() + " " + goods.getCategory()
//                        + " " + goods.getPrice() + " " + goods.getNumber());
//            }
//        }else {
//            System.out.println("请输入商品ID");
//        }
//    }
}
