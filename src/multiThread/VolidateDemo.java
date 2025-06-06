package multiThread;

class MyNumber{
    int number;

    public synchronized void addPlusPlus() {
        number++;
    }
}
public class VolidateDemo {

    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();
        for (int i = 0; i<100; i++){
            new Thread(() ->{
                for (int j = 0; j<100; j++){
                    myNumber.addPlusPlus();
                }
            },String.valueOf(i)).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(myNumber.number);

    }
}
