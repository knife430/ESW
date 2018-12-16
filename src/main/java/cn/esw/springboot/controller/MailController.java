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

    @RequestMapping("/send")
    public String send(){

        return mailService.send();
    }

    @RequestMapping("/receive")
    public String reveive(){

        return mailService.receive();
    }
}
