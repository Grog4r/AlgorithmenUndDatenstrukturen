package AuswahlProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		/*
		 * if (args.length > 0) { String algo = args[0];
		 * 
		 * // validate Parameters if (!algo.equals("-aus") && !algo.equals("-part")) {
		 * // System.out.println("args[0]: \"" + algo + "\""); throw new
		 * Exception("Der erste Parameter muss entweder -part für " +
		 * "den Partitionierungsalgorithmus sein, oder " +
		 * "-aus für den Auswaehlen Algorithmus."); } else if (algo.equals("-aus")) {
		 * 
		 * for (int i = 2; i < args.length; i++) { if (Integer.parseInt(args[i]) < 0 ||
		 * Integer.parseInt(args[i]) > 9) { throw new
		 * Exception("Die Werte des Arrays müssen zwischen 0 und 9 sein."); } } int k =
		 * 0; if (args.length >= 2) { k = Integer.parseInt(args[1]); } else { throw new
		 * Exception("k muss als zweites Argument angegeben werden!"); } if (k >
		 * args.length - 2 || k < 1) { throw new Exception(
		 * "k muss mindestens 1 sein und darf nicht größer sein als die länge des Arrays."
		 * ); }
		 * 
		 * int sizeArray = args.length - 2; int[] inputArray = new int[sizeArray]; for
		 * (int i = 2; i < args.length; i++) { inputArray[i - 2] =
		 * Integer.parseInt(args[i]); } printParameters(algo, inputArray, k);
		 * Auswaehlen.auswaehlen(inputArray, k, 0, inputArray.length - 1, true, true);
		 * 
		 * } else if (algo.equals("-part")) { // Array Werte einstellig for (int i = 1;
		 * i < args.length; i++) { if (Integer.parseInt(args[i]) < 0 ||
		 * Integer.parseInt(args[i]) > 9) { throw new
		 * Exception("Die Werte des Arrays müssen zwischen 0 und 9 sein."); } }
		 * 
		 * int sizeArray = args.length - 1; int[] inputArray = new int[sizeArray]; for
		 * (int i = 1; i < args.length; i++) { inputArray[i - 1] =
		 * Integer.parseInt(args[i]); } printParameters(algo, inputArray, 0);
		 * Partitionieren.part(inputArray, 0, inputArray.length - 1, true, true);
		 * System.out.println(Partitionieren.partitionierungSchritte); } } else {
		 */
		clearScreen();

		String algo = "";
		int k = 0;
		int[] inputArray = {};

		boolean hasAlgo = false;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (!hasAlgo) {
			System.out.println("Welcher Algorithmus soll ausgeführt werden?");
			System.out.println("-Partitionieren: -part");
			System.out.println("-auswaehlen: -aus");
			algo = reader.readLine().trim();
			if (algo.equals("-aus") || algo.equals("-part")) {
				hasAlgo = true;
			} else {
				clearScreen();
				System.err.println("Falsche Eingabe, nur -aus oder -part sind erlaubt.");
			}
		}

		clearScreen();

		if (algo.equals("-aus")) {
			boolean hasArray = false;

			while (!hasArray) {
				System.out.println("Algorithmus: auswaehlen\n");
				System.out.println("Was sollen die Array werte sein? (Durch Leerzeichen getrennt)");
				System.out.println("Wichtig: nur 0 bis 9 sind erlaubt.");
				String arrayString = reader.readLine();
				inputArray = stringToArray(arrayString);
				if (inputArray.length == 0) {
					clearScreen();
					System.err.println("Die Eingabe war nicht valide. Bitte erneut versuchen.");
				} else {
					hasArray = true;
				}
			}

			clearScreen();

			boolean hasK = false;
			while (!hasK) {
				System.out.println("Algorithmus: auswaehlen");
				System.out.println("Array a: " + Partitionieren.getArray(inputArray));
				System.out.println("Was soll k sein?");
				try {
					k = Integer.parseInt(reader.readLine());
					if (k < 1 || k > inputArray.length) {
						clearScreen();
						System.err.println(
								"k muss mindestens 1 sein und darf nicht größer sein als die länge des Arrays.");
					} else {
						hasK = true;
					}
				} catch (Exception e) {
					System.err.println("k muss eine positive ganze Zahl sein.");
					e.printStackTrace();
				}
			}

			clearScreen();

			System.out.println("Algorithmus: auswaehlen");
			System.out.println("Array a: " + Partitionieren.getArray(inputArray));
			System.out.println("k: " + k + "\n\n\n");
			int pivot = Auswaehlen.auswaehlen(inputArray, k, 0, inputArray.length - 1, true, true);
			System.out.println("\nErgebnis: das " + k + ". kleinste Element ist " + pivot + "\n");
			int leer = 2 + (k - 1) * 3;
			for (int i = 0; i < leer; i++) {
				System.out.print(" ");
			}
			System.out.println("|");
			for (int i = 0; i < leer; i++) {
				System.out.print(" ");
			}
			System.out.println("v");

			System.out.println(Partitionieren.getArray(Partitionieren.partitioniertesArray));

		} else if (algo.equals("-part")) {

			boolean hasArray = false;

			while (!hasArray) {
				System.out.println("Algorithmus: Partitionieren\n");
				System.out.println("Was sollen die Arraywerte sein? (Durch Leerzeichen getrennt)");
				System.out.println("Wichtig: nur 0 bis 9 sind erlaubt.");
				String arrayString = reader.readLine();
				inputArray = stringToArray(arrayString);
				if (inputArray.length == 0) {
					clearScreen();
					System.err.println("Die Eingabe war nicht valide. Bitte erneut versuchen.");
				} else {
					hasArray = true;
				}
			}

			clearScreen();

			System.out.println("Algorithmus: Partitionieren");
			System.out.print("Array a: " + Partitionieren.getArray(inputArray) + "\n\n");

			Partitionieren.part(inputArray, 0, inputArray.length - 1, true, true);
			System.out.println(Partitionieren.partitionierungSchritte);

		}

		// System.err.println("Ausführung ohne Parameter nicht möglich.");
	}
	// }

	public static void printParameters(String algo, int[] a, int k) throws Exception {

		if (algo.equals("-part")) {
			if (a.length < 1) {
				throw new Exception("Das Array darf bei der Partitionierung nicht leer sein.");
			}
			System.out.println("Der gewählte Algorithmus ist Partitionieren.\n\n Das eingelesene Array ist:");
			System.out.println(Partitionieren.getArray(a));

		} else if (algo.equals("-aus")) {
			if (a.length < 1) {
				throw new Exception("Das Array darf beim Auswaehlen nicht leer sein.");
			}
			System.out.print("Der gewählte Algorithmus ist Auswaehlen.\n\n k ist: ");
			System.out.println(k);
			System.out.println("Das eingelesene Array ist:");
			System.out.println(Partitionieren.getArray(a));
		}
	}

	public static void clearScreen() {
		// Clears Screen in java
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public static int[] stringToArray(String arrayString) {
		int stringLength = arrayString.length();
		int arrayLength = (int) (stringLength / 2) + 1;
		int[] output = new int[arrayLength];
		for (int i = 0; i < stringLength; i++) {
			if (i % 2 == 0) {
				try {
					output[i / 2] = Integer.parseInt(String.valueOf(arrayString.charAt(i)));
				} catch (Exception e) {
					return new int[0];
				}
			} else {
				if (arrayString.charAt(i) != ' ') {
					return new int[0];
				}
			}
		}
		return output;
	}

}
