package gameObjects;
	
import javafx.geometry.Point2D;
	
public class Key extends Item {
	
		/**
		 * Constructor for Key object.
		 * @param position Point 2D The position on the map.
		 */
		public Key(Point2D position) {
			super(position);
			this.setImage("assets/key.png");
			name = "key";
		}
	
}
