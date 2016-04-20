/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eaupload1;
import java.sql.*;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 *
 * @author Kerri
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {

	try
	{
	    File f = new File("oloughlin_wd.csv");
	    Scanner s = new Scanner(f);
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/oloughlin_mysql","root","password");

	    PreparedStatement p = conn.prepareStatement("insert into well_data set location=?, depth=?, perforationDepth=?, perforationZone=?, pumpStrokeLength=?, pumpStrokePerMin=?;");

	    while (s.hasNextLine())
	    {
		String line=s.nextLine();
		StringTokenizer st = new StringTokenizer(line,",");

		String location=st.nextToken();
		double depth=Double.parseDouble(st.nextToken());
		double perforationDepth=Double.parseDouble(st.nextToken());
		double perforationZone=Double.parseDouble(st.nextToken());
		double pumpStrokeLength=Double.parseDouble(st.nextToken());
		int pumpStokePerMin=Integer.parseInt(st.nextToken());

		System.out.println("DEBUG:" + location);
		
		p.setString(1, location);
		p.setDouble(2, depth);
		p.setDouble(3, perforationDepth);
		p.setDouble(4, perforationZone);
		p.setDouble(5, pumpStrokeLength);
		p.setInt(6, pumpStokePerMin);

		p.executeUpdate();

	    }

	    p.close();
	    conn.close();
	    s.close();


	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}


    }

}
