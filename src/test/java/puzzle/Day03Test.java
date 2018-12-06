package puzzle;

import static org.junit.Assert.assertEquals;
import static puzzle.Day03.*;

import org.junit.Test;


public class Day03Test {

	@Test
	public void testChecksum() {
	
		// part 1
		assertEquals(4, getClaimsOverlapSize("day03-test.txt"));
		assertEquals(98005, getClaimsOverlapSize("day03.txt"));
		// part 2
		assertEquals(3,findNonOverlappingClaim("day03-test.txt"));
		assertEquals(331,findNonOverlappingClaim("day03.txt"));
	}
}

