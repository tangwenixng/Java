import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by twx on 2017/7/28.
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("*******");
            }
        },1000*3,1000*60*10);
        System.out.println("11111");
    }
}
