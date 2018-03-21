package thread.Bank;

/**
 * Created by xlt on 20180309.
 */
class AddRunnable implements Runnable{
    Bank data;
    public AddRunnable(Bank data){
        this.data= data;
    }

    @Override
    public void run() {

        data.add();

    }

}
