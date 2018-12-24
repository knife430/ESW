package cn.esw.springboot.Util;

import java.util.Date;
public class Say implements Runnable {
    @Override
    public void run(){
        System.out.println("" + new Date() + "发出快递");
    }
}
