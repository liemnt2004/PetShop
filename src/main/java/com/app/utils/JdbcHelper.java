package com.app.utils;

import java.sql.*;

public class JdbcHelper {
    private static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String SERVER_NAME = "localhost";
    private static String HOST = "1433";
    private static String DATABASE_NAME = "petshop";
    private static String USERNAME = "sa";
    private static String PASSWORD = "12345";

    private static String URL = "jdbc:sqlserver://" + SERVER_NAME + ":" + HOST + ";"
            + "databaseName=" + DATABASE_NAME
            + ";user=" + USERNAME
            + ";password=" + PASSWORD
            + ";encrypt=true;trustServerCertificate=true";

    public static Connection CONN = null;

    static {
        try {
            Class.forName(DRIVER);
            CONN = DriverManager.getConnection(URL);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement stmt;
        if (sql.trim().startsWith("{")) {
            stmt = conn.prepareCall(sql);
        } else {
            stmt = conn.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i + 1, args[i]);
        }
        return stmt;
    }

    public static ResultSet executeQuery(String sql, Object... args) throws SQLException {
        PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
        return stmt.executeQuery();
    }

    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            if (rs.next()) {
                return rs.getObject(1);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static int executeUpdate(String sql, Object... args) {
        try {
            PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
}