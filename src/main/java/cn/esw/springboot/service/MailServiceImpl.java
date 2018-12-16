package cn.esw.springboot.service;


import cn.esw.springboot.dao.HandlerDaoImpl;
import cn.esw.springboot.dao.MailDaoImpl;
import cn.esw.springboot.model.Handler;
import cn.esw.springboot.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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

                Mail mail = new Mail("mgl",2,num);
                num++;
                mailDaoImpl.addMail(mail);
                return mail.receive();
        }


        //发货
        @Override
        public String send(){
        Mail mail = new Mail("A",1,num);
        num++;
        int type = mail.getType();
        Handler handler = new Handler(handlerDaoImpl.getName(type),type);
        return handler.send();
        }



}
