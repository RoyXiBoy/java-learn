package thread.Bank;

/**
 * Created by xlt on 20180309.
 */
class DecRunnable implements Runnable {
    Bank data;
    public DecRunnable(Bank data){
        this.data = data;
    }

    @Override
    public void run() {

        data.dec();

    }

}
