package puzzle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static puzzle.Day01.*;

import org.junit.Test;


public class Day01Test {

	@Test
	public void testIsPassphraseValid() {
	
		// part 1
		assertEquals(543, calibrateFrequency("day01.txt"));
		
		// part 2
		assertEquals(2, calibrateFrequencyUntilValueSeenTwice("day01-a.txt"));
		assertEquals(621, calibrateFrequencyUntilValueSeenTwice("day01.txt"));
	}


}
