/************************************************************************

	PairOfDice.java				Author: James Pratt

	A program that plays the game of Snake, where one player 
	is a human and the other is the computer. When it is the human’s 
	turn, the program shows both the current turn score and the 
	current total score of the player. Allows the human to input ‘r’ to 
	roll again or ‘h’ to hold.

	The computer program plays according to the following rule:

	Keep rolling when it is the computer’s turn until it has accumulated 
	20 or more points, then hold. If the computer wins or rolls a 1, then 
	the turn ends immediately.

	The human to rolls first. 

*************************************************************************/

import java.util.Scanner;

public class Snake {

	//--------------------------------------------------------------------
	// Settings for the game.
	//--------------------------------------------------------------------

	public static void main(String[] args) {

		PairOfDice humanDice = new PairOfDice();
		PairOfDice computerDice = new PairOfDice();

		boolean game = true, humanTurn = true;
		int sum = 0;
		int humanScore = 0, computerScore = 0;
		int humanPoints = 0, computerPoints = 0;
		String reply;

		Scanner input = new Scanner(System.in);

		Die die1 = new Die();
		Die die2 = new Die();

	//--------------------------------------------------------------------
	// Starts the game. While game is true, game runs.
	//--------------------------------------------------------------------

		while (game == true) {

			// While human turn is true, human's turn:

			while (humanTurn == true) {
				if (humanScore >= 100) {
					System.out.println("You win! Score: " + humanScore);
					System.out.println("Computer score: " + computerScore);
					humanTurn = false;
					game = false;
				}
				else {
					System.out.print("Your score is: " + humanScore + ". ");
					System.out.print("Roll or hold? (type r or h) ");
					reply = input.nextLine();
					if (reply.equals("r")) {
						System.out.print("You chose to roll. ");
						System.out.println("Rolling the dice...");
						humanDice.rollDice();
						System.out.println("Die 1 is " + die1.faceValue);
						System.out.println("Die 2 is " + die2.faceValue);
						sum = humanDice.sumOfDice();
						if (humanDice.getDie1Value() == 1 || humanDice.getDie2Value() == 1) {
							System.out.println("You rolled a 1! You lose a turn!");
							humanPoints = 0;
							humanTurn = false;
							sum = 0;
						}
						else {
							humanPoints = humanPoints + sum;
							System.out.println("Human accumulated points: " + humanPoints);
							humanTurn = true;
						}
					}
					else {
						System.out.println("You choose to hold!");
						humanScore = humanScore + humanPoints;
						humanTurn = false;
						humanPoints = 0;
						sum = 0;
					}
				}
			}

			// Computer's turn:

			if (computerScore >= 100) {
				System.out.println("Computer wins! Score: " + computerScore);
				System.out.println("Your score: " + humanScore);
				humanTurn = false;
				game = false;
			}
			else {
				if (computerPoints < 20) {
					System.out.println("Computer rolls... ");
					computerDice.rollDice();
					System.out.println("Die 1 is " + die1.faceValue);
					System.out.println("Die 2 is " + die2.faceValue);
					sum = computerDice.sumOfDice();
					if (computerDice.getDie1Value() == 1 || computerDice.getDie2Value() == 1) {
						System.out.println("Computer rolled a 1! Your turn!");
						computerPoints = 0;
						humanTurn = true;
						sum = 0;
					}
					else {
						computerPoints = computerPoints + sum;
						System.out.println("Computer accumulated points: " + computerPoints);
					}
				}
				else {
					computerPoints = sum;
					computerScore = computerScore + computerPoints;
					humanTurn = true;
					System.out.print("Computer score is: " + computerScore + ". ");
					System.out.println("The computer chooses to hold!");
					sum = 0;
				}
			}
		}
	}
}