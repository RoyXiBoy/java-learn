package reflect.proxy;

/**
 * Created by xlt on 20180320.
 */

/**
 * 动态代理技术就是用来产生一个对象的代理对象的
 *
 * 明确两件事：
 * 1、代理对象存在的价值主要用于拦截对真实业务对象的访问。
 　2、代理对象应该具有和目标对象(真实业务对象)相同的方法。

 java在JDK1.5之后提供了一个"java.lang.reflect.Proxy"类，通过"Proxy"类提供的一个newProxyInstance方法用来创建一个对象的代理对象
 */

public class ProxyTest{

    public static void main(String[] args) {
        LiuDeHuaProxy ldhProxy = new LiuDeHuaProxy();

        Persion p = ldhProxy.getProxy();

        String song = p.sing("冰雨");

        String dance = p.dance("gay");

    }
}