package com.twx;

import java.io.File;

/**
 * Created by twx on 2017/6/17.
 */
public class Test {
    public static void main(String[] args) {
        File file = new File("D:\\zipfile\\FGH");
        String dir=null;
        dir = findDir(file,"b");
        if (dir!=null)
            System.out.println(dir.substring(0,dir.lastIndexOf("\\")));
    }

    public static String findDir(File file,String key) {
        if (file.isDirectory()) {
            String dirName = file.getName();
            if (dirName.equals(key)) {
                return file.getAbsolutePath();
            } else {
                File[] fileLists = file.listFiles();
                for (File f : fileLists) {
                    return findDir(f, key);
                }
            }
        } else {

        }
        return file.getAbsolutePath();
    }
}
