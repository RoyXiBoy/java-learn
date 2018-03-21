package reflect.proxy;

/**
 * Created by xlt on 20180320.
 */
public class LiuDeHua implements Persion {
    @Override
    public String sing(String name) {
        System.out.println("刘德华唱"+name+"歌！！");
        return "歌唱完了，谢谢大家！";
    }

    @Override
    public String dance(String name) {
        System.out.println("刘德华跳"+name+"舞！！");
        return "舞跳完了，谢谢大家！";
    }
}
