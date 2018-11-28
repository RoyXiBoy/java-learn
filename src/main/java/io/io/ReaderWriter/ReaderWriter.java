package io.io.ReaderWriter;

import java.io.*;

/**
 * Created by xlt on 20180316.
 */
public class ReaderWriter {

    /*bufferReader
    int  read()  //读取单个字符。
    int  read(char[] cbuf, int off, int len)  //将字符读入数组的某一部分。
    String  readLine()  //读取一个文本行。
    boolean  ready()  //判断此流是否已准备好被读取。
    void  reset()  //将流重置到最新的标记。
    long  skip(long n)  //跳过字符。
    void  close() //关闭该流并释放与之关联的所有资源。
    void  mark(int readAheadLimit) //标记流中的当前位置。
    boolean  markSupported() //判断此流是否支持 mark() 操作（它一定支持）。
     */

    /*BufferedWriter
    void  close()  // 关闭此流，但要先刷新它。
    void  flush()  //刷新该流的缓冲。
    void  newLine() //写入一个行分隔符。
    void  write(char[] cbuf, int off, int len) //写入字符数组的某一部分。
    void  write(int c) //写入单个字符。
    void  write(String s, int off, int len) //写入字符串的某一部分。
     */

    private static void copyFile( File oldFile , File newFile ){

        try (Reader reader = new FileReader( oldFile ) ;
             BufferedReader bufferedReader = new BufferedReader( reader ) ;

             Writer writer = new FileWriter( newFile ) ;
             BufferedWriter bufferedWriter = new BufferedWriter( writer ) ;
                ){

            //每次读取一行的内容
            String result = null ;

            while (  (result = bufferedReader.readLine() ) != null ){
                //把内容写入文件
                bufferedWriter.write( result );

                //换行，result 是一行数据，所以没写一行就要换行
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();  //强制把数组内容写入文件

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String filePath = "F:/123.txt" ;
        String filePath2 = "F:/abc.txt" ;

        File file = new File( filePath ) ;
        File file2 = new File( filePath2 ) ;
        copyFile( file , file2 );
    }

}
