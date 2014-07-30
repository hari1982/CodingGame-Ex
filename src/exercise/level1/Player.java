package exercise.level1;

import java.util.Scanner;

/*
 * The final battle of Ragnarök, the twilight of the gods is approaching. You incarnate Thor who is participating in this final battle against all the forces of evil, led by Loki, Thor's wizard brother.

Thor was wounded during a previous battle against Fenrir, the wolf-god. During the battle, Loki took advantage of the general confusion and used his magic to annihilate the magical powers of Thor’s hammer, Mjöllnir, by separating it from his soul: the light of power.

Thor, who now feels very weak, must find and reach the light of power, as fast as possible, since it is the only thing which can restore his and Mjollnir’s powers.
 
 
THE PROGRAM:
You move on a map which is 40 wide by 18 high. Thor is initially placed on a random spot on the map and must reach the light of power as quickly as possible.
 
During each turn, you must specify in which direction to move, from one of the following:

    N (North)
    NE (North-East)
    E (East)
    SE (South-East)
    S (South)
    SW (South-West)
    W (West)
    NW (North-West)


You win when Thor reaches the light of power.

You lose:

    if Thor moves off the map.
    or if Thor doesn't have enough energy left to reach the light of power.

The program must first read the initialization data from standard input. Then, within an infinite loop, read the data from the standard input related to Thor's current state and provide to the standard output Thor's movement instructions.

Don’t forget to run all the tests by modifying the value of the “test” variable (1, 2, 3, 4) in the “Test script” window

The tests provided are similar to the validation tests used to compute the final score but remain different.
 
INITILIZATION INPUT:
Line 1: 4 integers LX LY TX TY. (LX, LY) indicate the position of the light of power. (TX, TY) indicate Thor’s starting position.
 
INPUT FOR ONE GAME TURN:
Line 1: The level of Thor’s remaining energy E. This represents the number of moves he can still make.
 
OUTPUT FOR ONE GAME TURN:
A single line providing the move to be made: N NE E SE S SW W or NW
 
CONSTRAINTS:
0 ≤ LX < 40
0 ≤ LY < 18
0 ≤ TX < 40
0 ≤ TY < 18
0 < E ≤ 100
Response time for a game turn ≤ 100ms
 
EXAMPLE:
Thor starts on the map on the square (3, 6). The light of power is on square (3, 8).
Initialization input (out of the infinite loop) 	No output expected
3 8 3 6 	Flash = (3,8) Thor = (3, 6)
	 
Input for turn 1 	Output for turn 1
10 	Thor has enough energy left for 10 moves
	S
Thor moves Southwards.
New position = (3, 7)
Input for turn 2 	Output for turn 2
9 	Thor has enough energy left for 9 moves
	S
Thor moves Southwards.
New position = (3, 6)

    Thor has won: he has reached the flash of power!

 */
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
