/**
* MAIN CLASS
* 
* Use case 6: Game Restart & Exit
* 
* This class coordinates the complete game lifecycle,
* allowing the player replay or exit gracefully.
* 
* Responsibilities:
* - Start a new game session
* - Execute the guessing flow
* - Persist game results
* - Restart or exit based on user choice
* 
* @author Developer
* @version 6.0
*/

import java.util.Scanner;

public class GuessingApp {
	public static void main(String[] args) throws InvalidInputException{
		Scanner scanner = new Scanner(System.in);
		boolean restart;
		
		System.out.println("===========================");
		System.out.println("Welcome to the Guessing App");
		System.out.println("===========================\n");
	do {
		System.out.print("Enter Player Name:");
		
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
			
			if(!"CORRECT".equals(result) && attempts <= config.getMaxHints()){
				System.out.println(HintService.generateHint(config.getTargetNumber(), attempts));
			}
			System.out.println(result);
			
			if("CORRECT".equals(result)){
				win = true;
				break;
			}
		}
		StorageService.saveResult(player,attempts,win);
		restart = GameController.restartGame(scanner);
	}
	while(restart);
	}
}