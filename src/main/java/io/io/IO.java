package io.io;

/**
 * Created by xlt on 20180315.
 */

/**
 * 设备上的数据无论是图片或者视频，文字，它们都以二进制存储的。
 * 二进制的最终都是以一个8位为数据单元进行体现，所以计算机中的最小数据单元就是字节。
 * 意味着，字节流可以处理设备上的所有数据，所以字节流一样可以处理字符数据。
 *
 *结论：只要是处理纯文本数据，就优先考虑使用字符流。 除此之外都使用字节流
 */

/**
  常用的节点流

 父　类 ：InputStream 、OutputStream、 Reader、 Writer
 文　件 ：FileInputStream 、 FileOutputStrean 、FileReader 、FileWriter 文件进行处理的节点流
 数　组 ：ByteArrayInputStream、 ByteArrayOutputStream、 CharArrayReader 、CharArrayWriter 对数组进行处理的节点流（对应的不再是文件，而是内存中的一个数组）
 字符串 ：StringReader、 StringWriter 对字符串进行处理的节点流
 管　道 ：PipedInputStream 、PipedOutputStream 、PipedReader 、PipedWriter 对管道进行处理的节点流

 常用的处理流

 缓冲流：BufferedInputStream 、BufferedOutputStream、 BufferedReader、 BufferedWriter 增加缓冲功能，避免频繁读写硬盘。
 转换流：InputStreamReader 、OutputStreamReader实现字节流和字符流之间的转换。
 数据流： DataInputStream 、DataOutputStream 等-提供将基础数据类型写入到文件中，或者读取出来。

 */
public class IO {



}
