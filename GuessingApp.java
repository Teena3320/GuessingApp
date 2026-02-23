/**
* MAIN CLASS
* 
* Use case 5: Game Result Storage
* 
* This class coordinates the complete game flow
* and persists the final result after completion.
* 
* Responsibilities:
* - Initialize game configuration
* - Accept and validate user guesses
* - Generate hints when applicable
* - Store game result at the end
* 
* @author Developer
* @version 5.0
*/

import java.util.Scanner;

public class GuessingApp {
	public static void main(String[] args) throws InvalidInputException{
		System.out.println("===========================");
		System.out.println("Welcome to the Guessing App");
		System.out.println("===========================\n");

		System.out.print("Enter Player Name:");
		Scanner scanner = new Scanner(System.in);
		String player = scanner.nextLine();

		GameConfig config = new GameConfig();
		config.showRules();
		
		boolean win = false;
		
		int attempts=0;
		while(attempts < config.getMaxAttempts()){
			System.out.print("Enter your guess: ");
			int guess = ValidationService.validateInput(scanner.nextLine());
			attempts++;
			
			String result = GuessValidator.validateGuess(guess, config.getTargetNumber());
			
			if(!"CORRECT".equals(result) && attempts < config.getMaxHints()){
				System.out.println(HintService.generateHint(config.getTargetNumber(), attempts));
			}
			System.out.println(result);
			
			if("CORRECT".equals(result)){
				win = true;
				break;
			}
		}
		StorageService.saveResult(player,attempts,win);
	}
}