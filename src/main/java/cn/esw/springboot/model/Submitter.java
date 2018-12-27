package cn.esw.springboot.model;

public class Submitter {
    public Submitter(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    String name;  //用户名 不能重复，全局唯一

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    int rank;// 会员等级  0：不是会员  1：白银  2：黄金  3.白金  4：至尊

}
