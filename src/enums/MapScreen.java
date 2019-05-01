package enums;

import java.io.Serializable;

/**
 * MapScreen enum. To tell what map we are on.
 * @author Tito Vasquez
 *
 */
public enum MapScreen implements Serializable{
	HOME, HOME_OUTSIDE, HOME_UP, DESERT, RIVER, SHOP, MOUNTAIN, DUNGEON1, DUNGEON2, DUNGEON3;

	public String getMusic() {
		if(this.toString().startsWith("HOME")) {
			return "home";
		}
		else if(this.toString().equals("RIVER")) {
			return "home";
		}
		else if(this.toString().equals("DESERT")) {
			return "desert";
		}
		
		else if(this.toString().equals("MOUNTAIN")) {
			return "mountain";
		}
		else if(this.toString().startsWith("DUNGEON")) {
			return "dungeon";
		}
		else if(this.toString().equals("SHOP")) {
			return "shop";
		}
		
		return "";
	}
}