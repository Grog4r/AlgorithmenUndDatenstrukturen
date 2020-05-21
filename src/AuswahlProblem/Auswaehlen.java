package AuswahlProblem;

public class Auswaehlen {

	public static String aufrufbaum = "\nAufrufbaum von auswaehlen:\n\n";

	public static int auswaehlen(int[] array, int k, int links, int rechts, boolean printPartitionierung,
			boolean printAufrufbaum) {
		if (printAufrufbaum) {
			aufrufbaum += String.format("auswaehlen(a, %d, %d, %d)\n", k, links, rechts);
		}
		int[] returnPartitionierung = Partitionieren.part(array, links, rechts, printPartitionierung, printAufrufbaum);
		int pivotLinks = returnPartitionierung[0];
		int pivotRechts = returnPartitionierung[1];
		int pivot = returnPartitionierung[2];

		if (pivotLinks <= k - 1 && k - 1 <= pivotRechts) {
			aufrufbaum += "L--> return pivot=" + pivot + "\n\n\n";
			System.out.println("Gesucht: das k = " + k + ". kleinste Element.");
			// printet den Aufrufbaum und die Partitionierung, falls erwünscht
			if (printAufrufbaum) {
				System.out.print(aufrufbaum);
			}
			if (printPartitionierung) {
				System.out.print(Partitionieren.partitionierungSchritte);
			}
			return pivot;
		} else if (k - 1 < pivotLinks) {
			return auswaehlen(array, k, links, pivotLinks - 1, printPartitionierung, printAufrufbaum);
		} else {
			return auswaehlen(array, k, pivotRechts + 1, rechts, printPartitionierung, printAufrufbaum);
		}
	}

}