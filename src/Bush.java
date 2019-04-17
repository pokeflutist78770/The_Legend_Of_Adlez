

/**
 * Class for the OverWorld object type "Bush".
 * @author Tito Vasquez
 *
 */
public class Bush extends OverWorldClass {

	/**
	 * Constructs a Bush object and sets the image of it on the overworld map.
	 * @param position int[] The position of the Bush object.
	 */
	public Bush(int[] position) {
		super(position);
		this.setImage(null);
	}

	@Override
	public String getText() {
		return "That's a neat-looking bush.";
	}
}