/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.download;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.download
 * 功能：
 * 时间：2016-10-25 下午5:16
 * 作者：Mr.Kiwi
 */
public class TestDownload {

    @Test
    public void testUrl(){

    }


    @Test
    public void testDown() throws MalformedURLException {

        String urlPath = "http://odsih97in.bkt.clouddn.com/liquidator/finance/平安移动支付平台微信20161019对账文件_20161010101727224.csv?e=1477369326&token=UFqEC31mVF40cXOeUBWGMhCJhOK0rk9-su0nLe0k:jxBQINwJBOi7iPjqjA8DBSafdAc=";
        String filePath = "/home/mac/";
        URL url = new URL(urlPath);
        try {
            downloadFile(url,filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void downloadFile(URL theURL, String filePath) throws IOException {
        File dirFile = new File(filePath);
        if(!dirFile.exists()){//文件路径不存在时，自动创建目录
            dirFile.mkdir();
        }
        //从服务器上获取图片并保存
        URLConnection connection = theURL.openConnection();
        InputStream in = connection.getInputStream();
        FileOutputStream os = new FileOutputStream(filePath+"\\平安移动支付平台微信20161019对账文件_20161010101727224.csv");
        byte[] buffer = new byte[4 * 1024];
        int read;
        while ((read = in.read(buffer)) > 0) {
            os.write(buffer, 0, read);
        }
        os.close();
        in.close();
    }
/*    public static void main(String[] args) {
        String urlPath = "http://1.1.9.59:8089/image/123.png";
        String filePath = "d:\\excel";
        URL url = new URL(urlPath);
        try {
            downloadFile(url,filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}
