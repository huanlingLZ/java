package view.buyer;

import bean.Goods;
import dao.ShoppingDao;
import service.BuyerService;


/**
 * @Description 购物车界面
 * @Author
 * @Date 2022-12-24
 * @Version 1.0
 */
public class ShoppingChartView {
    /**
     * 展示用户购物车的内容
     */
    public static void showShoppingChartInfo() {
        if (ShoppingDao.shoppingChart.isEmpty()) {                          //购物车为空时
            System.out.println("----------------");
            System.out.println("|   购物车为空   |");
            System.out.println("----------------");
        } else {                                                            //购物车不为空，展示购物车中的内容
            System.out.println("--------------------------------" +
                    "----------------------------------------------------");
            System.out.print(String.format("%-25s\t","商品ID"));
            System.out.print(String.format("%-25s\t","商品名"));
            System.out.print(String.format("%-25s\t","商品价格"));
            System.out.println(String.format("%-25s\t","商品类别"));
            for (Goods goods :ShoppingDao.shoppingChart) {
                System.out.print(String.format("%-25s\t",goods.getGoodsID()));
                System.out.print(String.format("%-25s\t",goods.getGoodsName()));
                System.out.print(String.format("%-25s\t",goods.getPrice()));
                System.out.println(String.format("%-25s\t",goods.getCategory()));
            }
            System.out.println("--------------------------------" +
                    "----------------------------------------------------");
        }
    }


    /**
     * 功能：展示购物界面的选项，供用户进行选择
     *      1. 购物
     *      2. 结算
     *      3. 删除商品
     *      4. 返回上一层
     */
    public static void showOptions() {
        System.out.println("----------------");
        System.out.println("|    购物界面    |");
        System.out.println("| 1. 购物       |");
        System.out.println("| 2. 结算       |");
        System.out.println("| 3. 删除商品    |");
        System.out.println("| 4. 返回上一层  |");
        System.out.println("----------------");
        BuyerService.shoppingChartSelect();
    }

}
