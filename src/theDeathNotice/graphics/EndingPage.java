package theDeathNotice.graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//import jay.jaysound.JayLayer;
//import jay.jaysound.JayLayerListener;
import theDeathNotice.CardDeck;
import theDeathNotice.Game;
import theDeathNotice.SavingCard;

/**
 * This class represents the ending page. The sound of applause plays when the window pops up. 
 * Click "play again" to lead to the AddPlayers page and to start a whole new game. 
 * Click "end game" to close the window. 
 * 
 * @author Andria
 * @version 1.0
 */

public class EndingPage extends JFrame {
	private static final String BALLOON_IMAGE = "images/congratulations.png";
	private Game game;
	private JLabel congratsImage;
	private JLabel winnerName;
	private JLabel winnerPoints;
	private JLabel winnerTime;
	private JButton playAgain;
	private JButton endGame;
	


	/**
	 * Sets the "game" field to the parameter passed in. Initializes the JLabel and JButton fields and places them
	 * at their respective places in the JFrame. 
	 * Sets up the JButtons so that playAgain leads to a new AddPlayers page when clicked and endGame closes the window
	 * when clicked.
	 * @param game the completed game with the winning player, including their point value and winning time
	 */
	public EndingPage(Game game) {
		this.game=game;	
		setResizable(false);

		initComponents();
		playSound();

	}
	
	private void initComponents() {		
		    winnerName = new javax.swing.JLabel();
	        winnerPoints = new javax.swing.JLabel();
	        winnerTime = new javax.swing.JLabel();
	        playAgain = new javax.swing.JButton();
	        endGame = new javax.swing.JButton();
	        congratsImage = new javax.swing.JLabel();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        getContentPane().setBackground(new java.awt.Color(255,255,255));

	        //winnerName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
	        setFancyFont(winnerName);
	        winnerName.setText("Name: " + game.getWinner().getName());

	        //winnerPoints.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
	        setFancyFont(winnerPoints);
	        winnerPoints.setText("Points: " + game.getWinner().getPoints());

	        //winnerTime.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
	        setFancyFont(winnerTime);
	        winnerTime.setText("Timestamp: " + game.getWinner().getTime());

	        playAgain.setBackground(new java.awt.Color(255, 145, 255));
	        playAgain.setText("Play Again");
	        playAgain.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                playAgainActionPerformed(evt);
	            }
	        });

	        endGame.setBackground(new java.awt.Color(255, 88, 77));
	        endGame.setText("End Game");
	        endGame.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                endGameActionPerformed(evt);
	            }
	        });

	        setImage();

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap(69, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(winnerName)
	                    .addComponent(winnerPoints)
	                    .addComponent(winnerTime)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(playAgain)
	                        .addGap(87, 87, 87)
	                        .addComponent(endGame))
	                    .addComponent(congratsImage, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(69, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap(28, Short.MAX_VALUE)
	                .addComponent(congratsImage, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(30, 30, 30)
	                .addComponent(winnerName)
	                .addGap(24, 24, 24)
	                .addComponent(winnerPoints)
	                .addGap(27, 27, 27)
	                .addComponent(winnerTime)
	                .addGap(44, 44, 44)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(playAgain)
	                    .addComponent(endGame))
	                .addContainerGap(36, Short.MAX_VALUE))
	        );

	        pack();
	}
	
	private void playAgainActionPerformed(ActionEvent e) {
		//sound.stopSong();
		setVisible(false);
		JFrame window = new AddPlayers();
		window.setVisible(true);
	}
	
	private void endGameActionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
	private void setImage() {
         URL file = ClassLoader.getSystemClassLoader().getResource(BALLOON_IMAGE);
         BufferedImage image=null;
         try {
			  image = ImageIO.read(file);
		   } catch (IOException e) {
			  // TODO Auto-generated catch block
			   e.printStackTrace();
		}
         ImageIcon icon = new ImageIcon(image);
         congratsImage.setIcon(icon);
	 }	
	 

	
	 private void setFancyFont(JLabel label) {
	      String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	      boolean fancyFontExists = false;
	      for(int i=0; i<fonts.length; i++) {
	    	   if(fonts[i]!=null && fonts[i].equals("Mindset")) {
	    		  label.setFont(new java.awt.Font("Mindset", 0, 36));
	    		  fancyFontExists = true;
	    	   }
	      }
	      if (!fancyFontExists) {
	         label.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
	      }
	 }
	
	 private void playSound() {
		    SoundPlayer soundPlayer = new SoundPlayer("audio/applause.mp3");
		    soundPlayer.start();
	 }
	 
//	 //test
//	 public static void main(String args[]) {
//	        /* Set the Nimbus look and feel */
//	        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//	        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//	         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//	         */
//		    String[] names = {"Skyla", "Andria", "Lindsay", "Dave"};
//		    List<String> playerNames = Arrays.asList(names);	
//			 Game game = new Game(playerNames);
//			 CardDeck deck = game.getCardDeck();
//			 deck.shuffleDeck();
//			 deck.shuffleDeck();
//			 deck.shuffleDeck();
//			 SavingCard.init();
//	        try {
//	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//	                if ("Nimbus".equals(info.getName())) {
//	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//	                    break;
//	                }
//	            }
//	        } catch (ClassNotFoundException ex) {
//	            java.util.logging.Logger.getLogger(EndingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//	        } catch (InstantiationException ex) {
//	            java.util.logging.Logger.getLogger(EndingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//	        } catch (IllegalAccessException ex) {
//	            java.util.logging.Logger.getLogger(EndingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//	            java.util.logging.Logger.getLogger(EndingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//	        }
//	        //</editor-fold>
//
//	        /* Create and display the form */
//	        java.awt.EventQueue.invokeLater(new Runnable() {
//	            public void run() {
//	                new EndingPage(game).setVisible(true);
//	            }
//	        });
//	    }
}
