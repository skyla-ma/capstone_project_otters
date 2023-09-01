package theDeathNotice;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import theDeathNotice.graphics.AddPlayers;
import theDeathNotice.graphics.EndingPage;
import theDeathNotice.graphics.MainGame;
import theDeathNotice.graphics.StartPage;

/**
 * 
 * This class is the main class. It creates a new StartPage and makes it visible.
 * @author Andria
 * @version 1
 *
 */
public class Main{
	
	/**
	 * The method used to launch the program. It uses Nimbus and launches the StartPage first.
	 * @param args The argument for the program launch, which is null in this case.
	 */
	public static void main(String args[]) {
		JFrame window = new StartPage();

		window.setVisible(true);
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
		} catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

		
	}
}
