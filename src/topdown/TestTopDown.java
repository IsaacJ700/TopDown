package topdown;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**********************************************************************
 * Class used to test the software program and its functions.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 2.0
 *********************************************************************/
public class TestTopDown {
	
	/**
	 * Create a player and change it's health.
	 * 
	 * @result Player health will be set to 20.
	 */
	@Test
	public void testUserPlayerHealth1() {
		Game g = new Game();
		Handler h = new Handler();
		UserPlayer p = new UserPlayer(100, 300, Type.player, h, g);
		p.setHealth(20);
		assertTrue(p.getHealth() == 20);
	}
	
	/**
	 * Create a player and check it's starting health.
	 * 
	 * @result Player health will be set to 100 with no changes.
	 */
	@Test
	public void testUserPlayerHealth2() {
		Game g = new Game();
		Handler h = new Handler();
		UserPlayer p = new UserPlayer(100, 300, Type.player, h, g);
		assertTrue(p.getHealth() == 100);
	}
	
	/**
	 * Create a player and check starting score.
	 * 
	 * @result Player score will be set to 0 with no changes.
	 */
	@Test
	public void testUserPlayerScore1() {
		Game g = new Game();
		Handler h = new Handler();
		UserPlayer p = new UserPlayer(100, 300, Type.player, h, g);
		assertTrue(UserPlayer.getScore() == 0);
	}
	
	/**
	 * Create a player and check score with changes.
	 * 
	 * @result Player score will be set to 20 with no changes.
	 */
	@Test
	public void testUserPlayerScore2() {
		Game g = new Game();
		Handler h = new Handler();
		UserPlayer p = new UserPlayer(100, 300, Type.player, h, g);
		UserPlayer.setScore(20);
		assertTrue(UserPlayer.getScore() == 20);
	}
	
	/**
	 * Create a player and run the tick function to test user movement.
	 * 
	 * @result Player coordinates will be set to (100,300) with no changes.
	 */
	@Test
	public void testUserPlayerMovement1() {
		Game g = new Game();
		Handler h = new Handler();
		UserPlayer p = new UserPlayer(100, 300, Type.player, h, g);
		p.setPlayerX();
		p.setPlayerY();
		p.tick();
		assertTrue(UserPlayer.getPlayerX() == 100);
		assertTrue(UserPlayer.getPlayerY() == 300);
	}
	
	/**
	 * Create a player and tests the tick function.
	 * Handler is up and UserPlayer Y is greater than zero.
	 * 
	 * @result Player coordinates will be set to (100,10) with changes to 
	 * handler and velocity.
	 */
	@Test
	public void testUserPlayerTick1() {
		Game g = new Game();
		Handler h = new Handler();
		UserPlayer p = new UserPlayer(100, 300, Type.player, h, g);
		
		h.setUp(true);
		p.setY(10);
		p.setPlayerY();
		p.tick();
		assertTrue(h.isUp());
		assertTrue(p.getVelY() == -3);
	}
	
	/**
	 * Create a player and tests the tick function.
	 * Handler is up and UserPlayer Y is less than zero.
	 * 
	 * @result Player coordinates will be set to (100,-10) with changes to 
	 * handler and Y-velocity.
	 */
	@Test
	public void testUserPlayerTick2() {
		Game g = new Game();
		Handler h = new Handler();
		UserPlayer p = new UserPlayer(100, 300, Type.player, h, g);
		
		h.setUp(true);
		p.setY(-10);
		p.setPlayerY();
		p.tick();
		assertTrue(h.isUp());
		assertFalse(p.getVelY() == -3);
	}
	
	/**
	 * Create a player and tests the tick function.
	 * 
	 * Handler is right and UserPlayer Y is less than zero.
	 * 
	 * @result Player coordinates will be set to (100,-10) with changes to 
	 * handler, but no changes to Y-velocity.
	 */
	@Test
	public void testUserPlayerTick3() {
		Game g = new Game();
		Handler h = new Handler();
		UserPlayer p = new UserPlayer(100, 300, Type.player, h, g);
		
		h.setRight(true);
		p.setY(-10);
		p.setPlayerY();
		p.tick();
		assertTrue(h.isRight());
		assertTrue(p.getVelY() == 0);
	}
	
	/**
	 * Create a player and tests the tick function.
	 * Handler is down and UserPlayer Y is less than zero.
	 * 
	 * @result Player coordinates will be set to (100,-10) with changes to 
	 * handler and Y-velocity.
	 */
	@Test
	public void testUserPlayerTick4() {
		Game g = new Game();
		Handler h = new Handler();
		UserPlayer p = new UserPlayer(100, 300, Type.player, h, g);
		
		h.setDown(true);
		p.setY(-10);
		p.setPlayerY();
		p.tick();
		assertTrue(h.isDown());
		assertNotNull(p.getVelY());
	}

}
