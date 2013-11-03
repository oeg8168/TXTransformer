import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class TXTransformerMain {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);

		/*
		 * Ask user input file path and find file size.
		 */
		System.out.print("Input file: ");
		File inputFile = new File(scanner.next());

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
		int percentage = 0;
		do {
			/*
			 * Initialize variables to be use in this loop.
			 */
			modification = "";
			percentage = 0;

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
				System.out
						.println("Please input percentage of modification(1-100): ");
				try {
					percentage = Integer.valueOf(scanner.next());
				} catch (NumberFormatException e) {
					System.err
							.println("This is not a correct format of numbers!");
					continue;
				}
				if (percentage > 100 || percentage <= 0)
					System.err.println("Wrong range! Please input 1-100.");
			} while (percentage > 100 || percentage <= 0);

			/*
			 * Choose which modification function to be use.
			 */
			if (modification.equalsIgnoreCase("I"))
				txtInsert(inputFile, percentage);
			else if (modification.equalsIgnoreCase("D"))
				txtDelete(inputFile, percentage);
			else if (modification.equalsIgnoreCase("C"))
				txtChange(inputFile, percentage);
			else if (modification.equalsIgnoreCase("S"))
				txtSwap(inputFile, percentage);

			/*
			 * Ask user to continue or not. If input is not "y", all the other
			 * input will recognized as "n".
			 */
			System.out.print("Continue? (y/N): ");
			if (!scanner.next().equalsIgnoreCase("Y"))
				contiFlag = false;

		} while (contiFlag);

		scanner.close();
		return;

	} // end of main()

	/*
	 * Insert function. Return 0 if success.
	 */
	public static int txtInsert(File inputFile, int percentage)
			throws IOException {
		System.out.println("Insert!");

		// read file, modify, write file.

		return 0;
	} // end of txtInsert()

	/*
	 * Delete function. Return 0 if success.
	 */
	public static int txtDelete(File inputFile, int percentage)
			throws IOException {
		System.out.println("Delete!");

		return 0;
	} // end of txtDelete()

	/*
	 * Change function. Return 0 if success.
	 */
	public static int txtChange(File inputFile, int percentage)
			throws IOException {

		RandomAccessFile ras = new RandomAccessFile(inputFile, "rw");

		/*
		 * Go through file and set character to '#' by percentage.
		 */
		for (int i = 0; i < inputFile.length(); i++) {
			ras.seek(i);
			if(Math.random()*100 < percentage)
				ras.write("#".getBytes());
		}

		ras.close();
		return 0;
	} // end of txtChange()

	/*
	 * Swap function. Return 0 if success.
	 */
	public static int txtSwap(File inputFile, int percentage) {
		System.out.println("Swap!");
		return 0;
	} // end of txtSwap()

} // end of class TXTransformerMain
