package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import enums.Attack;
import enums.Direction;
import enums.MapScreen;
import gameObjects.*;

class TestGameObjects {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testEnemies() {
		Point pt = new Point(0, 0);
		Enemy enemy = new Enemy(new Point(0,0), 0);
		enemy.setMovementPattern(4);
		enemy.setMovementPattern(3);
		enemy.setMovementPattern(2);
		enemy.setMovementPattern(1);
		enemy.getMovementPattern();
		enemy.setMoneyDrop(10);
		enemy.setAttackSound("test");
		assertEquals(Direction.EAST, enemy.getNextMove());
		assertEquals(10, enemy.getMoneyDrop(1));
		assertEquals("test", enemy.getAttackSound());
		assertFalse(enemy.hasDropped());
		enemy.setDropped(true);
		assertTrue(enemy.hasDropped());
		
		enemy = new Slime(pt, 0);
		enemy = new Scorpion(pt, 0);
		enemy = new Poe(pt, 0);
		enemy = new FinalBoss(pt, 0);		
	}
	
	@Test
	void testPlayer() {
		Point pt = new Point(0,0);
		Player player = new Player(pt);
		Sword item = new Sword(pt);
		player.setEquippedItem(item);
		assertEquals(item, player.getEquippedItem());
		player.setCurrentMoney(50);
		assertEquals(50,player.getCurrentMoney());
		player.addInventory(item);
		player.setInventory(player.getInventory());
		player.upPotionCount();
		player.usePotion();
		player.incrementMoney(50);
		assertEquals(100, player.getCurrentMoney());
		assertFalse(player.hasKey());
		player.giveKey();
		assertTrue(player.hasKey());
	}

	@Test
	void testCreatures() {
		Point pt = new Point(0,0);
		Creature test = new Creature(pt);
		test = new Creature(25,50,10,pt);
		assertEquals(Direction.SOUTH, test.getDirection());
		test.setDirection(Direction.NORTH);
		assertEquals(Direction.NORTH, test.getDirection());
		assertEquals(25, test.getCurrentHP());
		assertEquals(50, test.getTotalHP());
		assertEquals(10, test.getAttack());
		test.decrementHP(10);
		assertEquals(15, test.getCurrentHP());
		test.decrementHP(20);
		test.incrementHP(20);
		assertEquals(20, test.getCurrentHP());
	}

	@Test
	void testItems() {
		Point pt = new Point(0,0);
		Player plyr = new Player(pt);
		
		SmallPotion smlPot = new SmallPotion(pt);
		BigPotion bgPot = new BigPotion(pt);
		assertFalse(smlPot.use(plyr));
		assertFalse(bgPot.use(plyr));
		plyr.decrementHP(5);
		assertTrue(smlPot.use(plyr));
		plyr.decrementHP(5);
		assertTrue(bgPot.use(plyr));
		
		Dagger dgr = new Dagger(pt);
		Sword swrd = new Sword(pt);
		assertEquals(1, dgr.getDamage());
		assertEquals(Attack.JAB, dgr.getAttackType());
		assertEquals(5, swrd.getCost());
		assertEquals("sword", swrd.getName());		
		
		SmallMoney smlMny = new SmallMoney(pt);
		MediumMoney medMny = new MediumMoney(pt);
		LargeMoney lrgMny = new LargeMoney(pt);
		assertEquals(3, smlMny.getAmount());
		smlMny.setIndex(10);
		assertEquals(10, smlMny.getIndex());
		
		Door dr = new Door(pt);
		Key key = new Key(pt);
		key.setIndex(5);
		assertEquals(5, key.getIndex());
		
		ShopKeeper shpKpr = new ShopKeeper(pt);
	}

	@Test
	void testGameObjects() {
		Point pt = new Point(0, 0);
		
		ShopItem shpItm1 = new ShopItem(pt, 1);
		ShopItem shpItm2 = new ShopItem(pt, 2);
		ShopItem shpItm3 = new ShopItem(pt, 3);
		ShopItem shpItm4 = new ShopItem(pt, 4);
		assertEquals(3, shpItm3.getItemNum());
		
		NPC npc = new NPC(pt);
		npc.setText("test");
		assertEquals("test", npc.getText());
		
		Point pt2 = new Point(1,1);
		Transition trn = new Transition(pt, MapScreen.HOME ,pt2);
		assertEquals(MapScreen.HOME, trn.getMap());
		assertEquals(pt2, trn.getSpawn());
		
		GameObject object = new GameObject(pt, "test");
		object.setPosition(pt2);
		object.setImage("test1");
		assertEquals("test1", object.getImage());
		assertEquals(pt2, object.getPosition());
		object.setActive(false);
		assertFalse(object.getActive());
	}
}
