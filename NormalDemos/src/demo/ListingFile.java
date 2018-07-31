/**
 * 
 */
package demo;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tanvigarg
 *
 */
public class ListingFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File folder = new File("/home/sachin/");
		File[] listOfFiles = folder.listFiles();
		List<String> files = new LinkedList<>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());

				files.add(listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
		System.out.println("files " + files);
	}

}
