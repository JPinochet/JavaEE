/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package getfromweb;
import java.io.*;
import java.net.URL;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final char CR = 13;
        final char LF = 10;

        String str = new String();

        try
        {
            URL myURL = new URL ("http://www.mysait.ca");
            BufferedReader b = new BufferedReader(new InputStreamReader(myURL.openStream()));
            String tempLine;

            while((tempLine = b.readLine()) != null)
            {
                str = str + tempLine + CR + LF;
            }

            b.close();
            System.out.println(str);
        }
        catch(java.net.MalformedURLException e)
        {
            System.out.println(e.getStackTrace());
        }
        catch (IOException e)
        {
            System.out.println(e.getStackTrace());
        }
    }

}
