
package h2gistest;

import java.io.File;
import java.sql.*;

public class App {

    public static void main(String[] args) {

        String h2FileName = new File("/Users/stefan/sources/awa_stromversorgungssicherheit/foobar_tmp").getAbsolutePath();
        String url = "jdbc:h2:" + h2FileName;
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE ALIAS IF NOT EXISTS H2GIS_SPATIAL FOR \"org.h2gis.functions.factory.H2GISFunctions.load\"");
            stmt.execute("CREATE ALIAS IF NOT EXISTS H2GIS_UNLOAD FOR \"org.h2gis.functions.factory.H2GISFunctions.unRegisterH2GISFunctions\"");
            stmt.execute("CALL H2GIS_SPATIAL();");
            stmt.execute("SELECT 1");
            stmt.execute("CALL SHPRead('/Users/stefan/sources/h2gis-tests/app/src/data/netz7.shp', 'netz7')");
            stmt.execute("CALL H2GIS_SPATIAL();");

            //stmt.execute("CALL FILE_TABLE('/Users/stefan/sources/h2gis-tests/app/src/data/netz7.shp', 'netz7')");
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
