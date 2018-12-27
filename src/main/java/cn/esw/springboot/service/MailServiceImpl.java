package cn.esw.springboot.service;


import cn.esw.springboot.dao.MailDaoImpl;
import cn.esw.springboot.dao.SubmitterDaoImpl;
import cn.esw.springboot.model.Mail;
import cn.esw.springboot.model.Submitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MailServiceImpl implements MailService{
        @Autowired
        private MailDaoImpl mailDaoImpl;

        @Autowired
        private SubmitterDaoImpl submitterDaoImpl;

        @Override
        public String register(){
                String name = "wl";
                int rank = 3;
                Submitter submitter = new Submitter(name,rank);
                submitterDaoImpl.addSubmitter(submitter);
                return name+"已被添加进数据库";
        }



        //收货
        @Override
        public String receive(){
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm");    // 这里填写的是想要进行转换的时间格式
                String str = "2018-12-27 21:50";         // 指定的时间
                Date date = null;
                try{
                        date = format.parse(str);
                }catch(Exception e){
                        e.printStackTrace();
                }
                Timestamp timeStamp = new Timestamp(date.getTime());

                //发快递的用户名
                String name = "wl";


                //生成mail对象
                Mail mail = new Mail();
                mail.setName(name);   //生成姓名
                mail.setType(1);                     //订单类型 0为A 1为B 2为C
                mail.setState(1);                    //订单状态 0为无定时任务 1为又定时任务
                mail.setTimestamp(timeStamp);        //规定时间
                String num = getOrderIdByUUId();
                mail.setNumber(num);                 //订单号 使用uuid
                mail.setRank(submitterDaoImpl.getRank(name));
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

        public static String getOrderIdByUUId() {

                int hashCodeV = UUID.randomUUID().toString().hashCode();
                if(hashCodeV < 0) {//有可能是负数
                        hashCodeV = - hashCodeV;
                }
//         0 代表前面补充0     
//         4 代表长度为4     
//         d 代表参数为正数型
                return   String.format("%011d", hashCodeV);
        }

}
