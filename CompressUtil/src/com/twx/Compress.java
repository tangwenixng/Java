package com.twx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by twx on 2017/6/17.
 */
public class Compress {
    public static void main(String[] args) throws IOException {
        File[] files = new File[]{new File("d:/testzip"),new File("d:/helloworld.txt")};
        File zip = new File("d:/压缩.zip");
        zipFiles(zip,"abc",files);
    }

    public static void zipFiles(File zip,String path,File... srcFiles) throws IOException{
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zip));
        zipFiles0(out,path,srcFiles);
        out.close();
        System.out.println("*****************压缩完毕*******************");
    }

    public static void zipFiles0(ZipOutputStream out, String path, File... srcFiles){
        path = path.replaceAll("\\*", "/");
        if(!path.endsWith("/")){
            path+="/";
        }
        byte[] buf = new byte[1024];
        try {
            for(int i=0;i<srcFiles.length;i++){
                if(srcFiles[i].isDirectory()){
                    File[] files = srcFiles[i].listFiles();
                    String srcPath = srcFiles[i].getName();
                    srcPath = srcPath.replaceAll("\\*", "/");
                    if(!srcPath.endsWith("/")){
                        srcPath+="/";
                    }
                    out.putNextEntry(new ZipEntry(path+srcPath));
                    zipFiles0(out,path+srcPath,files);
                } else{
                    FileInputStream in = new FileInputStream(srcFiles[i]);
                    System.out.println(path + srcFiles[i].getName());
                    out.putNextEntry(new ZipEntry(path + srcFiles[i].getName()));
                    int len;
                    while((len=in.read(buf))>0){
                        out.write(buf,0,len);
                    }
                    out.closeEntry();
                    in.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
