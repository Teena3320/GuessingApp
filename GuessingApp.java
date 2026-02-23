/**
* MAIN CLASS
* 
* Use case 4: Error Handling & Validation
* 
* This class coordinates the game execution while ensuring 
* all user inputs are safely validated before processing.
* 
* Responsibilities:
* - Initialize game configuration
* - Accept user input
* - Validate input using ValidationService
* - Handle game flow without crashing on invalid input
* 
* @author Developer
* @version 4.0
*/

import java.util.Scanner;

public class GuessingApp {
	public static void main(String[] args) throws InvalidInputException{
		System.out.println("Welcome to the Guessing App");
		GameConfig config = new GameConfig();
		config.showRules();
		
		Scanner scanner = new Scanner(System.in);
		int attempts=0;
		while(attempts < config.getMaxAttempts()){
			System.out.print("Enter your guess: ");
			int guess = ValidationService.validateInput(scanner.nextLine());
			attempts++;
			
			
			String result = GuessValidator.validateGuess(guess, config.getTargetNumber());
			//String hint = ;
			
			if("!CORRECT".equals(result) && attempts < config.getMaxHints()){
				System.out.println(HintService.generateHint(config.getTargetNumber(), attempts));
			}
			System.out.println(result);
			
			if("CORRECT".equals(result)){
				break;
			}
		}
	}
}