/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eaapp2;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            FileInputStream fis = new FileInputStream("proddata1000.bin");
            PrintWriter fout = new PrintWriter("oloughlin_wp.csv");
            PrintWriter errorOut = new PrintWriter("exceptions.rpt");
            DataInputStream dis = new DataInputStream(fis);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            errorOut.println("\nPRODDATA1000.BIN DATA FILE");
            errorOut.println("----------------------------");

            while (dis.available()!=0)
            {
                String location=dis.readUTF().trim();
                long date=dis.readLong();
                double oilProduction=dis.readDouble();
                double waterProduction=dis.readDouble();
                double gasProduction=dis.readDouble();

                Date d = new Date(date);

                //Write to file
                if (checkLocation(location))
                    fout.println(location + "," + sdf.format(d) + ","  +
                       oilProduction + "," + waterProduction + "," + gasProduction);
                else
                    errorOut.println(location + "," + date + ","  +
                       oilProduction + "," + waterProduction + "," + gasProduction);

                //Show on screen
               // System.out.println(location + "," + sdf.format(d) + "," +
               //        oilProduction + "," + waterProduction + "," + gasProduction);

            }

            errorOut.close();
            fout.close();
            dis.close();
            fis.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private static boolean checkLocation(String location)
    {
        boolean result=true;

        int pos1=0, pos2=0, pos3=0;

        pos1=location.indexOf("-");
        pos2=location.indexOf("-", pos1+1);
        pos3=location.lastIndexOf("-");

        //System.out.println("DEBUG+: " + pos1 + " " + pos2 + " " + pos3);

        String firstPart=location.substring(0,pos1);
        String secondPart=location.substring(pos1+1,pos2);
        String thirdPart=location.substring(pos2+1,pos3);
        String fourthPart=location.substring(pos3+1);

        System.out.println("DEBUG: " + location + ", " + firstPart + ", " + secondPart + ", " + thirdPart + ", " + fourthPart);

        //Check location letter
        Character letter = Character.toUpperCase(firstPart.charAt(0));
        if (!letter.equals('A') && !letter.equals('B') && !letter.equals('C') && !letter.equals('D'))
            result=false;

        //Check location value
        int locValue=Integer.parseInt(firstPart.substring(1));
        if (locValue<0 || locValue>16)
            result=false;

        //Check township
        int townShip=Integer.parseInt(secondPart);
        if (townShip<1 || townShip>126)
            result=false;

        //Check range
        int range=Integer.parseInt(thirdPart);
        if (range<1 || range>24)
            result=false;

        //Check meridian
        int meridian=Integer.parseInt(fourthPart.substring(1).trim());
        if (meridian<4 || meridian>6)
            result=false;

        if (result==false)
            System.out.println("--------------------------------------INVALID:" + result);
        //else
        //    System.out.println("VALID:" + result);
        return result;
    }

}
