package com.dudin.jdbc;

import java.sql.*;

public class JDBCDao {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/testapplication";

    static final String USER = "root";
    static final String PASS = "!@#$%^";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            String sql = "SELECT * FROM Answer";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int answerID = rs.getInt("answerID");
                String answer = rs.getString("answer");
                int questionID = rs.getInt("questionID");

                System.out.print("answerID: " + answerID + "\n");
                System.out.print("answer: " + answer + "\n");
                System.out.print("questionID: " + questionID + "\n");
                System.out.println();
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
