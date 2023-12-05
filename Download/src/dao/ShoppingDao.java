package dao;

import bean.Goods;

import java.util.ArrayList;

/**
 * @Description 购物数据层
 * @Author
 * @Date 2022-12-24
 * @Version 1.0
 */
public class ShoppingDao {
    public static ArrayList<Goods> shoppingChart = new ArrayList<>();      //购物车

    private static ArrayList<Goods> storage;                               //仓库

    {
        storage = new ArrayList<>();
        storage.add(new Goods("10001", "香蕉", 2.00, "水果",10));
        storage.add(new Goods("10002", "苹果", 3.00, "水果",2));
        storage.add(new Goods("10003", "菠萝", 4.00, "水果",20));
        storage.add(new Goods("10004", "梨", 4.50, "水果",3));
        storage.add(new Goods("108","潇雅诗围巾帽子",26.00,"帽饰",1000));
        storage.add(new Goods("201","粗跟切尔西",209.9,"鞋靴",1000));
        storage.add(new Goods("202","卓诗尼短靴",219.0,"鞋靴",1000));
        storage.add(new Goods("203","达芙妮运动鞋",88.0,"鞋靴",1000));
        storage.add(new Goods("204","卡帝乐鳄鱼高帮鞋",298.0,"鞋靴",1000));
        storage.add(new Goods("205","奥康豆豆鞋",138.0,"鞋靴",1000));
        storage.add(new Goods("206","公牛世家休闲鞋",138.0,"鞋靴",1000));
        storage.add(new Goods("207","百达威登板鞋",159.0,"鞋靴",1000));
        storage.add(new Goods("208","海澜之家皮鞋",209.9,"鞋靴",1000));
        storage.add(new Goods("301","Nike加绒刺绣小logo经典运动卫衣",179.0,"运动服饰",1000));
        storage.add(new Goods("302","Nike Sportswear Club French Terry刺绣logo运动圆领套头卫衣",179.0,"运动服饰",1000));
        storage.add(new Goods("303","李宁运动时尚系列加绒宽松圆领套头卫衣",179.0,"运动服饰",1000));
        storage.add(new Goods("304","李宁运动时尚系列刺绣宽松套头秋季",179.0,"运动服饰",1000));
        storage.add(new Goods("305","BRNR复古简约字母印花宽松休闲圆领套头卫衣",172.0,"运动服饰",1000));
        storage.add(new Goods("306","ZMOH简约纯色刺绣休闲宽松落肩加绒套头卫衣",134.0,"运动服饰",1000));
        storage.add(new Goods("307","BEASTER小恶魔休闲简约时尚宽松运动连帽卫衣",129.0,"运动服饰",1000));
        storage.add(new Goods("308","BONELESS 基础字体圆弧胶印logo印花宽松休闲连帽卫衣",122.0,"运动服饰",1000));
        storage.add(new Goods("401","李宁x Disney联名\t183",219.0,"运动服饰",1000));
        storage.add(new Goods("402","NIKE Standard Issue",319.0,"运动服饰",1000));
        storage.add(new Goods("403","李宁运动潮流系列",183.0,"运动服饰",1000));
        storage.add(new Goods("404","TEN MIRO纯色灯芯加绒",209.0,"运动服饰",1000));
        storage.add(new Goods("405","FIDO DIDO字母logo",99.0,"运动服饰",1000));
        storage.add(new Goods("406","HELIPORT 纯色基础直筒长裤",133.0,"运动服饰",1000));
        storage.add(new Goods("407","Nike Sportswear Essential",132.0,"运动服饰",1000));
        storage.add(new Goods("408","LBPC内侧条纹直筒宽松休闲长裤",172.0,"运动服饰",1000));

    }

    public ArrayList<Goods> getStorage() {
        return storage;
    }
    public ArrayList<Goods> getShoppingChart(){return shoppingChart;}
    public void setStorage(ArrayList<Goods> storage) {
        this.storage = storage;
    }
}
