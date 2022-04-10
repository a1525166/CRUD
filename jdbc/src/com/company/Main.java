package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Main {
            public static final String URL = "jdbc:mysql://localhost:3306/accounts";
            public static final String USER = "root";
            public static final String PASSWORD = "a1525166";

            public static void main(String[] args) throws Exception {

                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM branch");
                while(rs.next()){
                    System.out.println(rs.getString("branch_name"));
                }
            }
    }

