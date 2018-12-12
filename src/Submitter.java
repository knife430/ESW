public class Submitter {
    public int type;//投递类型
    public Submitter(int type){
        this.type = type;
        if(type==1){
            System.out.println("客户发出纸质信件快递");
        }
        if(type==2){
            System.out.println("客户发出新商品快递");
        }
        if(type==3){
            System.out.println("客户发出办公用品快递");
        }

    }
}
