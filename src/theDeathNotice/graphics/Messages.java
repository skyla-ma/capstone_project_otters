package theDeathNotice.graphics;

/**
 * Contains all of the messages for MainGame.
 * 
 * @author skyla
 * @version 1
 *
 */
public class Messages {
	
	/**
	 * This message pops up when somebody presses the card deck when it is empty. 
	 */
	public final static String EMPTY_CARD_DECK= "Card Deck is Empty";
	
	/**
	 * This message pops up when a player has not drawn a card yet (presses take card before drawing a card).
	 */
	public final static String DRAW_CARD_FIRST = "Please draw a card first";
	
	/**
	 * This message pops up when the card deck is empty and the game has ended.
	 */
	public final static String CARD_DECK_EMPTY="Card Deck is Empty. {0} wins!";
	
	/**
	 * This message pops up when a player dies.
	 */
	public final static String PLAYER_DEAD = "{0} is dead";
	
	/**
	 * This message pops up when the game ends and someone wins.
	 */
	public final static String PLAYER_WIN = "{0} wins!";
	
	/**
	 * This message pops up when a player tries to end their turn before drawing a card.
	 */
	public final static String PLAYER_MUST_DRAW_ONCE="The player must at least draw one card";
	
	/**
	 * This message pops up when a player tries to buy a save card after they see a card in the deck.
	 */
	public final static String NOT_ALLOWD_TO_BUY_CARD="Buy saving card is not allowed after the player sees the top card in deck";
	
	/**
	 * This message pops up when a player who doesn't have enough money tries to buy a saving card.
	 */
	public final static String NO_ENOUCH_MONDY_TO_BUY_CARD="{0} does not have enough money to buy a saving card";
	
	/**
	 * This message pops up when a player has drawn 3 cards already.
	 */
    public final static String YIELD_TO_NEXT_PLAYER="{0} already played 3 times, please yield turn to the next player";
    
    /**
     * This message pops up when a player does not take the card they drew.
     */
    public final static String PLAYER_TAKE_CARD="{0} please take the card away";
    
    /**
     * This message pops up when a player tries to end their turn before drawing a card.
     */
    public final static String END_TURN_NOT_ALLOWED="The player must draw the top card to end turn";
}
