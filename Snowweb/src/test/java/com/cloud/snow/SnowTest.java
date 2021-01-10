package com.cloud.snow;



import org.testng.annotations.Test;

import java.sql.*;

public class SnowTest {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://212.64.19.109:3306/bookstack";
    static final String USER = "root";
    static final String PASS = "c2hhb2Zlbmd4aWE=";
    @Test
    public void test(){
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name, html FROM pages limit 2";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
//                 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String text = rs.getString("html");

                // 输出数据
//                System.out.print("ID: " + id);
//                System.out.print(", 站点名称: " + name);
                System.out.print(", 站点 URL: " + text);
                System.out.print("\n");


            }
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test01(){
        System.out.println("dafds");
    }
}
