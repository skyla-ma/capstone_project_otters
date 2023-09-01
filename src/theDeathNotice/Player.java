package theDeathNotice;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * 
 * This class represents a player in the game.
 * This class is responsible for keeping track of the player's
 * hand as well as the functions of each player, such as the number of times 
 * they have drawn or how many points they have.
 * 
 * @author Skyla
 * @version 1
 *
 */
public class Player {
	
	private String name;
	private int points;
	private int initialPlayerNumber;
	private LocalTime time;
	private ArrayList<Card> currentHand;
	private boolean alive;
	private int drawCount;
	private final int MAX_PLAYER_NAME_LENGTH = 15;
	

	/**
	 * This class represents a player.
	 * @param name the name of the player
	 * @param initialPlayerNumber the number of the player
	 */
	public Player(String name, int initialPlayerNumber) {
		if (name == null)
			name = "player unknown";
		else if (name.length()<=MAX_PLAYER_NAME_LENGTH)
			this.name = name;
	    else
	    	this.name=name.substring(0, MAX_PLAYER_NAME_LENGTH+1);
		this.initialPlayerNumber = initialPlayerNumber;
		alive = true;
		points = 30;
		points += initialPlayerNumber;
		time = LocalTime.now();
		currentHand = new ArrayList<Card>();
	}


	/**
	 * Gets the player's name.
	 * 
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the player's assigned number.
	 * 
	 * @return the inital player number of the player
	 */
	public int getInitialPlayerNumber() {
		return initialPlayerNumber;
	}

	/**
	 * Sets the number of points the player has.
	 * @param points the number of points to set the points to
	 */
	public void setPoints(int points) {
		this.points = points;
	}


	/**
	 * Gets the number of points the player has.
	 * @return the number of points the player has
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Gets the number of saving cards the player has.
	 * @return the number of saving cards the player has
	 */
	public int getSaveCardCount() {
		int count = 0;
		for(Card card: currentHand) {
			if (card instanceof SavingCard) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Gets the current time. 
	 * @return time the time that the player last received points.
	 */
	public LocalTime getTime() {
		return time;
	}

	/**
	 * Adds a number of points to the player. Sets the time to the current time.
	 * @param pointsAdded number of points added to the field points (can be a negative number to subtract points)
	 */
	public void addPoints(int pointsAdded) {
		points += pointsAdded;
		time = LocalTime.now();	
	}
	
	/**
	 * Adds cardBought to the currentHand.
	 * @return cardBought the card to be added to the hand or null if no money left to buy card
	 */
	
	public Card buySaveCard() {
		if(points < SavingCard.CURRENT_COST) {
			return null;
		}
		points -= SavingCard.CURRENT_COST;
		time = LocalTime.now();	
		SavingCard card = new SavingCard("saver");
		addSaveCard(card);
		return card;
	}
	
	/**
	 * Adds a save card to the player hand.
	 * @param card the SaveCard
	 */
	public void addSaveCard(Card card) {
       	currentHand.add(card);
	}
			
	/**
	 * Removes a save card from the player hand. 
	 * @return whether the player had a saving card or not
	 */
	public boolean removeSaveCard() {
		int i = 0;
	    while(i < currentHand.size()) {
		   if(currentHand.get(i) instanceof SavingCard) {
			   currentHand.remove(i);
			   return true;
		   }
		   else {
			   i++;
		   }
	   }
	   return false;
	}

	/**
	 * Returns whether or not the player is alive.
	 * 
	 * @return whether the player is alive or not
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * Sets the player to alive or dead.
	 * 
	 * @param alive what to set the player's alive status to
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * Resets the draw count to 0.
	 */
	public void resetDrawCount() {
		drawCount = 0;
	}
	
	/**
	 * Gets the number of times a player has drawn in the current turn.
	 * @return the number of times the player has drawn a card during their current turn
	 */
	public int getDrawCount() {
		return drawCount;
	}
	
	/**
	 * Increments the number of times a player has drawn for their turn
	 * @return true if the current player's draw count can be increased
	 * false if the current player's draw count is already 3
	 */
	public boolean increaseDrawCount() {
		if (drawCount<3) {
		   drawCount++;
		   return true;
		}
		return false;
	}
	/**
	 * Draws the top card from the deck of cards by adding it to the hand of the player and removing it from the card deck.
	 * @param cards the deck of cards in the game to draw from
	 * @post removes the top (index 0) card in the CardDeck of the parameter
	 */ 
	public void drawCard(CardDeck cards) {
		Card card = cards.drawTopCard();
		currentHand.add(card);
	}
}
