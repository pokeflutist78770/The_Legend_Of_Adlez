package gameObjects;
	
import java.awt.Point;
	
public class Key extends Item {
		private int index;
	
		/**
		 * Constructor for Key object.
		 * @param position Point 2D The position on the map.
		 */
		public Key(Point position) {
			super(position);
			this.setImage("assets/key.png");
			name = "key";
		}

		/**
		 * @return the index
		 */
		public int getIndex() {
			return index;
		}

		/**
		 * @param index the index to set
		 */
		public void setIndex(int index) {
			this.index = index;
		}
	
}
