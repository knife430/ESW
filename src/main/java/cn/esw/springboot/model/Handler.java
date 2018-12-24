package cn.esw.springboot.model;

import cn.esw.springboot.Util.Send;

//快递小哥
public class Handler implements Send {
    /*
    小哥姓名   小哥类型
    从数据库中提取
     */
    private String name;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    private int state;

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

    private int type;

    public Handler(String name, int type) {
        this.name = name;
        this.type = type;
    }
    @Override
    public String send(){
        System.out.println("快递小哥"+name+"送货");
        return "快递小哥"+name+"送货";

    }

}
