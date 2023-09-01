package theDeathNotice.graphics;

import javax.swing.*;

/**
 * The class representing the window or page of instructions.
 * This class has the instructions of the game for the players
 * to refer to.
 * 
 * @author Skyla
 * @version 1
 *
 */

public class Instructions {
	
		/**
		 * the instructions text
		 */
       String text="<html><body>" 
       		+ "<h3>Instructions:</h3>"
    		+ "<h4>The goal of this game is to get as many points as possible without dying.</h4>" 
       		+ "<h4> Rule 1:</h4>"
       		+ "During a player’s turn, they can choose to draw 1, 2, or 3 cards by first clicking on the deck to reveal the card, then clicking on “Take Card”.  <br>" 
       		+ "The cards they draw correspond to how many points the player gets (J, Q, K are all 10). <br>" 
       		+ "The player is then given the number of points that is denoted by their card.   <br>" 
       		+ "<h4> Rule 2:</h4>"
       		+ "If a “death” card (the As, 4-8 of them) is ever drawn, the player who draws it automatically dies <br>" 
       		+ "unless they have a “saving” card (represented by a star next to the player on the scoreboard), in which case the “saving” card is automatically used. <br>" 
       		+ "<h4> Rule 3:</h4>"
       		+ "There will also be a special “saving” card (or Joker) in the deck that is worth 2 of them. <br>" 
       		+ "<h4> Rule 4:</h4>"
       		+ "At any point during their turn before they end their turn or draw a “death” card,   <br>" 
       		+ "a player can choose to convert a certain number of points to a “saving” card, which can be used to cancel a “death” card drawn later.    <br>" 
       		+ "<h4> Rule 5:</h4>"
       		+ "The cost of a “saving” card changes throughuot the game according to the current situation.   <br>" 
       		+ "<h4> Rule 6:</h4>"
       		+ "Allow the next player to go through their turn (as soon as a player presses the “end turn” button, their turn is over).<br>" 
       		+ "Continue this process until all the cards in the deck are gone.   <br>" 
       		+ "<h4> Rule 7:</h4>"
       		+ "Whoever of the remaining players has the most points wins, and the player who reaches the point value first wins in the case of a tie. <br>" 
       		
        	+ "</body></html>";
       
       /**
        * Initializes the page with the instructions by opening up a message dialog.
        * @param frame The MainGame JFrame that we use to open up this class.
        */
	   public Instructions(JFrame frame) {
		   JOptionPane.showMessageDialog(frame,
				    text,
				    "Please Read Game Instructions Carefully",
				    JOptionPane.INFORMATION_MESSAGE);
	   }
}