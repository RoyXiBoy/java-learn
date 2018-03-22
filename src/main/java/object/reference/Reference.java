package object.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by xlt on 20180322.
 */
//了解就好  几乎用不到 而且容易出问题 gc没那么听话。
public class Reference {

    //Strong reference ,一个对象具有强引用，那么垃圾回收器就绝不会回收它
    String name = new String("张灿");

    //Soft reference , 一个对象只具有软引用，当内存空间足够时，垃圾回收器不会回收它，如果内存空间不足，那么垃圾回收器就会回收这个对象的内存。
    //特性很适合用来实现缓存：比如网页缓存、图片缓存等。
    String a = null;

    ReferenceQueue<String> referenceQueue = new ReferenceQueue<String>();
    SoftReference<String> softReferenceB = new SoftReference<String>(a, referenceQueue);
    /*
    第二个参数是一个 引用队列ReferenceQueue，如果软引用所引用的对象被垃圾回收，就会把这个软引用加入到与之关联的引用队列中。
     */

    //weakreference
    //一个对象只有弱引用，则这个对象具有更短暂的生命周期。当垃圾回收器回收内存时，不管内存空间是否充足，这个对象都会被回收。
    //如果这个对象是偶尔的使用，并且希望在使用时随时就能获取到，但又不想影响此对象的垃圾收集
    String b = new String("你好");
    WeakReference<String> weakReferenceA = new WeakReference<String>(a);

    //ReferenceQueue<String> referenceQueue = new ReferenceQueue<String>();
    WeakReference<String> weakReferenceB = new WeakReference<String>(a, referenceQueue);

    //PhantomReference
    //如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收。
    //无法通过虚引用来取得示例。虚引用的目的是为了对象在回收时候收到系统通知。

    String c = new String("你好");
    //ReferenceQueue<String> referenceQueue = new ReferenceQueue<String>();
    PhantomReference<String> phantomReferenceA = new PhantomReference<String>(a, referenceQueue);


}
