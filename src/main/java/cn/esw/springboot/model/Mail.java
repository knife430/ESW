package cn.esw.springboot.model;

import java.sql.Timestamp;

public class Mail {

    /*
    商品信息：
    1.发送人名字
    2.商品类型
    3.订单号
    4.商品状态：0为没有指定时间商品待发货，1为指定时间的商品，2为已经发完货的商品
     */
    //必填参数
    private String name;//发送人名字
    private int type;//类型
    private int number;//订单号

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    private int state; //订单状态

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    private Timestamp timestamp ;

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


    public String receive(){
        System.out.println("收到"+name+type+"类型的邮件");
        return "收到"+name+type+"类型的邮件";

    }



}
