package theDeathNotice.graphics;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import theDeathNotice.Card;
import theDeathNotice.CardDeck;
import theDeathNotice.Game;
import theDeathNotice.Player;
import theDeathNotice.SavingCard;


/**
 * This class represents the window or page where the main game is taking place.
 * There is a scoreboard that refreshes each turn on the left side, the draw deck
 * in the middle, and buttons to take your card, end your turn, buy a saving card, 
 * and see the instructions on the right side.  
 * 
 * @author Skyla
 * @version 2
 *
 */
public class MainGame extends JFrame {
	 private static final String DEFAULT_DECK_IMAGE = "cards/back.png";
	 private static final String EMPTY_DECK_IMAGE="cards/base.png";
	 private static final String COST_IMAGE = "images/sale.png";
	 private JButton takeCardButton;
	 private JButton endTurnButton;
	 private JButton instructionsButton;
	 private JButton buySaveCardButton;
	 private JButton deckButton;
	 private JLabel scoreBoardLabel;
	 private JLabel player1Points;
	 private JLabel player2Points;
	 private JLabel player3Points;
	 private JLabel player4Points;
	 private JLabel cost;
	 private Game game;

	 //private JayLayer sound;
	 //private JComboBox<String> effects;
	
	 /**
	  * Initializes the page by initalizing the JLabels and JButtons and putting them in their respective places.
	  * @param playerNames the list of player names
	  */
	 public MainGame(List<String> playerNames) {
		 initGame(playerNames);		 
		 setResizable(false);
		 initComponents();
		 player1Points.setOpaque(true);
		 player1Points.setBackground(new java.awt.Color(255, 255, 255));
		 player2Points.setOpaque(true);
		 player2Points.setBackground(new java.awt.Color(255, 255, 255));
		 player3Points.setOpaque(true);
		 player3Points.setBackground(new java.awt.Color(255, 255, 255));
		 player4Points.setOpaque(true);
		 player4Points.setBackground(new java.awt.Color(255, 255, 255));
		 if (playerNames.size() == 2) {
			 player1Points.setText(playerNames.get(0) + ": " + 30);
			 player2Points.setText(playerNames.get(1) + ": " + 31);
			 player3Points.setVisible(false);
			 player4Points.setVisible(false);
		 }
		 if (playerNames.size() == 3) {
			 player1Points.setText(playerNames.get(0) + ": " + 30);
			 player2Points.setText(playerNames.get(1) + ": " + 31);
			 player3Points.setText(playerNames.get(2) + ": " + 32);
			 player4Points.setVisible(false);
		 }
		 if (playerNames.size() == 4) {
			 player1Points.setText(playerNames.get(0) + ": " + 30);
			 player2Points.setText(playerNames.get(1) + ": " + 31);
			 player3Points.setText(playerNames.get(2) + ": " + 32);
			 player4Points.setText(playerNames.get(3) + ": " + 33);
		 }
	     refreshScoreBoard();
	     refreshSavingCardCost();  
	 }
	 
	 
	 private void msgbox(String s) {
		    SoundPlayer soundPlayer = new SoundPlayer("audio/errorSound.mp3");
		    soundPlayer.start();
		    JOptionPane.showMessageDialog(this, s, "error", JOptionPane.ERROR_MESSAGE);
	 }
	 
	 private void declareWinner(String s) {
		    JOptionPane.showMessageDialog(this, s); 
	 }
	 
	 private void declareDead(String s) {
		    SoundPlayer soundPlayer = new SoundPlayer("audio/Oh.mp3");
		    soundPlayer.start();
		    JOptionPane.showMessageDialog(this, s); 
	 }
	 
