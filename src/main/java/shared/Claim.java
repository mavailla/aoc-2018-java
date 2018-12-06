package shared;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Claim {
	private int id;
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Claim(int id, int x, int y, int width, int height) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public Claim(String claimAsString) {
		super();
		String claimPattern= "#(\\d*) @ (\\d*),(\\d*): (\\d*)x(\\d*)";
		Pattern pattern = Pattern.compile(claimPattern);
		Matcher matcher = pattern.matcher(claimAsString);
		
		if (matcher.find()) {
			this.id = Integer.valueOf(matcher.group(1));
			this.x = Integer.valueOf(matcher.group(2));
			this.y = Integer.valueOf(matcher.group(3));
			this.width = Integer.valueOf(matcher.group(4));
			this.height = Integer.valueOf(matcher.group(5));
		} 
	}
	

	public int getId() {
		return id;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Claim [id=" + id + ", x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
	}

	
	
}
