package AuswahlProblem;

public class Partitionieren {

	public static String partitionierungSchritte = "\nSchritte der Partitionierungen: \n\n";
	public static int[] partitioniertesArray = {};

	public static int[] part(int[] array, int links, int rechts, boolean printPartitionierung,
			boolean printAufrufbaum) {

		if (printAufrufbaum) {
			Auswaehlen.aufrufbaum += String.format("|\tL> Partitionieren(a, %d, %d)\n", links, rechts);
		}
		if (printPartitionierung) {
			partitionierungSchritte += String.format("Aufruf von Partitionieren(a, %d, %d):\n\n", links, rechts);
		}
		// pl <- a[l]
		int pivotWert = array[links];
		// pl <- pr <- l
		int pivotLinks = links;
		int pivotRechts = links;
		// for i <- l+1 to r
		int schritt = 1;
		for (int i = links + 1; i <= rechts; i++) {
			// Zuständig für die schrittweise Consolenausgabe des Arrays und von pl, pr und
			// p
			if (printPartitionierung) {
				partitionierungSchritte += getArrayText(array, pivotLinks, pivotRechts, pivotWert, schritt);
				schritt++;
			}
			// if a[i] = p
			if (array[i] == pivotWert) {
				if (printPartitionierung) {
					partitionierungSchritte += "\ta[i] == pivot -->   Tausche a[i] mit a[pr+1] (Erweitert den pivot und tauscht ihn mit dem Element bei a[i])\n";
					partitionierungSchritte += String.format("\t  %d  ==   %d   -->   Tausche   %d  mit    %d\n\n",
							array[i], pivotWert, array[i], array[pivotRechts + 1]);
				}
				// a[i] <- a[pr+1]
				array[i] = array[pivotRechts + 1];
				// a[pr+1] <- p
				array[pivotRechts + 1] = pivotWert;
				// pr <- pr + 1
				pivotRechts++;
				// else if a[i] < p
			} else if (array[i] < pivotWert) {
				if (printPartitionierung) {
					partitionierungSchritte += "\ta[i] < pivot  -->   a[pl] <- a[i]; a[i] <- a[pr+1]; a[pr+1] <- pivot\n";
					partitionierungSchritte += String.format(
							"\t  %d  <   %d    -->   a[%d]  <-   %d ; a[%d] <-    %d   ;   a[%d]  <-   %d\n\n",
							array[i], pivotWert, pivotLinks, array[i], i, array[pivotRechts + 1], pivotRechts + 1,
							pivotWert);
				}
				// a[pl] <- a[i]
				array[pivotLinks] = array[i];
				// a[i] <- a[pr+1]
				array[i] = array[pivotRechts + 1];
				// a[pr+1] <- p
				array[pivotRechts + 1] = pivotWert;
				// pl <- pl + 1
				pivotLinks++;
				// pr <- pr + 1
				pivotRechts++;
			} else {
				// a[i] gr��er als pivot
				if (printPartitionierung) {
					partitionierungSchritte += "\ta[i] > pivot  -->   keine Veränderung\n";
					partitionierungSchritte += String.format("\t  %d  >   %d\n\n", array[i], pivotWert);
				}
			}
		}

		partitionierungSchritte += "PARTITIONIERUNG ABGESCHLOSSEN -> RETURN\n" + "pl=" + pivotLinks + ", pl="
				+ pivotRechts + ", p=" + pivotWert + "\n\n" + "Das partitionierte Array ist:\n" + getArray(array)
				+ "\n\n\n";

		partitioniertesArray = array;
		
		// gibt pl, pr und p in einem Array zur�ck
		// im Pseudocode in Zeile 1 durch das
		// (pl, pr, p) = Partitionieren(a, l, r)
		int[] returnArray = { pivotLinks, pivotRechts, pivotWert };
		return returnArray;
	}

	// Nur funktion um das Array in jedem schritt auszuprinten
	public static String getArrayText(int[] array, int pl, int pr, int p, int schritt) {
		String output = "";
		output += ("Schritt " + schritt + " (Pivot = " + p + "):\n");

		for (int i = 0; i < pl; i++) {
			output += "   ";
		}
		output += "  PL\n";

		for (int i = 0; i < pr; i++) {
			output += "   ";
		}
		output += "  PR\n";

		for (int i = 0; i < schritt; i++) {
			output += "   ";
		}
		output += "  i\n";

		output += getArray(array);

		return output;
	}

	public static String getArray(int[] arr) {
		String out = "[ ";
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				out += arr[i] + " ]\n";
			} else {
				out += arr[i] + ", ";
			}
		}
		return out;
	}

}