package multiThread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: some desc
 * @author: sherlockchen
 * @date: 2025/6/28 12:24
 */
public class ThreadLocalDemo {

    static class SafeDateFormat {
        //定义ThreadLocal变量
        static final ThreadLocal<DateFormat> tl
                = ThreadLocal.withInitial(()-> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        static DateFormat get(){
//            System.out.println(tl.get().toString());
            Date now = new Date();
            String formattedTime = tl.get().format(now);
            System.out.println(formattedTime);
            return tl.get();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        DateFormat safeDateFormat = SafeDateFormat.get();

        Thread t1 = new Thread(SafeDateFormat::get);
        Thread t2 = new Thread(SafeDateFormat::get);

        t1.start();
        Thread.sleep(500);
        t2.start();

        t1.join();
        t2.join();

    }

}
