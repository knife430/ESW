package cn.esw.springboot.Util;

import cn.esw.springboot.dao.MailDaoImpl;
import cn.esw.springboot.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Component//被spring容器管理

public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private MailDaoImpl mailDaoImpl;



    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("-------------->" + "项目启动，now=" + new Date());
        myTimer();
    }

    public void myTimer(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                List<Mail> list = mailDaoImpl.getState(1);
                if(list.size()>0){
                    for(int i=0;i<list.size();i++){
                        Date a =list.get(i).getTimestamp();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        String systemTime = new SimpleDateFormat("yyyy-MM-dd kk:mm").format(new Date().getTime());// 获取系统时间
                        String paramTime = new SimpleDateFormat("yyyy-MM-dd kk:mm").format(a.getTime());
                        long difference = 0;
                        try {
                            Date systemDate = dateFormat.parse(systemTime);
                            Date paramDate = dateFormat.parse(paramTime);
                            difference = systemDate.getTime() - paramDate.getTime();
                            if(difference==0){
                                if(list.get(i).getType()==0){
                                    System.out.println("快递员A发货");
                                }
                                if(list.get(i).getType()==1){
                                    System.out.println("快递员B发货");
                                }
                                if(list.get(i).getType()==2){
                                    System.out.println("快递员C发货");
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, 0, 60000);
    }
}
