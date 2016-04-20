/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package welldatabinarytocvs;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConvertBinaryToCVSandSaveDB convert = new ConvertBinaryToCVSandSaveDB();
        try {
            convert.convertWellData("res/wells1000.bin");
            convert.convertWellProduction("res/proddata1000.bin");
            System.out.println("Done");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
