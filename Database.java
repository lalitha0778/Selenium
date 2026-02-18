package testing;

import java.sql.*;

public class Database {

    public static Object[][] getLoginData() throws Exception {

        String url = "jdbc:mysql://localhost:3306/assignment_maven";
        String user = "root";
        String password = "yroot@123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT username, password FROM users WHERE status='ACTIVE'");

        rs.last();
        int rowCount = rs.getRow();
        rs.beforeFirst();

        Object[][] data = new Object[rowCount][2];

        int i = 0;
        while (rs.next()) {
            data[i][0] = rs.getString("username");
            data[i][1] = rs.getString("password");
            i++;
        }

        conn.close();
        return data;
    }
}
