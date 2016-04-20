/**
 * 
 */
package fileHandling;

/**
 * @author Dave Watson
 *
 */

import java.io.*;

public class FileInput {
	private File			file;
	private FileReader		fr;
	private BufferedReader	in;
	
	/**
	 * Default constructor
	 */
	public FileInput() {
		
	}
	
	/**
	 * User defined constructor to open a file
	 * given the name and location of a file as
	 * string parameter
	 * 
	 * @param fileName name of the input file
	 */
	public FileInput(String fileName) {
		try {
			file = new File(fileName);
			fr = new FileReader(file);
			in = new BufferedReader(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
			System.exit(1);
		}
	}
	
	//Operational Methods
	/**
	 * Method to read a line form the text
	 * file as a string and return that string
	 * to the calling method.
	 * 
	 * @return line read from text file
	 */
	public String readLine() {
		String line = null;
		try {
			line = in.readLine();
		} catch (IOException e) {
			System.out.println(e);
		}
		return line;
	}
	
	/**
	 * Method to close the input data file
	 */
	public void closeInputFile() {
		try {
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
