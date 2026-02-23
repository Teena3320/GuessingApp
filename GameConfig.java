/** 
* Use Case 1: Game Initialization
* 
* This class is responsible for:
* - Seting game boundaries
* - Generating a random target number
* - Displaying game rules
* 
* Demonstrates:
* - Encapsulation
* - Construct initialization
* - random number generation
*/
import java.util.Random;

class GameConfig{
	private final int MIN = 1;
	private final int MAX= 100;
	private final int MAX_ATTEMPTS =7; 
	private final int MAX_HINTS = 3;
	
	int targetNumber;
	
	public GameConfig(){
		Random random = new Random();
		this.targetNumber = random.nextInt(MAX-MIN + 1) + MIN;
	}
	
	public int getTargetNumber(){
		return targetNumber;
	}
	public int getMaxAttempts(){
		return MAX_ATTEMPTS;
	}
	public int getMaxHints(){
		return MAX_HINTS;
	}
	public void showRules(){
		System.out.println("Guess a number between "+MIN+" and "+MAX);
		System.out.println("You have "+MAX_ATTEMPTS+" attempts.");
		System.out.println("Hints will be provided after wrong guesses.\n");
	}
}
