package io.IO.Stream.Buffer;

/**
 * Created by xlt on 20180316.
 */

import java.io.*;

/**
 BufferedInputStream和BufferedOutputStream这两个类分别是FilterInputStream和FilterOutputStream的子类，
 作为装饰器子类，使用它们可以防止每次读取/发送数据时进行实际的写操作，代表着使用缓冲区。

 我们有必要知道不带缓冲的操作，每读一个字节就要写入一个字节，由于涉及磁盘的IO操作相比内存的操作要慢很多，所以不带缓冲的流效率很低。
 带缓冲的流，可以一次读很多字节，但不向磁盘中写入，只是先放到内存里。
 等凑够了缓冲区大小的时候一次性写入磁盘，这种方式可以减少磁盘操作次数，速度就会提高很多！
 */
public class MyBufferedStream {

    /*一般方法
    int available();  //返回底层流对应的源中有效可供读取的字节数

    void close();  //关闭此流、释放与此流有关的所有资源

    boolean markSupport();  //查看此流是否支持mark

    void mark(int readLimit); //标记当前buf中读取下一个字节的下标

    int read();  //读取buf中下一个字节

    int read(byte[] b, int off, int len);  //读取buf中下一个字节

    void reset();   //重置最后一次调用mark标记的buf中的位子

    long skip(long n);  //跳过n个字节、 不仅仅是buf中的有效字节、也包括in的源中的字节
     */


    /*
    //在这里提一句,`BufferedOutputStream`没有自己的`close`方法,当他调用父类`FilterOutputStrem`的方法关闭时,会间接调用自己实现的`flush`方法将buf中残存的字节flush到out中,再`out.flush()`到目的地中,DataOutputStream也是如此。

    void  flush();  将写入bos中的数据flush到out指定的目的地中、注意这里不是flush到out中、因为其内部又调用了out.flush()

    write(byte b);      将一个字节写入到buf中

    write(byte[] b, int off, int len);      将b的一部分写入buf中
     */

    /**
     * 复制文件
     * @param oldFile
     * @param newFile
     */
    public static void copyFile( File oldFile , File newFile) {

        try (InputStream inputStream = new FileInputStream(oldFile);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

             OutputStream outputStream = new FileOutputStream(newFile);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream)){

            //代表一次最多读取1KB的内容
            byte[] b = new byte[1024];

            //代表实际读取的字节数
            int length = 0;

            while ((length = bufferedInputStream.read(b)) != -1) {
                //length 代表实际读取的字节数
                bufferedOutputStream.write(b, 0, length);
            }
            //缓冲区的内容写入到文件
            bufferedOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
