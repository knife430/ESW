package cn.esw.springboot.service;


import cn.esw.springboot.Util.ScheduleApplication;
import cn.esw.springboot.dao.HandlerDaoImpl;
import cn.esw.springboot.dao.MailDaoImpl;
import cn.esw.springboot.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ScheduledFuture;

@Service
public class MailServiceImpl implements MailService{
        static volatile int num = 0;
        @Autowired
        private HandlerDaoImpl handlerDaoImpl;
        @Autowired
        private MailDaoImpl mailDaoImpl;


        @Autowired
        private ScheduleApplication scheduleApplication;

        private ScheduledFuture<?> future;
 //       private String cronStr = "00 21 20 17 12 * ";

        //收货
        @Override
        public String receive(){

                Mail mail = new Mail("mgl",2,num,1);
                num++;

                mailDaoImpl.addMail(mail);
                if(mail.getState()==1){
                        //生成商品信息
                        int mintue = 29;
                        int hour = 21;
                        int day = 24;
                        int month = 12;
                        String cronStr = "00 "+mintue+" "+hour+" "+day+" "+month+" * ";
                        scheduleApplication.startCron1(cronStr);
                }

                return mail.receive();
        }


        //发货
        @Override
        public void send(){
                //type为0的id list，，每个id对应type，每个id派不同快递派送（打印），将state改为2；
                List<Mail> list = mailDaoImpl.getId(0);
                for(int i=0;i<list.size();i++){
                        if(list.get(i).getType()==0){
                                System.out.println("订单"+list.get(i).getNumber()+"由A快递员发出");
                        }
                        if(list.get(i).getType()==1){
                                System.out.println("订单"+list.get(i).getNumber()+"由B快递员发出");
                        }
                        if(list.get(i).getType()==2){
                                System.out.println("订单"+list.get(i).getNumber()+"由C快递员发出");
                        }

                }
        }



}
