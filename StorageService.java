/**
* Use Case 5: Game Result Storage
* 
* This class is responsible for persisting
* the final game result after the game ends.
* 
* Results are stored in a file so that
* game history is not lost after exit.
*/
import java.io.*;

class StorageService{
	public static void saveResult(String player, int attempts, boolean win){
		try(BufferedWriter writer = new BufferedWriter( new FileWriter("game_results.txt", true))){
			writer.write("Player: "+ player +", Attempts: "+attempts + ", Result: "+(win?"WIN":"LOSE"));
			writer.newLine();
		}
		catch(IOException e){
			System.out.println("Unable to save game result.");
		}
	}
}
