/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import org.junit.Test;

import java.io.*;

/**
 * 项目：study
 * 包名：xyz.mrwood.study
 * 功能：
 * 时间：2016-06-02 22:18
 * 作者：Mr.Kiwi
 */
public class TestUtil {

    @Test
    public void test(){

        String sql = "(\n"
            + "  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据修改时间',\n"
            + "  `gmt_create` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '数据创建时间',\n"
            + "  `id` varchar(32) NOT NULL,\n"
            + "  `uid` varchar(64) NOT NULL COMMENT '对应carlife_parking_user的主键uid',\n"
            + "  `car_number` varchar(64) NOT NULL COMMENT '车牌号码',\n"
            + "  `is_delete` int(4) unsigned NOT NULL DEFAULT '0' COMMENT '1表示已删除，0表示未删除',\n"
            + "  PRIMARY KEY (`id`)\n" + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关联用户添加的车牌表'";
        StringBuffer sb  = new StringBuffer();

        for (int i = 0; i < 10; i++){

        String title = "CREATE TABLE `carlife_user_number";
            title = title + "_0" + i + "`";
            sb.append(title + sql + ";" + "\n\r");
        }

        string2File(sb.toString(), "C:\\Users\\Administrator\\Desktop\\sql脚本\\sql.sql");

    }

    /**
     * 将字符串写入指定文件(当指定的父路径中文件夹不存在时，会最大限度去创建，以保证保存成功！)
     *
     * @param res            原字符串
     * @param filePath 文件路径
     * @return 成功标记
     */
    public static boolean string2File(String res, String filePath) {
        boolean flag = true;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            File distFile = new File(filePath);
            if (!distFile.getParentFile().exists()) distFile.getParentFile().mkdirs();
            bufferedReader = new BufferedReader(new StringReader(res));
            bufferedWriter = new BufferedWriter(new FileWriter(distFile));
            char buf[] = new char[1024];         //字符缓冲区
            int len;
            while ((len = bufferedReader.read(buf)) != -1) {
                bufferedWriter.write(buf, 0, len);
            }
            bufferedWriter.flush();
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
            return flag;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

}
