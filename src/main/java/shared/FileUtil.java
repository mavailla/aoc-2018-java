package shared;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileUtil {

	public static List<String> loadFileinStrings(String fileName) {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();

		File file = new File(classLoader.getResource(fileName).getFile());
		
		//Read File Content
		List<String> lines = null;
		try {
			lines = Files.readAllLines(file.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;
	}
}
