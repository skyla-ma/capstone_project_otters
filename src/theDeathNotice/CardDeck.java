package theDeathNotice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * This class represents the card deck in the game. The card deck
 * has 4-8 death cards and one Joker on top of a standard deck 
 * of cards (with the exception of As as death cards are As).
 * @author Skyla
 * @version 1
 *
 */
public class CardDeck {
	private ArrayList<Card> cards;
	private boolean topCardVisible=false;
	private Game game;
	
	/**
	 * Creates a CardDeck (a standard card deck, except with 4-8 As and 1 Joker).
	 * @param game the game the card deck is used for
	 */
	public CardDeck(Game game) {
		this.game=game;
		cards = new ArrayList<Card>();
		
		for (int i=1; i<=4; i++) {
			cards.add(new DeathCard("dead"+"-" + String.valueOf(i)));
		}
		for (int n = 2; n <= 13; n++) {
			for (int q = 1; q <= 4; q++) {	    
				cards.add(new PointCard(getType(n)+"-"+getSuit(q)));
			}
		}
		cards.add(new SavingCard("saver"));
		int r = (int) (Math.random()*5);
		for (int i=1; i<=r; i++) {
			// Need at least one?
			cards.add(new DeathCard("dead"+"-" + String.valueOf(i)));
		}
	}
	
	/**
	 * Removes the card at the top of the deck.
	 * @return the card removed or null if there are no more cards to draw
	 */
	public Card drawTopCard() {
		if(cards.size()==0) {
			return null;
		}
		Card card = cards.remove(0);
		SavingCard.CURRENT_COST=game.getPricingModel().getPrice();
		return card;
	}
	
	/**
	 * Looks at the card at the top of the deck.
	 * @return the top card in the deck or null if there are no more cards in deck
	 */
	public Card peekTopCard() {
		if(cards.size()==0) {
			return null;
		}
		return cards.get(0);
	}
	
	/**
	 * If the card at the top of the deck is visible to all players (the front is showing) or not.
	 * 
	 * @return true if the top card is visible, false otherwise 
	 */
	public boolean isTopCardVisible() {
		return topCardVisible;
	}
	
	/**
	 * Sets the card at the top of the deck visible to all players (flips the card).
	 * 
	 * @param topCardVisible whether or not the top card is visible
	 */
	public void setTopCardVisible(boolean topCardVisible) {
		this.topCardVisible = topCardVisible;
	}
	
	/**
	 * The number of cards left in the deck that have not been drawn yet.
	 * 
	 * @return The number of cards left in the deck.
	 */
	public int getNumOfCards() {
		return cards.size();
	}
	
	/**
	 * Counts the number of steps or cards there are until the next DeathCard.
	 * 
	 * @return the number of cards until the next DeathCard
	 */
	public int getDeathDistance() {
		int steps = 0;
		for (Card card: cards)  {
			if (card instanceof DeathCard) {
				break;
			}
			steps++;
		}
		return steps;		
	}
	
	/** 
	 * Shuffles the deck by putting the cards in the deck in a random order.
	 */
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}
	 
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
	    for (Card card: cards)  {
	    	buf.append(card);
	    	buf.append("\n");
	    }
	    return buf.toString();
	}

	private String getSuit(int i) {
		if (i==1)
			return "c";
		else if (i==2)
			return "d";
		else if (i==3)
			return "h";
		else if (i==4) 
			return "s";
		else 
			return "c";
	}
	
	private String getType(int i) {
		if (i>=2 && i<=10) {
			return String.valueOf(i);
		}
		else if (i==11) {
			return "j";
		}
		else if (i==12) {
			return "q";
		}
		else if (i==13) {
			return "k";
		}
		else 
			return "dead";
			
	}

}
