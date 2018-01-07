### 第一级别：精读源码该级别包含的包如下：
- [ ] java.io
- [ ] java.lang
- [ ] java.util
> 精读源码，这是要求最高的级别。但是，要求你精读源码并不意味着，这些类就是最重要的。而是因为，LZ觉得这些类比较常用，而且比较简单，看看它们的源码有助于锻炼你看源码的感觉，也了解一下大神们写代码的风格。看这些源码的目的，更多是为了增加你的阅读代码能力。而且，LZ这里必须要强调一下，像Exception和Error这一类的，就不用读源码了，亲。其实上面三个包都有一个共同点，那就是这三个包，基本上都是你最常用的了。lang包不用说了，你随便写点啥都得用到，io包和util包也是你平时读写文件和使用数据结构必不可少的。

**学习路线如下**：

- lang-->util-->io
- 版本：java8
- 时间：2018.1.6

#### 1. java.lang.Object
#### native 一个Native Method就是一个Java调用非Java代码的接口。

##### registerNatives()
###### 在内存中分配空间

#####  hashcode
###### This is typically implemented by converting the internal address of the object into an integer, but this implementation technique is not required by the Java™ programming language.(这通常是通过将对象的内部地址转换为整数来实现的，但是Java编程语言不需要这种实现技术。)

##### notify notifyAll wait()
###### 线程唤醒 notify notifyAll （唤醒无法进行下一步直至获取到释放出来的锁（The awakened thread will not be able to proceed until the current thread relinquishes the lock on this object），自由竞争方式获取。
###### 等待 wait() wait(long timeout) wait(long timeout, int nanos) 活动的线程去wait状态。wait()=wait(0) ，wait(long timeout, int nanos)精确到纳秒

##### getClass()  
###### （todo 看完jvm再理解这句话）Returns the runtime class of this Object. The returned Class object is the object that is locked by static synchronized methods of the represented class

##### clone()
###### 浅拷贝 obeject must the interface Cloneable 
> ###### By convention, the returned object should be obtained by calling super.clone. If a class and all of its superclasses (except Object) obey this convention, it will be the case that x.clone().getClass() == x.getClass().By convention, the object returned by this method should be independent of this object (which is being cloned). To achieve this independence, it may be necessary to modify one or more fields of the object returned by super.clone before returning it. Typically, this means copying any mutable objects that comprise the internal "deep structure" of the object being cloned and replacing the references to these objects with references to the copies. If a class contains only primitive fields or references to immutable objects, then it is usually the case that no fields in the object returned by super.clone need to be modified. 

##### equals(Object obj)
###### reflexive自反性 symmetric对称性 transitive传递性 consistent一致性

##### toString(Object obj) 建议重写
###### 普通 getClass().getName() + '@' + Integer.toHexString(hashCode())


##### finalize()
###### 垃圾回收器 用来结束类。抛出的异常，都会被忽略。但是类依旧会被终结，释放内存 

#### 2. Class
1.toString  -->"class" or "interface"   toGenericString()-->modifiers and type parameters  
2.isPrimitive() 是否是基本类型 isAnnotation() 是否是注解annotation（all annotation types are also interfaces） isSynthetic() 是否是人造的 isArray() isInterface() isAssignableFrom(Class<?> cls)（确认类是否是原类的超类或同类）isInstance(Object obj)动态等价于Instanceof isEnum()
3.forName0 

##### 

#### 第二级别：深刻理解该级别包含的包如下：
- [ ] java.lang.reflect
- [ ] java.net
- [ ] javax.net.*
- [ ] java.nio.*
- [ ] java.util.concurrent.*
> 深刻理解，这个看似比精读源码要求低的级别，其实恰恰是最重要的。这个级别要求的类，全都是一些进阶到高级所必须了解的。当然了，这里要强调一点的是，LZ说这些类要深刻理解，而没说要看它们源码，并不是说这些类的源码不能看，或者看了没用。而是这些类的源码往往非常复杂，要了解清楚细节花费的时间是非常多的，因此，花费巨量的时间去研究这么复杂的代码其实没必要的。不过，如果你在使用这些类的过程中，遇到了问题，这个时候如果看它们源码可以解决的话，那就不要再矜持了，果断看看源码解决你的问题吧，这是最适合的看源码的契机了。小小的透露一下，LZ看过的JDK源码，基本上全是这么看过来的。遇到了问题不要百度和谷歌，看源码能解决你90%的问题。此外，看到这四个包的名字，不难看出它们各自代表了什么。
reflect代表了反射，net代表了网络IO，nio代表了非阻塞io，concurrent代表了并发。这四个家伙可以说每一个都够面试官问上半天的，而且，这四个包的内容，如果你要深刻理解的话，其实还牵扯了很多其它的知识。举个例子，反射你要了解清楚的话，你是不是要搞明白JVM的类加载机制？网络IO要搞清楚的话，你是不是要清楚TCP/IP和HTTP、HTTPS？包括并发包，如果你要搞清楚的话，是不是要了解并发的相关知识？因此，这四个包要彻底搞清楚，还是需要花费一定时间和精力的。但是，请相信LZ，这绝对是值得的，甚至可以说，这四个包用的够不够叼，基本决定了一个Java程序员所处的档次。



#### 第三级别：会用即可该级别包含的包如下：java.lang.annotation
- [ ] javax.annotation.*
- [ ] java.lang.ref
- [ ] java.math
- [ ] java.rmi.*
- [ ] javax.rmi.*
- [ ] java.security.*
- [ ] javax.security.*
- [ ] java.sql
- [ ] javax.sql.*
- [ ] javax.transaction.*
- [ ] java.text
- [ ] javax.xml.*
- [ ] org.w3c.dom.*
- [ ] org.xml.sax.*
- [ ] javax.crypto.*
- [ ] javax.imageio.*
- [ ] javax.jws.*
- [ ] java.util.jar
- [ ] java.util.logging
- [ ] java.util.prefs
- [ ] java.util.regex
- [ ] java.util.zip
> 会用即可，这个级别的要求很显然了，就是会用就可以了。这些包大部分都是在特定的情况下会用到，但却不会时刻用到。就像sql包和transaction包，就是操作数据库时用到的。而xml、dom和sax这些，都是操作xml时用到的。其它的包也都是类似的，有使用注解时用的，有远程方法调用时用的，也有涉及到加密时用到的等等。这些包在面试时一般不会问到，所以它们的重要性自然要低很多，而且也不太需要刻意的去学，用到了研究一下，会用即可。