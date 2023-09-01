package theDeathNotice;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents a game of TheDeathNotice.
 * 
 * @author Skyla
 * @version 1
 *
 */
public class Game {
	
	private ArrayList<Player> players;
	private CardDeck cardDeck;
	private PricingModel model;
	private int currentPlayerId;
	private boolean isOver=false;
	
	/**
	 * A game of The Death Notice.
	 */
	public Game() {
		init();
	}
	
	/**
	 * A game of The Death Notice
	 * @param names The names of the players 
	 */
	public Game(List<String> names) {
		init();
		for (int i=0; i<names.size(); i++) {
			players.add(new Player(names.get(i), i));
		}
	}
	
	private void init() {
		cardDeck = new CardDeck(this);
		model = new PricingModel(this);
		players = new ArrayList<Player>();
	}
	
	/**
	 * Gets the ID of the current player.
	 * 
	 * @return the ID of the current player
	 */
	public int getCurrentPlayerId() {
		return currentPlayerId;
	}
	
	/**
	 * Gets the players.
	 * 
	 * @return the players in an ArrayList 
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	/**
	 * Updates the player's ID when another player dies.
	 * 
	 * @return whether or not there are multiple players (more than 1) still alive
	 */
	public boolean updateCurrentPlayerId() {
		//playerTurn = (playerTurn+1)%(players.size());
		if (numOfAlivePlayers()>1) {
			currentPlayerId = (currentPlayerId+1)%(players.size());
			Player player = getCurrentPlayer();
			while (!player.isAlive()) {
				currentPlayerId = (currentPlayerId+1)%(players.size());
				player = getCurrentPlayer();				
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gets who the current player is (whose turn it is).
	 * 
	 * @return the player who's the current player
	 */
	public Player getCurrentPlayer() {
		return players.get(currentPlayerId);
	}
	
	/**
	 * Gets the CardDeck used for the game.
	 * 
	 * @return the card deck of the game
	 */
	public CardDeck getCardDeck() {
		return cardDeck;
	}
	
	/**
	 * Gets the pricing model for SaveCard.
	 * 
	 * @return the pricing model of the game
	 */
	public PricingModel getPricingModel() {
		return model;
	}
	
	/**
	 * Gets the playerIDs of the dead players.
	 * 
	 * @return the playerIDs of the dead players
	 */
	public List<Integer> getDeadPlayerIds() {
		ArrayList<Integer> dead = new ArrayList<>();
		for (int i=0; i<players.size(); i++) {
			if (!players.get(i).isAlive()) {
				dead.add(i);
			}
		}
		return dead;
	}

	/**
	 * Gets which player the the winner is.
	 * 
	 * @return the winner
	 */
	public Player getWinner() {
		int maxPoint = Integer.MIN_VALUE;
		LocalTime earliestTime = LocalTime.MAX;
		Player winner = null;
		for (Player player: players) {
			if (player.isAlive()) {
				if (player.getPoints() > maxPoint) {
			  	    winner = player;
				    maxPoint = player.getPoints();
				    earliestTime = player.getTime();
				}
				else if (player.getPoints() == maxPoint && earliestTime.compareTo(player.getTime()) > 0) {
			  	    winner = player;
					earliestTime = player.getTime();
				}
			}
		}
		return winner;
	}
	
	
	/**
	 * If there are multiple players that are tied. 
	 * 
	 * @return whether or not there are multiple players with the same number of points
	 */
	public boolean hasMultiplePlayerWithSamePoints() {
		for (int i=0; i<players.size(); i++) {
			for (int j=i+1; j<players.size(); j++) {
				if (players.get(i).getPoints() == players.get(j).getPoints()) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Gets the number of players alive.
	 * 
	 * @return the number of players alive
	 */
	public int numOfAlivePlayers() {
		int res = 0;;
		
		for (Player player: players) {
			if (player.isAlive()) {
				res++;
			}
		}
		return res;
	}
	
	/**
	 * Gets the point amount of the remaining player with the lowest amount of points.
	 * 
	 * @return the point value of the alive player with the lowest point value
	 */
	public int getLowestPoint() {
		int res = Integer.MAX_VALUE;
		
		for (Player player: players) {
			if (player.isAlive()) {
				res = Math.min(res, player.getPoints());
			}
		}
		return res;
	}
	
	/**
	 * Whether or not the game is over.
	 * 
	 * @return whether the game is over or not
	 */
	public boolean isOver() {
		return isOver;
	}

	/**
	 * Sets the game to over when it ends.
	 * 
	 * @param isOver whether the game is over or not
	 */
	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}
}
