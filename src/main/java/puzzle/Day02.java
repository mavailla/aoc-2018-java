package puzzle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import shared.FileUtil;

public class Day02 {

	public static int getChecksum(String fileName) {
		int doubleLettersCount = 0;
		int triplelettersCount = 0;
		
		List<String> ids = FileUtil.loadFileinStrings(fileName);
		for(String id: ids) {
			boolean doubleFound = false;
			boolean tripleFound = false;
			
			while(id.length() > 1) {
				int initialLength = id.length();
				id = id.replace(id.substring(0, 1), "");
				int shorterBy = initialLength - id.length();
				if(shorterBy == 2) doubleFound = true;
				if(shorterBy == 3) tripleFound = true;
			}
			doubleLettersCount += doubleFound ? 1 : 0;
			triplelettersCount += tripleFound ? 1 : 0;
		}
		
		return doubleLettersCount * triplelettersCount;

	}
	
	// The approach I use here is to store multiple masked version of the ID (as many as there are letters in the ID) in
	// a hashset. (e.g.: "abc" will be stored as "#bc", "a#c" and "ab#". If the second ID is "adc", attempting to add "a#c" 
	// will fail, which means "abc" and "adc" only differed by one letter. The common id is the version without "#". 
	public static String getCommonID(String fileName) {
		List<String> ids = FileUtil.loadFileinStrings(fileName);
		Set<String> modifiedIds = new HashSet<String>(); 
		
		for(String id: ids) {
			for(int i = 0; i < id.length(); i++) {
				StringBuilder modifiedId = new StringBuilder(id);
				modifiedId.setCharAt(i, '#');
				if(!modifiedIds.add(modifiedId.toString())) {
					return modifiedId.toString().replaceAll("#", "");
				};
			}
		}
		return null;
	}

}
