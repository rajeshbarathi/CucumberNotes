package helper;

import java.io.IOException;

public class FileReaderManager {
	
	private static ConfigurationReader cr;
	
	private FileReaderManager() {
	}

	public static FileReaderManager getInstance() {

		FileReaderManager frm = new FileReaderManager();
		return frm;
	}
	
	public ConfigurationReader getCrInstance() throws IOException {
		 cr = new ConfigurationReader();
		 return cr;
	}
}
