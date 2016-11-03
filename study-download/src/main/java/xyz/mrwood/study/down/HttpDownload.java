/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.down;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study.down
 * 功能：
 * 时间：2016-10-25 下午5:22
 * 作者：Mr.Kiwi
 */
public class HttpDownload {


    public static final int cache = 10 * 1024;
    public static final boolean isWindows;
    public static final String splash;
    public static final String root;
    static {
        if (System.getProperty("os.name") != null && System.getProperty("os.name").toLowerCase().contains("windows")) {
            isWindows = true;
            splash = "\\";
            root="D:";
        } else {
            isWindows = false;
            splash = "/";
            root="/search";
        }
    }

    /**
     * 根据url下载文件，文件名从response header头中获取
     * @param url
     * @return
     */
    public static String download(String url) {
        return download(url, null);
    }

    /**
     * 根据url下载文件，保存到filepath中
     * @param url
     * @param filepath
     * @return
     */
    public static String download(String url, String filepath) {
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = client.execute(httpget);

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            if (filepath == null)
                filepath = getFilePath(response);
            File file = new File(filepath);
            file.getParentFile().mkdirs();
            FileOutputStream fileout = new FileOutputStream(file);
            /**
             * 根据实际运行效果 设置缓冲区大小
             */
            byte[] buffer=new byte[cache];
            int ch = 0;
            while ((ch = is.read(buffer)) != -1) {
                fileout.write(buffer,0,ch);
            }
            is.close();
            fileout.flush();
            fileout.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 获取response要下载的文件的默认路径
     * @param response
     * @return
     */
    public static String getFilePath(HttpResponse response) {
        String filepath = root + splash;
        String filename = getFileName(response);

        if (filename != null) {
            filepath += filename;
        } else {
            filepath += getRandomFileName();
        }
        return filepath;
    }
    /**
     * 获取response header中Content-Disposition中的filename值
     * @param response
     * @return
     */
    public static String getFileName(HttpResponse response) {
        Header contentHeader = response.getFirstHeader("Content-Disposition");
        String filename = null;
        if (contentHeader != null) {
            HeaderElement[] values = contentHeader.getElements();
            if (values.length == 1) {
                NameValuePair param = values[0].getParameterByName("filename");
                if (param != null) {
                    try {
                        //filename = new String(param.getValue().toString().getBytes(), "utf-8");
                        //filename=URLDecoder.decode(param.getValue(),"utf-8");
                        filename = param.getValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return filename;
    }
    /**
     * 获取随机文件名
     * @return
     */
    public static String getRandomFileName() {
        return String.valueOf(System.currentTimeMillis());
    }
    public static void outHeaders(HttpResponse response) {
        Header[] headers = response.getAllHeaders();
        for (int i = 0; i < headers.length; i++) {
            System.out.println(headers[i]);
        }
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        //      String url = "http://bbs.btwuji.com/job.php?action=download&pid=tpc&tid=320678&aid=216617";
        String url="http://odsih97in.bkt.clouddn.com//liquidator/finance/平安移动支付平台微信20161019对账文件_20161010101727224.csv?e=1477369326&token=UFqEC31mVF40cXOeUBWGMhCJhOK0rk9-su0nLe0k:jxBQINwJBOi7iPjqjA8DBSafdAc=";

//        url = url + URLEncoder.encode("//liquidator/finance/平安移动支付平台微信20161019对账文件_20161010101727224.csv?e=1477369326&token=UFqEC31mVF40cXOeUBWGMhCJhOK0rk9-su0nLe0k:jxBQINwJBOi7iPjqjA8DBSafdAc=", "utf-8");

       String u = "http://odsih97in.bkt.clouddn.com//liquidator/finance/%E5%B9%B3%E5%AE%89%E7%A7%BB%E5%8A%A8%E6%94%AF%E4%BB%98%E5%B9%B3%E5%8F%B0%E5%BE%AE%E4%BF%A120161019%E5%AF%B9%E8%B4%A6%E6%96%87%E4%BB%B6_20161010101727224.csv?e=1477369326&token=UFqEC31mVF40cXOeUBWGMhCJhOK0rk9-su0nLe0k:jxBQINwJBOi7iPjqjA8DBSafdAc=";

        url = URLEncoder.encode(u, "utf-8");
        //      String filepath = "D:\\test\\a.torrent";
        String filepath = "/Users/mac/平安移动支付平台微信20161019对账文件_20161010101727224.csv";
        HttpDownload.download(u, filepath);

    }



}
