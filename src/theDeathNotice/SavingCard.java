package theDeathNotice;

/**
 * This class represents a saving card. A saving card will
 * give a player another life in the case they draw a death card.
 * 
 * @author Skyla
 * @version 1
 *
 */
public class SavingCard extends Card {
	
	/**
	 * The inital cost of the saving card.
	 */
	final static int INITIAL_COST=30;
	
	/**
	 * The current Saving Card Price.
	 * The price may change based on the situation of the game.
	 */
	public static int CURRENT_COST = INITIAL_COST;
   
	/** 
	 * Creates a SavingCard.
	 * @param cardID the unique ID of the card
	 */
	public SavingCard(String cardID) {
		super(cardID);
	}

	/**
	 * A Joker drawn from card deck is rewarded as two saving cards.
	 * Adds the saving cards to the respective player.
	 * @param player Player that draws the card.
	 */
	public void act(Player player) {
		player.addSaveCard(this);
		player.addSaveCard(new SavingCard("saving"));	
	}
	
	/**
	 * Initializes the cost of the the saving card.
	 */
	public static void init() {
		CURRENT_COST = INITIAL_COST;
	}
}
