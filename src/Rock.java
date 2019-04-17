/**
 * Class for the OverWorld object type "Rock".
 * @author Tito Vasquez
 *
 */
public class Rock extends OverWorldClass {

	/**
	 * Constructs a Rock object and sets the image of it on the overworld map.
	 * @param position int[] The position of the Rock object.
	 */
	public Rock(int[] position) {
		super(position);
		this.setImage(null);
	}

	@Override
	public String getText() {
		return "The pioneers used to ride these babies for miles.";
	}
}
