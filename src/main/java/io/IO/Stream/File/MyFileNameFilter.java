package io.IO.Stream.File;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by xlt on 20180316.
 */

public class MyFileNameFilter implements FilenameFilter {
    //type为需要过滤的条件，比如如果type=".jpg"，则只能返回后缀为jpg的文件
    private String type;
    MyFileNameFilter(String type){
        this.type = type ;
    }

    @Override
    public boolean accept(File dir, String name) {
        //dir表示文件的当前目录，name表示文件名；
        return name.endsWith( type ) ;
    }

}
