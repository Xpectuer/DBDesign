package com.zjut.azhen.DBDesign.utils;

import java.io.File;
import java.io.FileInputStream;


public class MyFileUtil {
    /*
    获取本地文件返回
     */
    public  static  byte[] getFile(String path) throws Exception{

        File file =new File(path);
        FileInputStream inputStream=new FileInputStream(file);
        byte [] bytes=new byte[inputStream.available()];
        int result=inputStream.read(bytes,0,inputStream.available());
        System.out.println(result);
        if(result!=-1) {
            return bytes;
        }
        else{
            throw new Exception();
        }


    }
}
