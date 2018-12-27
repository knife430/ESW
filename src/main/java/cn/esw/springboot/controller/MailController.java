package cn.esw.springboot.controller;

import cn.esw.springboot.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MailController {

    @Autowired
    private MailService mailService;
    //发货
    @RequestMapping("/send")
    public void send(){

         mailService.send();
    }
    //收货
    @RequestMapping("/receive")
    public String reveive(){

        return mailService.receive();
    }

    //新建用户
    @RequestMapping("/register")
    public String register(){

        return mailService.register();
    }
}
