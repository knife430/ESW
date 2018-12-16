import java.util.Calendar;
import java.util.Date;

public class ESW {
    public static final int TYPE_XJ = 1;//纸质信件
    public static final int TYPE_NEW = 2;//有完整包装的新商品
    public static final int TYPE_BG = 3;//日常办公用品

    public static Handler createNoodles(int type) {
        switch (type) {
            case TYPE_XJ:
                System.out.println("ESW收到纸质信件快递");
                return new HandlerA();
            case TYPE_NEW:
                System.out.println("ESW收到有完整包装的新商品快递");
                return new HandlerB();
            case TYPE_BG:
            default:
                System.out.println("ESW收到日常办公用品快递");
                return new HandlerC();
        }
    }


//    public Date getTime(){
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 11);
//        calendar.set(Calendar.MINUTE, 39);
//        calendar.set(Calendar.SECOND, 00);
//        Date time = calendar.getTime();
//
//        return time;
//    }
}