	 private void initGame(List<String> playerNames) {
			 game = new Game(playerNames);
			 CardDeck deck = game.getCardDeck();
			 deck.shuffleDeck();
			 deck.shuffleDeck();
			 deck.shuffleDeck();
			 SavingCard.init();
			 			 
	 }
	 
	 
	 private void initComponents() {
		    takeCardButton = new javax.swing.JButton();
	        endTurnButton = new javax.swing.JButton();
	        instructionsButton = new javax.swing.JButton();
	        buySaveCardButton = new javax.swing.JButton();
	        deckButton = new javax.swing.JButton();
	        resetDeckButtonIcon(DEFAULT_DECK_IMAGE);
	        scoreBoardLabel = new javax.swing.JLabel();
	        player1Points = new javax.swing.JLabel();
	        player2Points = new javax.swing.JLabel();
	        player3Points = new javax.swing.JLabel();
	        player4Points = new javax.swing.JLabel();
	        cost = new javax.swing.JLabel();
	        setCostImage();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        
	        takeCardButton.setBackground(new java.awt.Color(255, 153, 153));
	        takeCardButton.setText("<html><center><b>Take Card</b></center></html>");
	        takeCardButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                takeCardButtonActionPerformed(evt);
	            }
	        });

	        endTurnButton.setBackground(new java.awt.Color(0, 204, 204));
	        endTurnButton.setText("<html><center><b>End Turn</b></center></html>");
	        endTurnButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                endTurnButtonActionPerformed(evt);
	            }
	        });

	        instructionsButton.setBackground(new java.awt.Color(204, 204, 255));
	        instructionsButton.setText("<html><center><b>Instructions</b></center></html>");
	        instructionsButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                instructionsButtonActionPerformed(evt);
	            }
	        });

	        buySaveCardButton.setBackground(new java.awt.Color(153, 255, 153));
	        buySaveCardButton.setText("<html><center><b>Buy Card</b></center></html>");
	        buySaveCardButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                buySaveCardButtonActionPerformed(evt);
	            }
	        });

	        deckButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                deckButtonActionPerformed(evt);
	            }
	        });
      
	        scoreBoardLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
	        scoreBoardLabel.setText("<html><center><b>Score Board</b></center></html>");
	      
	        player1Points.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
	        player1Points.setText("Player 1: ");

	        player2Points.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
	        player2Points.setText("Player 2:");

	        player3Points.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
	        player3Points.setText("Player 3:");

	        player4Points.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
	        player4Points.setText("Player 4: ");
	        
	        cost.setFont(new java.awt.Font("Avenir", 1, 18)); // NOI18N
	        cost.setText("Saving Card Price: ");
	        cost.setBorder(javax.swing.BorderFactory.createCompoundBorder());
	        
	        
	        
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap(33, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(player1Points)
	                    .addComponent(player2Points)
	                    .addComponent(player3Points)
	                    .addComponent(player4Points)
	                    .addComponent(scoreBoardLabel))
	                .addGap(40, 40, 40)
	                .addComponent(deckButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        //.addGap(80, 80, 80)
	                    	.addContainerGap(80, Short.MAX_VALUE)
	                        .addComponent(instructionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(endTurnButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(buySaveCardButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(takeCardButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                .addContainerGap(52, Short.MAX_VALUE))
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(cost)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap(27, Short.MAX_VALUE)
	                .addComponent(cost)
	                .addGap(38, 38, 38)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(scoreBoardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(42, 42, 42)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addComponent(player1Points)
	                                        .addGap(31, 31, 31)
	                                        .addComponent(player2Points)
	                                        .addGap(33, 33, 33)
	                                        .addComponent(player3Points))
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addComponent(endTurnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                        .addGap(18, 18, 18)
	                                        .addComponent(buySaveCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                                .addGap(18, 18, 18)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                    .addComponent(instructionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(player4Points))
	                                .addContainerGap(107, Short.MAX_VALUE))
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(deckButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(takeCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(0, 0, Short.MAX_VALUE))))
	        );

	        pack();
	        
	 }
	 
	 private void resetDeckButtonIcon(String iconFile) {
         URL file = ClassLoader.getSystemClassLoader().getResource(iconFile);
         BufferedImage image=null;
         try {
			  image = ImageIO.read(file);
		   } catch (IOException e) {
			  // TODO Auto-generated catch block
			   //e.printStackTrace();
		}
         ImageIcon icon = new ImageIcon(image);
         deckButton.setIcon(icon);
	 }
	 
	 private void setCostImage() {
         URL file = ClassLoader.getSystemClassLoader().getResource(COST_IMAGE);
         BufferedImage image=null;
         try {
			  image = ImageIO.read(file);
		   } catch (IOException e) {
			  // TODO Auto-generated catch block
			   //e.printStackTrace();
		}
         ImageIcon icon = new ImageIcon(image);
         cost.setIcon(icon);
	 }
	 
	 private void takeCardButtonActionPerformed(ActionEvent evt) {
		    if (game.isOver()) {
		    	return;
		    }
		    CardDeck deck = game.getCardDeck();
		    Player player = game.getCurrentPlayer();
		    if (player.isAlive()) {
			    Card card = deck.drawTopCard();
			    if (card == null) {
			    	resetDeckButtonIcon(EMPTY_DECK_IMAGE);
			    	msgbox(Messages.EMPTY_CARD_DECK);
			    }
			    else if (deck.isTopCardVisible()){
			    	resetDeckButtonIcon(DEFAULT_DECK_IMAGE);
			    	deck.setTopCardVisible(false);
				    card.act(player);
				    refreshScoreBoard();
				    refreshSavingCardCost();
				    if (!player.isAlive()) {
				    	declareDead(MessageFormat.format(Messages.PLAYER_DEAD, player.getName()));
				    	markDead();
				    	endTurnActionInternal(player);
				    }
				    else {
					    card = deck.peekTopCard();
					    if (card == null) {
					    	game.setOver(true);
					    	resetDeckButtonIcon(EMPTY_DECK_IMAGE);
					    	declareWinner(MessageFormat.format(Messages.CARD_DECK_EMPTY, game.getWinner().getName()));
							setVisible(false);
							JFrame window = new EndingPage(game);
							window.setVisible(true);
					    }
				    }
	
			    }
			    else {
			    	msgbox(Messages.DRAW_CARD_FIRST);
			    }	 
		    }
		    else {
		    	declareDead(MessageFormat.format(Messages.PLAYER_DEAD, player.getName()));
		    }
	 }
	 
	 private void endTurnActionInternal(Player player) {
		 if (game.isOver()) {
		    return;
		 }
		 player.resetDrawCount(); 
		 if (!game.updateCurrentPlayerId()) {
			game.setOver(true);
			declareWinner(MessageFormat.format(Messages.PLAYER_WIN, game.getWinner().getName()));
			setVisible(false);
			JFrame window = new EndingPage(game);
			window.setVisible(true);
		 }	
		 else {
		    refreshScoreBoard();
		 }
	 }
	 
	 private void endTurnButtonActionPerformed(ActionEvent evt) {
		 if (game.isOver()) {
			 return;
		 }
		 CardDeck deck = game.getCardDeck();
		 if (deck.isTopCardVisible()) {
		     msgbox(Messages.END_TURN_NOT_ALLOWED); 
		 }
		 else {
			 Player player = game.getCurrentPlayer();
			 if (player.isAlive()) {	 
				 if (player.getDrawCount() == 0)
				 {
					 msgbox(Messages.PLAYER_MUST_DRAW_ONCE);
				 }
				 else {
					 endTurnActionInternal(player);
				 }
			 }
			 else {
				 declareDead(MessageFormat.format(Messages.PLAYER_DEAD, player.getName()));
			 }
		 }
	 }
	 
	 private void instructionsButtonActionPerformed(ActionEvent evt) {
		 Instructions ins =new Instructions(this);
	 }
	 
	 
	 private void buySaveCardButtonActionPerformed(ActionEvent evt) {
		 if (game.isOver()) {
				return;
		 }
		 Player player = game.getCurrentPlayer();
		 if (player.isAlive()) {	 
			 CardDeck deck = game.getCardDeck();
			 if (deck.isTopCardVisible())
			 {
				  msgbox(Messages.NOT_ALLOWD_TO_BUY_CARD);
			 }
			 else {
				 Card card = player.buySaveCard();
				 if (card == null) {
					 msgbox(MessageFormat.format(Messages.NO_ENOUCH_MONDY_TO_BUY_CARD, player.getName()));
				 }
				 else {
					 refreshScoreBoard();
				 }
			 }
		 }
		 else {
			 declareDead(MessageFormat.format(Messages.PLAYER_DEAD, player.getName()));
		 }
	 }
	 
	 private void deckButtonActionPerformed(ActionEvent evt) {
		 if (game.isOver()) {
				return;
		 }
		 CardDeck deck = game.getCardDeck();
		 Player player = game.getCurrentPlayer();
		 if (player.isAlive()) {
			 if (!deck.isTopCardVisible()) {
				boolean result = player.increaseDrawCount();
				if (result) {
				    Card card = deck.peekTopCard();
				    if (card == null) {
				    	//if (game.hasMultiplePlayerWithSamePoints()) {
				    	//	refreshScoreBoardWithTimeInfo();
				    	//}
				    	game.setOver(true);
				    	resetDeckButtonIcon(EMPTY_DECK_IMAGE);
				    	declareWinner(MessageFormat.format(Messages.CARD_DECK_EMPTY, game.getWinner().getName()));
						setVisible(false);
						JFrame window = new EndingPage(game);
						window.setVisible(true);
				    }
				    else {
					   deck.setTopCardVisible(true);
		               resetDeckButtonIcon(card.getImageFile());
				    }
				}
				else {
					msgbox(MessageFormat.format(Messages.YIELD_TO_NEXT_PLAYER, player.getName()));
				}
			 }
			 else {
				 msgbox(MessageFormat.format(Messages.PLAYER_TAKE_CARD, player.getName()));
			 }
		 }
		 else {
			 declareDead(MessageFormat.format(Messages.PLAYER_DEAD, player.getName()));
		 }
	 }
	 
	 
	 private String appendStar(int count) {
		 String text="";
		 for (int i=1; i<=count; i++) {
			 text = text + "*";
		 }
		 return text;
	 }
	 
	 
	 private JLabel getlabel(int playerId) {
		 if (playerId == 0)
			 return player1Points;
		 else if (playerId == 1)
			 return player2Points; 
		 else if (playerId == 2)
			 return player3Points; 
		 else if (playerId == 3)
			 return player4Points;
		 else 
		     return player1Points;
	 }
	 
	 private void markDead() {
		 List<Integer> ds = game.getDeadPlayerIds();
		 for (Integer i: ds) {
			 JLabel label = getlabel(i);
			 label.setBackground(new java.awt.Color(128, 128, 128));
		 }
	 }
	 
	 private void resetOriginal() {
		 int playerId = game.getCurrentPlayerId();
		 List<Integer> ds = game.getDeadPlayerIds();
		 for (int id=0; id<4; id++) {
			 if (id!=playerId && !ds.contains(id)) {
				 JLabel label = getlabel(id);
				 label.setBackground(new java.awt.Color(255, 255, 255));
			 }
		 }
	 }
	 
	 private String displayPlayerInfo(Player player) {
		return player.getName() + ": " 
	           + player.getPoints() + 
	           " "+appendStar(player.getSaveCardCount());
	 }
	 
	 private String displayPlayerInfoWithTime(Player player) {
		return displayPlayerInfo(player) + "["+ player.getTime()+"]";
	 }
	 
	 private void markCurrent(boolean displayTimeInfo) {
	    Player player = game.getCurrentPlayer();	
	    int playerId = game.getCurrentPlayerId();
	    JLabel label= getlabel(playerId);
		label.setBackground(new java.awt.Color(255, 153, 153));
		if (displayTimeInfo) {
		  label.setText(displayPlayerInfoWithTime(player));
		}
		else {
	       label.setText(displayPlayerInfo(player));	 
		}
	 }
	 
	 private void markTied() {
		 ArrayList<Player> players = game.getPlayers();
		 int playerId=0;
		 for (Player player : players) {
			 if (player.isAlive()) {
				 JLabel label= getlabel(playerId);
				 label.setBackground(new java.awt.Color(255, 255, 255));
				 label.setText(displayPlayerInfoWithTime(player));
			 }
		     playerId++;
		 }
	 }
	 
	 private void refreshScoreBoard() {
		markDead();
		resetOriginal();
        markCurrent(false);
	 }
	 
	 private void refreshScoreBoardWithTimeInfo() {
		markDead();
		resetOriginal();
        markTied();
        markCurrent(true);
	 }
	 
	 private void refreshSavingCardCost() {
		 String text = "Saving Card Price: " + String.valueOf(SavingCard.CURRENT_COST);
		 cost.setText(text);
	 }
	 
	 // test 
//	 public static void main(String args[]) {
//		    //String[] names = {"Skyla", "Andria", "Lindsay", "Dave"};
//		    String[] names = {"Skyla", "Andria"};
//		    List<String> playerNames = Arrays.asList(names);	    
//		    
//	        /* Set the Nimbus look and feel */
//	        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//	        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//	         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//	         */
//	        try {
//	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//	                if ("Nimbus".equals(info.getName())) {
//	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//	                    break;
//	                }
//	            }
//	        } catch (ClassNotFoundException ex) {
//	            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//	        } catch (InstantiationException ex) {
//	            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//	        } catch (IllegalAccessException ex) {
//	            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//	            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//	        }
//	        //</editor-fold>
//	        //</editor-fold>
//	        java.awt.EventQueue.invokeLater(new Runnable() {
//	            public void run() {
//	                new MainGame(playerNames).setVisible(true);
//	            }
//	        });
//	 }
	
}