package cn.esw.springboot.Util;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//定时方法
@Controller
public class ScheduleApplication {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        return new ThreadPoolTaskScheduler();
    }

    private ScheduledFuture<?> future;

 //   private String cronStr = "00 21 20 17 12 * ";

    public String startCron1(String cronStr){

        threadPoolTaskScheduler.schedule(new Say(), new Trigger(){
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext){
                return new CronTrigger(cronStr).nextExecutionTime(triggerContext);
            }
        });
        return "*****";
    }






}
