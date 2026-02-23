/**
* MAIN CLASS
* 
* Coordinate the game flow:
* 1. Initialize game
* 2. Accept user guesses
* 3. Validate guesses
* 4. Give Hints
* 5. Stop when game ends
* 
* @author Developer
* @version 3.0
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
			String hint = HintService.generateHint(config.getTargetNumber(), attempts);
			
			if("CORRECT".equals(result)){
				System.out.println(result);
				break;
			}
			if(attempts<4){System.out.println(hint);}			
			System.out.println(result);
		}
	}
}