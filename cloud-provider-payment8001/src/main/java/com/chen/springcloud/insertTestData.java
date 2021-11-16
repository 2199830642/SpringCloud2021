package com.chen.springcloud;

import java.sql.*;
import java.text.DateFormat;
import java.util.*;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

/**
 * @author Kaibo.Chen@hand-china.com
 * @ClassName: insertTestData
 * @date 2021/10/9 14:32
 */
public class insertTestData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        final String url = "jdbc:mysql://172.23.16.130:3306/tarzan_mes";
        final String name = "com.mysql.jdbc.Driver";
        final String user = "tarzan_stress";
        final String password = "tarzan_stress";
        Connection conn = null;
        Class.forName(name);// 指定连接类型
        conn = DriverManager.getConnection(url, user, password);// 获取连接
        if (conn != null) {
            System.out.println("获取连接成功");
            insert(conn);
        } else {
            System.out.println("获取连接失败");
        }

    }

    public static void insert(Connection conn) throws SQLException {
        // 关闭自动提交
        conn.setAutoCommit(false);
        // 开始时间
        Long begin = new Date().getTime();
        int k = 0;
        Long actualId = 200000L;
        String code = null;
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINA);
        // 类型组
        List<String> types = new ArrayList<>();
        Collections.addAll(types, "ASSEMBLING", "COPRODUCT", "PHANTOM", "REMOVE");
        int id = 0;
        // sql前缀
        String prefix = "INSERT INTO mt_eo_component_actual (EO_COMPONENT_ACTUAL_ID,EO_ID,MATERIAL_ID,REVISION_CODE,ASSEMBLE_QTY,SCRAPPED_QTY,BOM_ID,ACTUAL_FIRST_TIME,ACTUAL_LAST_TIME,CID) VALUES ";
        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement("");// 准备执行语句
            // 外层循环，总提交事务次数
            for (int i = 1; i <= 50; i++) {
                suffix = new StringBuffer();
                // 第j次提交步长
                for (int j = 1; j <= 100000; j++) {
                    actualId++;
                    if (k == 4) {
                        k = 0;
                    }
                    code = UUID.randomUUID().toString().replace("-", "") + new Date().getTime();
                    // 构建SQL后缀
                    suffix.append("(" + actualId + "," + 0 + "," + 0 + "," + "'" + code + "'" + "," + 0 + "," + 0 + ","
                                    + 0 + "," + "'" + df1.format(new Date()) + "'" + "," + "'" + df1.format(new Date())
                                    + "'" + "," + 0 + "),");
                    k++;
                }
                // 构建完整SQL
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                // 添加执行SQL
                pst.addBatch(sql);
                // 执行操作
                pst.executeBatch();
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                suffix = null;
            }
            // 头等连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = new Date().getTime();
        // 耗时
        System.out.println("500万条数据插入花费时间 : " + (end - begin) / 1000 + " s");
        System.out.println("插入完成");
    }
}
