/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package welldatabinarytocvs;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrator
 */
public class ConvertBinaryToCVSandSaveDB {

    //Attributes
    private FileInputStream fis = null;
    private PrintWriter pw = null;

    public ConvertBinaryToCVSandSaveDB() {
    }

    public void convertWellData(String filename) throws IOException {
        try {
            fis = new FileInputStream(filename);
            DataInputStream dis = new DataInputStream(fis);

            pw = new PrintWriter("res/pinochet_wd.cvs");
            PrintWriter errors = new PrintWriter("res/pinochet_wd_errors.txt");

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WellDB");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            while (dis.available() != 0) {
                String location = dis.readUTF().trim();
                double depth = dis.readDouble();
                double perforationDepth = dis.readDouble();
                double perforationZone = dis.readDouble();
                double pumpStrokeLength = dis.readDouble();
                int pumpStrokePerMin = dis.readInt();

                if (validate(location)) {
                    pw.println(location + "," + depth + "," + perforationDepth + ","
                            + perforationZone + "," + pumpStrokeLength + "," + pumpStrokePerMin);



                    WellData wellData = new WellData(null, location, depth, perforationDepth, perforationZone, pumpStrokeLength, pumpStrokePerMin);

                    em.persist(wellData);


                } else {
                    errors.println(location + "," + depth + "," + perforationDepth + ","
                            + perforationZone + "," + pumpStrokeLength + "," + pumpStrokePerMin);
                }

                System.out.println(location + "," + depth + "," + perforationDepth + ","
                        + perforationZone + "," + pumpStrokeLength + "," + pumpStrokePerMin);
            }

            em.getTransaction().commit();

            em.close();
            emf.close();
            fis.close();
            dis.close();
            pw.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void convertWellProduction(String filename) {
        try {
            fis = new FileInputStream(filename);
            DataInputStream dis = new DataInputStream(fis);

            pw = new PrintWriter("res/pinochet_wp.cvs");
            PrintWriter errors = new PrintWriter("res/pinochet_wp_errors.txt");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WellDB");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            while (dis.available() != 0) {
                String location = dis.readUTF().trim();
                long date = dis.readLong();
                double oilProduction = dis.readDouble();
                double waterProduction = dis.readDouble();
                double gasProduction = dis.readDouble();
                Date saveThisDate = new Date(date);


                if (validate(location)) {
                    pw.println(location + "," + sdf.format(saveThisDate) + ","
                            + oilProduction + "," + waterProduction + "," + gasProduction);

                    WellProduction wellProduction = new WellProduction(null, location, saveThisDate, oilProduction, waterProduction, gasProduction);

                    em.persist(wellProduction);

                } else {
                    errors.println(location + "," + saveThisDate + ","
                            + oilProduction + "," + waterProduction + "," + gasProduction);
                }

                System.out.println(location + "," + sdf.format(saveThisDate) + ","
                        + oilProduction + "," + waterProduction + "," + gasProduction);
            }

            em.getTransaction().commit();
            em.close();
            emf.close();
            fis.close();
            dis.close();
            pw.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean validate(String location) {
        boolean result = true;

        int break1 = 0, break2 = 0, break3 = 0;

        break1 = location.indexOf("-");
        break2 = location.indexOf("-", break1 + 1);
        break3 = location.lastIndexOf("-");

        String section = location.substring(0, break1);
        String township = location.substring(break1 + 1, break2);
        String range = location.substring(break2 + 1, break3);
        String meridian = location.substring(break3 + 1);
        Character letter = Character.toUpperCase(section.charAt(0));
        if (!letter.equals('A') && !letter.equals('B') && !letter.equals('C') && !letter.equals('D')) {
            result = false;
        }
        int theLocation = Integer.parseInt(section.substring(1));
        if (theLocation < 0 || theLocation > 16) {
            result = false;
        }
        int townShip = Integer.parseInt(township);
        if (townShip < 1 || townShip > 126) {
            result = false;
        }
        int rangeCheck = Integer.parseInt(range);
        if (rangeCheck < 1 || rangeCheck > 24) {
            result = false;
        }
        int meridianCheck = Integer.parseInt(meridian.substring(1).trim());
        if (meridianCheck < 4 || meridianCheck > 6) {
            result = false;
        }
        return result;
    }
}
