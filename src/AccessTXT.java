import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Access TXT file, include read and write
 * 
 * @author OEG
 */
public class AccessTXT {

	/**
	 * Read text from input file.
	 * 
	 * @param inputFile
	 * @return String read from TXT file
	 */
	public static String getText(File inputFile) {
		StringBuffer strBuf = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(inputFile.getPath())));
			while (br.ready()) {
				strBuf.append(br.readLine());
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return strBuf.toString();
	} // end of getText()

	/**
	 * Write text to file
	 * 
	 * @param inputFile
	 * @param text
	 *            text to be written to file
	 * @return 1 if success, -1 if error occurs
	 */
	public static int writeText(String path, String text) {
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(path));
			br.write(text);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

} // end of AccessTXT