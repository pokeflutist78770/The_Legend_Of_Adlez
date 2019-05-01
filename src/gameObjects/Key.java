package gameObjects;
	
import java.awt.Point;
	
public class Key extends Item {
	
		/**
		 * Constructor for Key object.
		 * @param position Point 2D The position on the map.
		 */
		public Key(Point position) {
			super(position);
			this.setImage("assets/key.png");
			name = "key";
		}
	
}
