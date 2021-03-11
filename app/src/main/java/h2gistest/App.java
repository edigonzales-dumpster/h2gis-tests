
package h2gistest;

import java.io.File;
import java.sql.*;

public class App {

    public static void main(String[] args) {

        String h2FileName = new File("src/data/stromversorgungssicherheit").getAbsolutePath();
        String url = "jdbc:h2:" + h2FileName;
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {

            stmt.execute("CALL SHPREAD('/Users/stefan/sources/h2gis-tests/app/src/data/netz7.shp', 'netz7')");



//            while (rs.next()) {
//                System.out.println(rs.getString(1));
//                System.out.println(rs.getString(2));
//                System.out.println(rs.getInt(3));
//            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("Hallo Welt.");
    }
}
