import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Test {
    public static void main(String[] args) {
        Timer timer;
        Submitter zq = new Submitter(1,"zq");   //发信人
        Submitter mcz = new Submitter(1,"mcz",12,12,21,30);   //发信人
//        Handler handler = ESW.createNoodles(zq.type);
        Handler handler1 = ESW.createNoodles(mcz.type);
        new TimerTest02();
//        handler.send();
//        handler1.send();
    }

}
