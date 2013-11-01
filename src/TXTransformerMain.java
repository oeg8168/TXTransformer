import java.io.File;
import java.util.Scanner;

public class TXTransformerMain {

	public static void main(String[] args) {

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
		do {
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
			 * Ask user to continue or not. If input is not "y", all the other
			 * input will recognized as "n".
			 */
			System.out.print("Continue? (y/N): ");
			if (!scanner.next().equalsIgnoreCase("Y"))
				contiFlag = false;

		} while (contiFlag);

		scanner.close();
		return;
		
	} // end of main
	
	// insert
	// delete
	// change
	// swap
	
	
} // end of class TXTransformerMain
