package theDeathNotice;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class represents a card.
 * 
 * @author Skyla
 * @version 1
 *
 */
public abstract class Card {
	private String cardID;
	private String imageFile;

	/** 
	 * Makes the card by calling its corresponding image file.
	 * 
	 * @param cardID the unique ID of the card 
	 */
	public Card(String cardID) {
		this.cardID = cardID;
		this.imageFile = "cards/" + cardID + ".png";
	}
	
	/**
	 * Gets the ID of the card.
	 * @return the ID of the card
	 */
	public String getCardID() {
		return cardID;
	}

	/**
	 * Gets the full path of the image file of the card. 
	 * 
	 * @return returns the image file of the card
	 */
	public String getImageFile() {
		return imageFile;
	}

	/** 
	 * Draws the card using the imageFile.
	 * @throws IOException imageFile not found
	 */
	public void drawImage() throws IOException {
		URL u = ClassLoader.getSystemClassLoader().getResource(imageFile);
		loadResourceByUrl(u, imageFile);
	}

    private void loadResourceByUrl (URL u, String resource)  throws IOException {
        System.out.println("-> attempting input resource: "+resource);
        if (u != null) {
            String path = u.getPath();
            path = path.replaceFirst("^/(.:/)", "$1");
            System.out.println("    absolute resource path found :\n    " + path);
            String s = new String(Files.readAllBytes(Paths.get(path)));
        } else {
            System.out.println("    no resource found: " + resource);
        }
    }
	
	@Override
	public String toString() {
		return this.cardID;
	}


	/**
	 * Acts how it would if a player plays the card.
	 * @param player Player that plays the card.
	 */
	public abstract void act(Player player);
	
}
