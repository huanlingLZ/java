package bean;

/**
 * @Description 商品
 * @Author
 * @Date 2022-12-24
 * @Version 1.0
 */
public class Goods {

    /** 商品ID */
    private String goodsID;

    /** 商品名 */
    private String goodsName;

    /** 价格 */
    private Double price;

    /** 类别 */
    private String category;

    /** 商品数量 */
    private Integer number;

    public Goods() {
    }

    public Goods(String goodsID, String goodsName, Double price, String category) {
        this(goodsID, goodsName, price, category, 1);
    }

    public Goods(String goodsID, String goodsName, Double price, String category, Integer number) {
        this.goodsID = goodsID;
        this.goodsName = goodsName;
        this.price = price;
        this.category = category;
        this.number = number;
    }

    public String getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    public String toString(){
        return "Goods{" +
                "goodsID='" + goodsID + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", number=" + number +
                '}';
    }
}
