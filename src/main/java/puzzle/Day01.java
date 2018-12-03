package puzzle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import shared.FileUtil;

public class Day01 {

	public static int calibrateFrequency(String fileName) {
		int frequency = 0;
		List<String> lines = FileUtil.loadFileinStrings(fileName);
		
		for(String adjustment: lines) {
			
			frequency += Integer.parseInt(adjustment);
		}
		return frequency;
	}

	public static int calibrateFrequencyUntilValueSeenTwice(String fileName) {
		List<String> adjustments = FileUtil.loadFileinStrings(fileName);
		
		int frequency = 0;
		int i = 0;
		Set<Integer> frequencies = new HashSet<Integer>(); 
		
		for(;;) {
			frequency += Integer.parseInt(adjustments.get(i));

			if(frequencies.add(frequency) == false) return frequency;

			if(i++ == adjustments.size()-1) i = 0;   // return to start of file if we reached end.
		}
	}

}
