package cn.esw.springboot.Util;

import cn.esw.springboot.dao.MailDaoImpl;
import cn.esw.springboot.dao.SubmitterDaoImpl;
import cn.esw.springboot.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
//定时功能
@Component//被spring容器管理

public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private MailDaoImpl mailDaoImpl;
    @Autowired
    private SubmitterDaoImpl submitterDaoImpl;

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
                List<Mail> ranklist = new ArrayList<Mail>();
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
                                    ranklist.add(list.get(i));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if(ranklist.size()==1){
                        if(ranklist.get(0).getType()==0){
                            System.out.println(ranklist.get(0).getNumber()+"快递员A发货");
                        }
                        if(ranklist.get(0).getType()==1){
                            System.out.println(ranklist.get(0).getNumber()+"快递员B发货");
                        }
                        if(ranklist.get(0).getType()==2){
                            System.out.println(ranklist.get(0).getNumber()+"快递员C发货");
                        }

                    }
                    if(ranklist.size()>1){
                        printGroup(ranklist);


                    }
                }
            }
        }, 0, 60000);
    }
    public static void printGroup(List<Mail> list) {
        list.sort(new Comparator<Mail>() {
            @Override
            public int compare(Mail o1, Mail o2) {
                if (o1.getRank()> o2.getRank()) {
                    return -1;
                }else if(o1.getRank() < o2.getRank()){
                    return 1;
                }else {
                        return o1.getName().compareTo(o2.getName());
                    }
                }

        });
        for (Mail mail : list) {
            if(mail.getType()==0){
                System.out.println(mail.getNumber()+"快递员A发货");
            }
            if(mail.getType()==1){
                System.out.println(mail.getNumber()+"快递员B发货");
            }
            if(mail.getType()==2){
                System.out.println(mail.getNumber()+"快递员C发货");
            }

        }
    }


}
