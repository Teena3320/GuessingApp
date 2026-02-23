# GuessingApp
## UC1 — Game Initialization
The first stage establishes the foundation of the game.
Features added:
- Prepare the initial game configuration
- Load or generate the target number
- Present the rules and basic instructions to the player
This phase includes no user input processing yet.

## UC2 — User Guess Submission
Building upon UC1, this stage introduces full user interaction.
Features added:
- Using the Scanner class to read input from the player
- Introducing the GuessValidator to validate guess format and range
- Integrating the validator into the main gameplay loop
This milestone transforms the system from passive setup to active gameplay.

## UC3 — Hint Generation
UC3 extends the system with a helpful hint mechanism.
Features added:
- A HintService that can generate a limited number of hints
- Logic to determine when and how hints are offered
- Integration of hint generation into the existing guess flow
Players now receive feedback that assists them in finding the correct answer.

## UC4 — Error Handling & Input Validation
This iteration focuses on making the game resilient and error‑proof.
Features added:
- Custom InvalidInputException to handle unexpected or invalid entries
- A ValidationService to centralize input checking
- Integration to ensure invalid inputs do not crash the game
This greatly improves stability and debugging clarity.

## UC5 — Game Result Storage
UC5 introduces persistent storage for game results.
Features added:
- A StorageService responsible for managing result output
- Writing the final score, attempts or result summary to a text file
- Seamless integration with the game lifecycle
Players’ outcomes can now be recorded for future reference.

## UC6 — Game Restart & Exit
The final stage completes the full game loop.
Features added:
- Prompting the player to either replay or exit
- Restarting the entire game session cleanly without restarting the application
- Preserving storage and validation logic across sessions
This creates a user‑friendly gameplay experience.
