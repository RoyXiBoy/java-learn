package thread.Bank;

/**
 * Created by xlt on 20180309.
 */
public class TestThread {

    public static void main(String[] args) {
        final Bank data = new Bank();
        for(int i=0;i<2;i++){
            new Thread(new Runnable(){

                @Override
                public void run() {
                    data.add();

                }

            }).start();
            new Thread(new Runnable(){

                @Override
                public void run() {
                    data.dec();

                }

            }).start();
        }
    }

}
