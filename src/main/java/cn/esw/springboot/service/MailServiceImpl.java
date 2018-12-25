package cn.esw.springboot.service;


import cn.esw.springboot.dao.HandlerDaoImpl;
import cn.esw.springboot.dao.MailDaoImpl;
import cn.esw.springboot.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MailServiceImpl implements MailService{
        static volatile int num = 0;
        @Autowired
        private HandlerDaoImpl handlerDaoImpl;
        @Autowired
        private MailDaoImpl mailDaoImpl;


        //收货
        @Override
        public String receive(){
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm");    // 这里填写的是想要进行转换的时间格式
                String str = "2018-12-25 17:39";         // 时间字符串
                Date date = null;
                try{
                        date = format.parse(str);
                }catch(Exception e){
                        e.printStackTrace();
                }
                Timestamp timeStamp = new Timestamp(date.getTime());
                Mail mail = new Mail();
                mail.setTimestamp(timeStamp);
                num++;

                mailDaoImpl.addMail(mail);
                return mail.receive();
        }


        //发货
        @Override
        public void send(){
                //type为0的id list，，每个id对应type，每个id派不同快递派送（打印），将state改为2；
                List<Mail> list = mailDaoImpl.getState(0);
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
                        list.get(i).setState(2);
                        mailDaoImpl.upDate(list.get(i));
                }
        }



}
