package gameObjects;

import java.awt.Point;

/**
 * Class for the OverWorld object type "NPC".
 * @author Tito Vasquez
 *
 */
public class NPC extends GameObject {
	String message;

	/**
	 * Constructs a NPC object and sets the image of it on the overworld map.
	 * @param position Point The position of the NPC object.
	 */
	public NPC(Point position) {
		super(position);
	}

	/**
	 * Gets the text of the NPC when they are spoken to.
	 * @return message String The message of the NPC.
	 */
	public String getText() {
		return message;
	}
	
	/**
	 * Setter for the message for a particular NPC.
	 * @param message String The message that the NPC will say when they are spoken to.
	 */
	public void setText(String message) {
		this.message = message;
	}
}
