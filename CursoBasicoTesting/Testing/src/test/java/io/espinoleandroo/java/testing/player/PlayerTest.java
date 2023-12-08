package io.espinoleandroo.java.testing.player;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class PlayerTest {

	@Test
	public void looses_when_dice_number_is_different() {
		Dice dice = Mockito.mock(Dice.class);
		
		Mockito.when(dice.roll()).thenReturn(2);
		
		Player player = new Player(dice, 3);
		assertEquals(false, player.play());
	}
	
	@Test
	public void wins_when_dice_number_is_equals() {
		Dice dice = Mockito.mock(Dice.class);
		
		Mockito.when(dice.roll()).thenReturn(3);
		
		Player player = new Player(dice, 3);
		assertEquals(true, player.play());
	}

}
