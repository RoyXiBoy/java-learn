package io.IO.Stream.File;

import java.io.*;

/**
 * Created by xlt on 20180316.
 */
public class File1 {

    public String readTxt(String fileName){

        String result = "" ;

        //实例化一个输入流的对象
        try (FileInputStream fis = new FileInputStream(fileName)){

            //估计输入流字节大小
            int size = fis.available();

            //根据输入流创建字节数组
            byte[] array = new byte[size];

            //数据读到数组中
            fis.read(array);

            //得到string
            result = new String(array);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void writeTxt(String fileName, String content){

        try (FileOutputStream fos = new FileOutputStream(fileName)){

            byte[] array = content.getBytes();

            fos.write(array);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {


    }
}