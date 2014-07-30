package exercise.level1;

import java.util.Scanner;

public class Player2 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		// Read init information from standard input, if any

		while (true) {
			// Read information from standard input
			int Sx = in.nextInt();
			int Sy = in.nextInt();
			System.err.println("Sx: " + Sx + ", Sy:" + Sy);
			for (int i = 0; i < 8; i++) {
				int Mh = in.nextInt();
				System.err.println("Mh: " + Mh);
				if (Mh > 0) {
					System.out.println("FIRE");
				} else {
					System.out.println("HOLD");
				}
				Sx++;
				if (Sx > 7)
					Sx = 0;
			}
			// System.err.println("Input:"+n);
		}
	}
}
