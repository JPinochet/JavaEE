/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eaapp1;
import java.io.*;

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
            FileInputStream fis = new FileInputStream("wells1000.bin");
            PrintWriter fout = new PrintWriter("oloughlin_wd.csv");
            PrintWriter errorOut = new PrintWriter("exceptions.rpt");
            DataInputStream dis = new DataInputStream(fis);

            errorOut.println("\nWELLS1000.BIN DATA FILE");
            errorOut.println("-----------------------");

            while (dis.available()!=0)
            {
                String location=dis.readUTF().trim();
                double depth=dis.readDouble();
                double perforationDepth=dis.readDouble();
                double perforationZone=dis.readDouble();
                double pumpStrokeLength=dis.readDouble();
                int pumpStrokePerMin=dis.readInt();

                if (checkLocation(location))
                    fout.println(location + "," + depth + "," + perforationDepth + "," +
                       perforationZone + "," + pumpStrokeLength + "," + pumpStrokePerMin);
                else
                    errorOut.println(location + "," + depth + "," + perforationDepth + "," +
                       perforationZone + "," + pumpStrokeLength + "," + pumpStrokePerMin);

                System.out.println(location + "," + depth + "," + perforationDepth + "," +
                        perforationZone + "," + pumpStrokeLength + "," + pumpStrokePerMin);
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
        boolean result = true;

        int break1 = 0, break2 = 0, break3 = 0;

        break1 = location.indexOf("-");
        break2 = location.indexOf("-", break1+1);
        break3 = location.lastIndexOf("-");

        String section = location.substring(0,break1);
        String township = location.substring(break1+1,break2);
        String range = location.substring(break2+1,break3);
        String meridian = location.substring(break3+1);
        Character letter = Character.toUpperCase(section.charAt(0));
        if (!letter.equals('A') && !letter.equals('B') && !letter.equals('C') && !letter.equals('D'))
            result = false;
        int theLocation = Integer.parseInt(section.substring(1));
        if (theLocation < 0 || theLocation > 16)
            result = false;
        int townShip = Integer.parseInt(township);
        if (townShip < 1 || townShip > 126)
            result = false;
        int rangeCheck = Integer.parseInt(range);
        if (rangeCheck < 1 || rangeCheck > 24)
            result = false;
        int meridianCheck = Integer.parseInt(meridian.substring(1).trim());
        if (meridianCheck < 4 || meridianCheck > 6)
            result = false;
        return result;
    }

}
