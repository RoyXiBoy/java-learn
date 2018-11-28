package io.io.Stream.File;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by xlt on 20180316.
 */
public class MyFileFilter implements FileFilter{

    @Override
    public boolean accept(File pathname) {
        if( pathname.isDirectory() ){
            return true ;
        }
        return false;
    }
}
