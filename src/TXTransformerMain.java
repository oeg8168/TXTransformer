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
			 * Choose which modification function to be use.
			 */
			if(modification.equalsIgnoreCase("I"))
				txtInsert(inputFile);
			else if (modification.equalsIgnoreCase("D"))
				txtDelete(inputFile);
			else if (modification.equalsIgnoreCase("C"))
				txtChange(inputFile);
			else if (modification.equalsIgnoreCase("S"))
				txtSwap(inputFile);
			
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
	 * Insert function. Return 0 if success
	 */
	public static int txtInsert(File inputFile)
	{
		System.out.println("Insert!");
		return 0;
	}	//end of txtInsert()
	
	/*
	 * Delete function. Return 0 if success
	 */
	public static int txtDelete(File inputFile)
	{
		System.out.println("Delete!");
		return 0;
	}	//end of txtDelete()
	
	/*
	 * Change function. Return 0 if success
	 */
	public static int txtChange(File inputFile)
	{
		System.out.println("Change!");
		return 0;
	}	//end of txtChange()
	
	/*
	 * Swap function. Return 0 if success
	 */
	public static int txtSwap(File inputFile)
	{
		System.out.println("Swap!");
		return 0;
	}	//end of txtSwap()
	
	
} // end of class TXTransformerMain
