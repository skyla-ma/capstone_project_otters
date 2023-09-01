package theDeathNotice;

/**
 * This class represents a class to implement the adaptive SavingCard cost.
 * 
 * @author Skyla
 * @version 1
 * 
 */
public class PricingModel {
	private Game game;
	private int currentPrice;
	private int invokedCount;
	private final static int INVOCATION_COUNT=5;
	private final static int MIN_POINT_BOUND=10;
	
	/** 
	 * Creates a new pricing model. 
	 * Sets the current price to the initial cost and the invoked count 0.
	 * @param game the game the pricing model is used for
	 */
	public PricingModel(Game game) {
         this.game = game;
         this.currentPrice = SavingCard.INITIAL_COST;
         this.invokedCount = 0;
         
	}
	
	/** 
	 * This class calculates the new price of the SavingCard. It uses the idea of simulated annealing
	 * to dynamically adjust the price, considering the players' points and the distance to the next death card.
	 *  This price will be rounded to a multiple of 5.
	 * 
	 * @return the new price of the SavingCard
	 */
	public int getPrice() {
		
		// Get distance from next dead card.
		CardDeck deck = game.getCardDeck();
		int distance = deck.getDeathDistance();
			 
		if (this.invokedCount % INVOCATION_COUNT == 0 || distance < INVOCATION_COUNT-1) {
			// Get minimum points from active players
			int lowest = Math.max(MIN_POINT_BOUND, game.getLowestPoint());
			
			//int distance = deck.getDeathDistance();
			int totalCards = deck.getNumOfCards();
			//distance = Math.max(1, (totalCards - distance) * lowest / totalCards ); 
			int dAdj = this.currentPrice;
			if (distance < INVOCATION_COUNT && totalCards >= INVOCATION_COUNT)
				dAdj = this.currentPrice * INVOCATION_COUNT;
				
			this.currentPrice = Math.max(MIN_POINT_BOUND, Math.min(lowest, dAdj)) / INVOCATION_COUNT * INVOCATION_COUNT;
			//System.out.printf("distance: %d, lowest: %d, price: %d\n", distance, lowest, this.currentPrice);
		}
		this.invokedCount++;
		
		return this.currentPrice;
	}
	
}
