package puzzle;

import java.util.ArrayList;
import java.util.List;

import shared.Claim;
import shared.FileUtil;

public class Day03 {
	
	public static int getClaimsOverlapSize(String fileName) {
		List<String> claims = FileUtil.loadFileinStrings(fileName);
		
		int[][] fabric = new int[1000][1000];
		
		for(String claimAsString: claims) {
			Claim claim = new Claim(claimAsString);
		
			for(int i = claim.getX(); i< claim.getX() + claim.getWidth(); i++) {
				for(int j = claim.getY(); j< claim.getY() + claim.getHeight(); j++) {
					fabric[i][j] = fabric[i][j] + 1;
				}
			}
		}
		
		int overlapSize = 0;
		for(int i = 0; i < fabric.length; i++) {
			for(int j = 0; j < fabric[i].length; j++) {
				if(fabric[i][j] > 1) overlapSize++;
			}
		}
		
		return overlapSize;
	}
	
	
	private static boolean claimsOverlap(Claim c1, Claim c2) {
		Claim leftMost = c1.getX() < c2.getX() ? c1 : c2;
		Claim rightMost = leftMost == c1 ? c2 : c1;
		Claim topMost = c1.getY() < c2.getY() ? c1 : c2;
		Claim bottomMost = topMost == c1 ? c2 : c1;
		
		return rightMost.getX() >= leftMost.getX() && rightMost.getX() <= (leftMost.getX() + leftMost.getWidth() -1)
				&& bottomMost.getY() >= topMost.getY() && bottomMost.getY() <= (topMost.getY() + topMost.getHeight() -1);
	}
	
	public static int findNonOverlappingClaim(String fileName){
		List<String> claimsStr = FileUtil.loadFileinStrings(fileName);
		List<Claim> claims = new ArrayList<Claim>();
		
		for(String claimStr: claimsStr) {
			claims.add(new Claim(claimStr));
		}
				
		for(int i = 0; i < claims.size(); i++) {
			boolean overlaps = false;
			
			nextclaim:
			for(int j = 0; j < claims.size(); j++) {
				if(i != j) {
					if(claimsOverlap(claims.get(i), claims.get(j))){
						overlaps = true;
						break nextclaim;
					}
				}
			}
			if(overlaps == false){
				return claims.get(i).getId();
			}
		}
		return 0;
	}
	
}
