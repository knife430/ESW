import java.util.Date;

public class Test {
    public static void main(String[] args) {

        Submitter xjp = new Submitter(1);   //发信人
        Handler handler = ESW.createNoodles(xjp.type);
        handler.send();
    }
}
