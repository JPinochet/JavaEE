/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pinochet_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author Administrator
 */
@Stateless
public class DBManager implements DBManagerLocal {

    public ArrayList<WellData> getWellData() {
        ArrayList<WellData> wellDataInfo = new ArrayList<WellData>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/pinochet_mysql", "root", "password");

            Statement s = conn.createStatement();
            s.executeQuery("SELECT * FROM well_data;");

            ResultSet rs = s.getResultSet();

            while (rs.next()) {
                WellData wellData = new WellData(rs.getInt("well_id"), rs.getString("location"),
                        rs.getDouble("depth"), rs.getDouble("perforationDepth"), rs.getDouble("perforationZone"),
                        rs.getDouble("pumpStrokeLength"), rs.getInt("pumpStrokesPerMinute"));

                wellDataInfo.add(wellData);
            }

            rs.close();
            s.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return wellDataInfo;
    }

    public ArrayList<WellProduction> getWellProduction() {
        ArrayList<WellProduction> wellProdInfo = new ArrayList<WellProduction>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/pinochet_mysql", "root", "password");

            Statement s = conn.createStatement();
            s.executeQuery("SELECT * FROM well_production;");

            ResultSet rs = s.getResultSet();

            while (rs.next()) {
                WellProduction wellProduction = new WellProduction(rs.getInt("well_id"), rs.getString("location"),
                        rs.getDate("date"), rs.getDouble("oilProduction"), rs.getDouble("waterProduction"),
                        rs.getDouble("gasProduction"));

                wellProdInfo.add(wellProduction);
            }

            rs.close();
            s.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return wellProdInfo;
    }
}
