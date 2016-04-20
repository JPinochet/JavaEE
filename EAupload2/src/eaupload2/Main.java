/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eaupload2;
import java.sql.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

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
	    File f = new File("oloughlin_wp.csv");
	    Scanner s = new Scanner(f);
	    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy HH:mm");

	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/oloughlin_mysql","root","password");

	    PreparedStatement p = conn.prepareStatement("insert into well_production set location=?, date=?, oilProduction=?, waterProduction=?, gasProduction=?;");

	    while (s.hasNextLine())
	    {
		String line=s.nextLine();
		StringTokenizer st = new StringTokenizer(line, ",");

		String location=st.nextToken();
		String theDate=st.nextToken();
		//String d=sdf.format(new java.util.Date(theDate));
		System.out.println("DEBUG:" + location + ";; " + theDate);
		double oilProduction=Double.parseDouble(st.nextToken());
		double waterProduction=Double.parseDouble(st.nextToken());
		double gasProduction=Double.parseDouble(st.nextToken());

		System.out.println("DEBUG:" + location);

		p.setString(1, location);
		p.setString(2, theDate);
		p.setDouble(3, oilProduction);
		p.setDouble(4, waterProduction);
		p.setDouble(5, gasProduction);

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
