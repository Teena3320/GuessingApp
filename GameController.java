/**
* Handles game lifecylce decisions.
* 
* This class is responsible for deciding
* whether the game should restart or exit
* based on user choice.
*/
import java.util.*;

class GameController {
	public static boolean restartGame(Scanner scanner){
		System.out.print("Do you want to play again? (yes/no): ");
		return scanner.nextLine().equalsIgnoreCase("yes");
	}
}