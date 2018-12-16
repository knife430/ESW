package cn.esw.springboot.model;

public class Mail {

    /*
    商品信息：
    1.发送人名字
    2.商品类型
    3.指定时间
    4.发送人等级
    5.订单号
     */
    //必填参数
    private String name;//发送人名字
    private int type;//类型
    private int number;//订单号




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }




    public Mail(String name, int type, int number) {
        this.name = name;
        this.type = type;
        this.number = number;
    }


    public String receive(){
        System.out.println("收到"+name+type+"类型的邮件");
        return "收到"+name+type+"类型的邮件";

    }



}
