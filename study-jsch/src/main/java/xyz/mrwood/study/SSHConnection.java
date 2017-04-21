/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study
 * 功能：
 * 时间：2016-12-04 20:42
 * 作者：Mr.Kiwi
 */
public class SSHConnection {

    public static Session ssh(String sshhost, int rport, int lport, String sshuser, String sshpass, String rhost) {

        System.out.println("           *   *   *   *   ");
        System.out.println("          *     * *     *   ");
        System.out.println("          *  ★   *  ★   *   ");
        System.out.println("           *      ★     *    ");
        System.out.println(">>>------I love you PP!  ---->");
        System.out.println("             *         *     ");
        System.out.println("               *  ★ *      ");
        System.out.println("                *   *    ");
        System.out.println("                 * *    ");
        System.out.println("                  *");

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(sshuser, sshhost, 22);
            session.setPassword(sshpass);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            int assinged_port = session.setPortForwardingL(lport, rhost, rport);

            System.out.println("连接状态：" + session.isConnected());
            System.out.println("服务器版本：" + session.getServerVersion());
            System.out.println("商品转发状态：localhost:" + assinged_port + " -> " + rhost + ":" + rport);
            System.out.println("我爱萍萍！");

            return session;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Map<String, Object>> select(String sql, String lhost, int lport, String dbname, String dbuser, String dbpass) {

        Connection conn;
        QueryRunner queryRunner = new QueryRunner();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://" + lhost + ":" + lport + "/" + dbname, dbuser, dbpass);


            List<Map<String, Object>> resultMap =
                queryRunner.query(conn, sql, new MapListHandler());
            System.out.println("查询结果：");
            System.out.println(resultMap);

            return resultMap;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

    }


}
