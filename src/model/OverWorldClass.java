package model;
/**
 * Class for all things that would appear on the overworld that are not enemies or the player character.
 * @author Tito Vasquez
 *
 */
public abstract class OverWorldClass {
	String image;

	/**
	 * Constructor for an OverWorld object to differentiate types of blocks.
	 * @param position int[] The current position of the OverWorld object.
	 */
	public OverWorldClass(int[] position) {
	}
	
	/**
	 * Setter for the image of the OverWorld object using its file location.
	 * @param url String The location of the image file.
	 */
	public void setImage(String url) {
		this.image = url;
	}
	
	/**
	 * Getter for the image of a specific OverWorld object.
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * The text that will appear on the screen when the player interacts with an overworld object.
	 * @return String The text for each object.
	 */
	public abstract String getText();
}
