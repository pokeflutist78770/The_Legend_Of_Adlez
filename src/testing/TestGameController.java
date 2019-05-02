package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import controller.GameController;
import enums.MapScreen;

class TestGameController {
	GameController ctrl;
	Point pt;
	@Test
	void test() {
		pt = new Point(5,5);
		ctrl = new GameController();
		for(MapScreen screen : MapScreen.values())
			ctrl.loadMap(screen, pt);
		
		
	}

}
