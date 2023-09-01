package theDeathNotice.graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import javazoom.jl.decoder.JavaLayerException;


/**
 * 
 * This class represents the window or page for adding players.
 * In this class, you save 2-4 player names. Once you are finished 
 * saving names, click "Done". 
 * 
 * @author Andria
 * @version 2
 */
public class AddPlayers extends JFrame {
	private static final String ABOUT_IMAGE = "images/about.png";
	
	private JButton doneButton;
	private JButton saveButton;
    private JEditorPane typeName;
    private JLabel addPlayers;
    private JLabel enterName;
    private JScrollPane addName;
    private ArrayList<String> players;
    private JLabel instructions;
    private JButton help;
	
    /**
     * Initializes the page, the buttons, the scrollpanes, and the labels and puts them at their respective places.
     */
	public AddPlayers() {
		super("Add Players");
		initComponents();
		players = new ArrayList<String>();
		setVisible(true);
		setResizable(false);
			
	}

	private void initComponents() {
		addName = new JScrollPane();
        typeName = new JEditorPane();
        doneButton = new JButton();
        addPlayers = new JLabel();
        enterName = new JLabel();
        saveButton = new JButton();
        instructions = new JLabel();
        help = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addName.setViewportView(typeName);

        
        doneButton.setBackground(new java.awt.Color(255, 145, 255));
        doneButton.setText("Done");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        addPlayers.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        addPlayers.setText("<html><center><b>Add Players</b><center></html>");

        enterName.setText("Enter Player Name:");

        saveButton.setBackground(new java.awt.Color(255, 88, 77));
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        
        help.setBackground(new java.awt.Color(204, 204, 255));
        help.setText("Help");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpActionPerformed(evt);
            }
        });
        
        
        instructions.setText("<html><left><b>Please click \"Help\" for instructions!</b><left></html>");
        setImage();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addPlayers)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enterName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(saveButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doneButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(help, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(instructions, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(instructions, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(help)
                .addGap(7, 7, 7)
                .addComponent(addPlayers)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(enterName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addName, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doneButton)
                    .addComponent(saveButton))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
	}
	
	 
	 private void playSound() {
		    SoundPlayer soundPlayer = new SoundPlayer("audio/errorSound.mp3");
		    soundPlayer.start();
    }
	 

	private void saveButtonActionPerformed(ActionEvent e) {
		if (players.size() >= 4) {
			playSound();
			
			JOptionPane.showMessageDialog(this, "There can only be a maximum of 4 players. The player was not added.");
			return;
		}
		if (typeName.getText().equals("")) {
			playSound();
			JOptionPane.showMessageDialog(this, "Please type the player's name into the textbox.");
			return;
		} 
		if(Character.isWhitespace(typeName.getText().charAt(0))){
			playSound();
			JOptionPane.showMessageDialog(this, "Player name's first character may not be a space.");
			return;
		}
		int len = typeName.getText().length();
		if (len > 15) {
            playSound();
			JOptionPane.showMessageDialog(this, "Player name can not exceed 15 characters.");
			return;		
		}
		for (int i=0; i<len; i++) {
			if (Character.isLetterOrDigit(typeName.getText().charAt(i)) == false && Character.isWhitespace(typeName.getText().charAt(i)) == false) {
                playSound();
				JOptionPane.showMessageDialog(this, "Player name can only contain alphabetic, digit, or whitespace character.");
				return;
			}
		}
		
		boolean duplicate = false;
		for (String s : players) {
			if (s.equals(typeName.getText())) {
				duplicate = true;
			}
		}
		if (duplicate) {
	        playSound();
			
			typeName.setText("");
			JOptionPane.showMessageDialog(this, "This player has already been registered.");
			return;
		}
		players.add(typeName.getText());
		typeName.setText("");
	}
	
	private void doneButtonActionPerformed(ActionEvent e) {
		if (players.size() > 4) {
			playSound();
			JOptionPane.showMessageDialog(this, "You have too many players. The maximum number of players allowed is 4. Please exit the game and try again.");
		} else if (players.size() < 2) {
			playSound();
			JOptionPane.showMessageDialog(this, "You need at least 2 players to play. Please add more players.");
		} else {
			setVisible(false);
			JFrame window = new MainGame(players);
			window.setVisible(true);
		}
	}
	
	
	private void HelpActionPerformed(ActionEvent e) {
		String text = "<html><left>Click \"save\" after typing each player's name into the text field. <br>"
        		+ "Click \"done\" when you have typed and saved all of the players' names.<br> "
				+ "Player names must be at least 1 character, no longer than 15 characters<br> "
				+ "and can only consist of alphabetical characters, numerical characters, or spaces. <br>"
				+ "The first character, however, can't be a space. No duplicate names are allowed.<br>"
        		+ "Note that this program only supports 2-4 players.<left></html>";
		   JOptionPane.showMessageDialog(this,
				    text,
				    "Please Read Player Name Instructions Carefully",
				    JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	private void setImage() {
        URL file = ClassLoader.getSystemClassLoader().getResource(ABOUT_IMAGE);
        BufferedImage image=null;
        try {
			  image = ImageIO.read(file);
		   } catch (IOException e) {
			  // TODO Auto-generated catch block
			   e.printStackTrace();
		}
        ImageIcon icon = new ImageIcon(image);
        instructions.setIcon(icon);
	 }	

	
}