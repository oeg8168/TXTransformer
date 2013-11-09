import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TXTransformerMain {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);

		/*
		 * Ask user input file path and find file size.
		 */
		System.out.print("Input file: ");
		File inputFile = new File(scanner.next());
		String fileContent = AccessTXT.getText(inputFile);
		String outputPath = new String();

		if (inputFile.exists()) {
			System.out.print("Size of " + inputFile.getPath() + " : ");
			System.out.println(inputFile.length() + " bytes");
		} else {
			System.err.println("File not exist!");
			scanner.close();
			return;
		}

		/*
		 * A do-while loop to let user modify many times.
		 */
		boolean contiFlag = true;
		String modification = "";
		int rate = 0;
		do {
			/*
			 * Initialize variables to be use in this loop.
			 */
			modification = "";
			rate = 0;

			/*
			 * Ask user which modification should be done.
			 */
			do {
				System.out.println("Please choose modify type: ");
				System.out.println("[(I)nsert, (D)elete, (C)hange, (S)wap]");
				modification = scanner.next();
			} while (!modification.equalsIgnoreCase("I")
					&& !modification.equalsIgnoreCase("D")
					&& !modification.equalsIgnoreCase("C")
					&& !modification.equalsIgnoreCase("S"));

			/*
			 * Ask user the percentage of modification.
			 */
			do {
				if (modification.equalsIgnoreCase("S")) {
					System.out.println("Please input swap times(1-100): ");
				} else {
					System.out
							.println("Please input percentage of modification(1-100): ");
				}

				try {
					rate = Integer.valueOf(scanner.next());
				} catch (NumberFormatException e) {
					System.err
							.println("This is not a correct format of numbers!");
					continue;
				}
				if (rate > 100 || rate <= 0)
					System.err.println("Wrong range! Please input 1-100.");
			} while (rate > 100 || rate <= 0);

			/*
			 * Choose which modification function to be use.
			 */
			if (modification.equalsIgnoreCase("I"))
				fileContent = txtInsert(inputFile, rate);
			else if (modification.equalsIgnoreCase("D"))
				fileContent = txtDelete(inputFile, rate);
			else if (modification.equalsIgnoreCase("C"))
				fileContent = txtChange(inputFile, rate);
			else if (modification.equalsIgnoreCase("S"))
				fileContent = txtSwap(inputFile, rate);

			/*
			 * Ask user to continue or not. If input is not "y", all the other
			 * input will recognized as "n".
			 */
			System.out.print("Continue? (y/N): ");
			if (!scanner.next().equalsIgnoreCase("Y"))
				contiFlag = false;

			outputPath += (modification + rate);

		} while (contiFlag);

		outputPath += ("-" + inputFile.getPath());

		AccessTXT.writeText(outputPath, fileContent);

		scanner.close();
		return;

	} // end of main()

	/**
	 * Insert function.
	 * 
	 * @return modified String
	 */
	public static String txtInsert(File inputFile, int percentage)
			throws IOException {
		StringBuffer strBuf = new StringBuffer(AccessTXT.getText(inputFile));
		int insertOffset = 0;

		for (int i = 0; i < inputFile.length() * percentage * 0.01; i++) {
			insertOffset = (int) ((inputFile.length() + i) * Math.random());
			strBuf.insert(insertOffset, "#");
		}

		return strBuf.toString();
	} // end of txtInsert()

	/**
	 * Delete function.
	 * 
	 * @return modified String
	 */
	public static String txtDelete(File inputFile, int percentage)
			throws IOException {
		StringBuffer strBuf = new StringBuffer(AccessTXT.getText(inputFile));
		int insertOffset = 0;

		for (int i = 0; i < inputFile.length() * percentage * 0.01; i++) {
			insertOffset = (int) ((inputFile.length() - i) * Math.random());
			strBuf.deleteCharAt(insertOffset);
		}

		return strBuf.toString();
	} // end of txtDelete()

	/**
	 * Change function.
	 * 
	 * @return modified String
	 */
	public static String txtChange(File inputFile, int percentage)
			throws IOException {

		char[] text = AccessTXT.getText(inputFile).toCharArray();

		/*
		 * Go through file and set character to '#' by percentage.
		 */
		for (int i = 0; i < inputFile.length(); i++) {
			if (Math.random() * 100 < percentage)
				text[i] = '#';
		}

		return text.toString();
	} // end of txtChange()

	/**
	 * Swap function.
	 * 
	 * @return modified String
	 */
	public static String txtSwap(File inputFile, int times) {
		StringBuffer strBuf = new StringBuffer(AccessTXT.getText(inputFile));

		int front = 0;
		int end = 0;
		int temp = 0;
		String tempString = null;
		int insertOffset = 0;

		for (int i = 0; i < times; i++) {
			front = (int) (Math.random() * inputFile.length());
			end = (int) (Math.random() * inputFile.length());

			// swap if front > end
			if (front > end) {
				temp = front;
				front = end;
				end = temp;
			}

			tempString = strBuf.substring(front, end);

			strBuf.delete(front, end);

			insertOffset = (int) (Math.random() * strBuf.length());

			strBuf.insert(insertOffset, tempString);
		}

		return strBuf.toString();
	} // end of txtSwap()

} // end of class TXTransformerMain
