package puzzle;

import static org.junit.Assert.assertEquals;
import static puzzle.Day02.*;

import org.junit.Test;


public class Day02Test {

	@Test
	public void testChecksum() {
	
		// part 1
		assertEquals(12, getChecksum("day02-test.txt"));
		assertEquals(5727, getChecksum("day02.txt"));		
		// part 2
		assertEquals("fgij", getCommonID("day02-test-pt2.txt"));
		assertEquals("uwfmdjxyxlbgnrotcfpvswaqh", getCommonID("day02.txt"));
	}
}

