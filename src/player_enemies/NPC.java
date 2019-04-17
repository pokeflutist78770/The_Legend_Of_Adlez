package player_enemies;

/**
 * Class for the OverWorld object type "NPC".
 * @author Tito Vasquez
 *
 */
public class NPC extends OverWorldClass {
	String message;

	/**
	 * Constructs a NPC object and sets the image of it on the overworld map.
	 * @param position int[] The position of the NPC object.
	 */
	public NPC(int[] position) {
		super(position);
		this.setImage(null);
	}

	@Override
	public String getText() {
		return message;
	}
	
	/**
	 * Setter for the message for a particular NPC.
	 * @param message String The message that the NPC will say when they are spoken to.
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}