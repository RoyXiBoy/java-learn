package io.io.ReaderWriter;

import java.io.*;

/**
 * Created by xlt on 20180316.
 */
public class StreamReaderWriter {

    /*InputStreamReader
     void  close() // 关闭该流并释放与之关联的所有资源。

    String  getEncoding() //返回此流使用的字符编码的名称。

    int  read()  //读取单个字符。

    int  read(char[] cbuf, int offset, int length) //将字符读入数组中的某一部分。

    boolean  ready() //判断此流是否已经准备好用于读取。
     */



    /*OutputStreamWriter
    void  write(int c)   //写入的字符长度

    void  write(char cbuf[])  //写入的字符数组

    void  write(String str)  //写入的字符串

    void  write(String str, int off, int len)  //应该写入的字符串，开始写入的索引位置，写入的长度

    void  close() //关闭该流并释放与之关联的所有资源。
     */

    public static void main(String[] args) {
        String filePath = "F:/123.txt" ;
        String filePath2 = "F:/abc.txt" ;
        File file = new File( filePath ) ;
        File file2 = new File( filePath2 ) ;
        copyFile( file , file2 );

    }

    private static void copyFile( File oldFile , File newFile ) {

        try (//创建输入流
             InputStream inputStream = new FileInputStream(oldFile);
             //创建转换输入流
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             //创建输出流
             OutputStream outputStream = new FileOutputStream(newFile);
             //创建转换输出流
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream); ){


            int result = 0;
            //一次只读一个字符
            while ((result = inputStreamReader.read()) != -1) {
                //一次只写一个字符
                outputStreamWriter.write(result);
            }

            outputStreamWriter.flush();  //强制把缓冲写入文件

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
