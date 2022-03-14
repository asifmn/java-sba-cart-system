public class Utilities {

	public static String rightPadder(String strToPad, int amountToPad) {
		String tempStrToPad = (strToPad != null) ? strToPad : " ";
		return String.format("%1$-" + amountToPad + "s", tempStrToPad);

	}

	public static String wallIn(String inStr) {
		return " " + inStr + " |";
	}

	public static void separate(String separator, int sepCount) {
		for (int i = 1; i <= sepCount; i++) {
			System.out.print(separator);
		}
		System.out.println();
	}
	
	public static double round(double toRound, int decimals) {
		double scaler = Math.pow(10, decimals);
		return Math.round(toRound*scaler)/scaler;
	}

	public static void main(String[] args) {
		System.out.println(rightPadder("AS", 12));
		System.out.println(rightPadder("ASD", 12));
		System.out.println(rightPadder("ASDF", 12));
		System.out.println(rightPadder("ASDFG", 12));
		System.out.println(rightPadder("ASDFGH", 12));
	}
}
