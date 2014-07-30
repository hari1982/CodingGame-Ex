package exercise.level1;

import java.util.Scanner;

public class Player {

	//T1 = (6,4) (31, 4)
	//T2 =
	/*				  N
	 *      		  |
	 *       		  |
	 *       		  |
	 *       		  |     (*,*)
	 *       		  |  
	 *W---------------|-------------------E
	 *       		  |
	 *       		  |
	 *       		  |
	 *       		  |
	 *                |
	 *				  S
	 */
	    
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int Lx = in.nextInt();
		int Ly = in.nextInt();
		int Tx = in.nextInt();
		int Ty = in.nextInt();
		System.err.println("LX=" + Lx + " LY=" + Ly + " Tx=" + Tx + " Ty=" + Ty);
		while (true) {
			// Read information from standard input
			int n = in.nextInt();
			System.err.println("E=" + n);
			if (Lx == Tx) {
				int diff = Ty - Ly;
				if (diff > 0) {
					System.out.println("N");
					Tx++;
				} else{
					System.out.println("S");
					Tx--;
				}
			} else if (Ty == Ly) {
				int diff = Tx - Lx;
				if (diff > 0) {
					System.out.println("W");
					Tx++;
				} else{
					System.out.println("E");
					Tx--;
				}
			} else if (Lx == 0){
				System.out.println("SW");
				Tx--;
				Ty++;
			}else if (Ly == 0){
				System.out.println("NE");
				Tx++;
				Ty--;
			}else if (Tx == 0 || (Tx == Ty && (Tx+Ty)>0)){
				System.out.println("SE");
				Tx++;
				Ty++;
			}else if (Ty == 0 || (Tx == Ty && (Tx+Ty)<0)){
				System.out.println("NW");
				Tx--;
				Ty--;
			}
		}
	}
}
