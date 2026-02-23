/**
* MAIN CLASS
* 
* Coordinate the game flow:
* 1. Initialize game
* 2. Accept user guesses
* 3. Validate guesses
* 4. Stop when game ends
* 
* @author Developer
* @version 2.0
*/
import java.util.Scanner;

public class GuessingApp {
	public static void main(String[] args){
		System.out.println("Welcome to the Guessing App");
		GameConfig config = new GameConfig();
		config.showRules();
		
		Scanner scanner = new Scanner(System.in);
		int attempts=0;
		
		while(attempts < config.getMaxAttempts()){
			System.out.print("Enter your guess: ");
			int guess = scanner.nextInt();
			attempts++;
			
			String result = GuessValidator.validateGuess(guess, config.getTargetNumber());
			System.out.println(result);
			
			if("CORRECT".equals(result)){
				break;
			}
		}
	}
}