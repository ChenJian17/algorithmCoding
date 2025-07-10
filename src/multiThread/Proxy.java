package multiThread;

class Proxy {
    boolean started = false;
    //采集线程
    Thread rptThread;
    //启动采集功能
    synchronized void start(){
        //不允许同时启动多个采集线程
        if (started) {
            System.out.println("采集功能已启动，无法重复启动");
            return;
        }
        started = true;
        System.out.println("启动采集线程...");
        rptThread = new Thread(()->{
            System.out.println("采集线程已启动，ID: " + Thread.currentThread().getId());
            int count = 0;

            while (!Thread.currentThread().isInterrupted()){
                //省略采集、回传实现
                report();
                count++;
                //每隔两秒钟采集、回传一次数据
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e){
                    System.out.println("采集线程收到中断请求");
                    //重新设置线程中断状态
                    Thread.currentThread().interrupt();
                    break; // 中断后退出循环

                }
            }
            System.out.println("采集线程终止，共执行 " + count + " 次采集");

            //执行到此处说明线程马上终止
            started = false;
        });
        rptThread.start();
    }



    //终止采集功能
    synchronized void stop(){
//        if (!started) {
//            System.out.println("采集功能未启动，无需终止");
//            return;
//        }

        System.out.println("请求终止采集线程...");
        //线程rptThread状态转换到RUNNABLE
        rptThread.interrupt();
    }

    public void report(){
        System.out.println("[" + System.currentTimeMillis() + "] 执行数据采集...");

    }

    public static void main(String[] args) throws InterruptedException{
        Proxy proxy = new Proxy();
        // 1. 启动采集功能
        proxy.start();
        Thread.sleep(5000); // 运行5秒
        proxy.stop();

        // 2. 终止采集功能
        proxy.stop();
        Thread.sleep(2000); // 等待终止

        // 3. 验证是否可重新启动
        System.out.println("\n尝试重新启动采集功能...");
        proxy.start();

        // 4. 再次终止并等待线程完全结束
        Thread.sleep(3000);
        proxy.stop();

        // 等待线程真正终止（使用join）
        if (proxy.rptThread != null) {
            proxy.rptThread.join();
        }
        System.out.println("程序结束");
    }
}
