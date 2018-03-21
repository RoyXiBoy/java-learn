package io.IO.Stream.File;

/**
 * Created by xlt on 20180316.
 */

import java.io.File;
import java.io.FileFilter;

/**
 *
 public File(String pathname)  //文件的绝对路径
 public File(URI uri)  //文件的URI地址

 public File(String parent, String child)  //指定父文件绝对路径、子文件绝对路径
 public File(File parent, String child)  //指定父文件、子文件相对路径
 */

public class FIle2 {

    public static void main(String[] args) {

        File file = new File("C://Test/1.txt");

        FileFilter fileFilter = new MyFileFilter();

        file.listFiles(fileFilter);

    }
}
