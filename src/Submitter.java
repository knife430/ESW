public class Submitter {
    public int type;//投递类型
    public int month;
    public int day;
    public int hour;
    public int mintue;
    public String name;
    public Submitter(int type,String name){
        this.type = type;
        this.name = name;
        if(type==1){
            System.out.println("客户"+name+"发出纸质信件快递");
        }
        if(type==2){
            System.out.println("客户"+name+"发出新商品快递");
        }
        if(type==3){
            System.out.println("客户"+name+"发出办公用品快递");
        }

    }
    public Submitter(int type,String name,int month,int day,int hour,int mintue){
        this.type = type;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.mintue = mintue;
        this.name = name;
        if(type==1){
            System.out.print("客户"+name+"发出纸质信件快递");
        }
        if(type==2){
            System.out.print("客户"+name+"发出新商品快递");
        }
        if(type==3){
            System.out.print("客户"+name+"发出办公用品快递");
        }
            System.out.println(" 指定时间是"+month+"月"+day+"日"+hour+"点"+mintue+"分");
    }
}
