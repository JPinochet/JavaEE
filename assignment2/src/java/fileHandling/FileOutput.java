/**
 * 
 */
package fileHandling;

/**
 * @author Dave Watson
 *
 */
import java.io.*;

/**
 * @author 502481
 *
 */
public class FileOutput {
	//Attributes
	private File			file;
	private FileWriter		fw;
	private PrintWriter		out;
	
	/**
	 * Default Constructor
	 */
	public FileOutput() {
	}

	/**
	 * User-defined constructor to open a file for writing
	 * @param fileName the file to open
	 */
	public FileOutput(String fileName) {
		try {
			file = new File(fileName);
			fw = new FileWriter(file);
			out = new PrintWriter(fw);
		} catch (IOException e) {
			System.out.println("Could not create output file " + fileName);
			System.exit(1);
		}		
	}

	/**
	 * User-defined constructor to open a file for writing
	 * @param fileName filename to open
	 * @param append true to append to file, false to overwrite
	 */
	public FileOutput(String fileName, boolean append) {
		try {
			file = new File(fileName);
			fw = new FileWriter(file, append);
			out = new PrintWriter(fw);
		} catch (IOException e) {
			System.out.println("Could not create output file " + fileName);
			System.exit(1);
		}		
	}
	
	public void print(String a) {
		out.print(a);
	}
	
	public void print(int a) {
		out.print(a);
	}
	
	public void print(double a) {
		out.print(a);
	}
	
	public void print(char a) {
		out.print(a);
	}
	
	public void print(long a) {
		out.print(a);
	}
	
	public void print(Object a) {
		out.print(a);
	}
	
	public void println(String a) {
		out.println(a);
	}
	
	public void println(int a) {
		out.println(a);
	}
	
	public void println(double a) {
		out.println(a);
	}
	
	public void println(char a) {
		out.println(a);
	}
	
	public void println(long a) {
		out.println(a);
	}
	
	public void println(Object a) {
		out.println(a);
	}
	
	public void close() {
		out.close();
	}
}
