package myTest;

/**
 * Created by Stephen Cai on 2017-08-25 13:38.
 */
public class FileIO {
	private static volatile FileIO fileIO;
	private FileIO() {}
	public static FileIO getInstance() {
		if (fileIO == null) {
			synchronized (FileIO.class) {
				if (fileIO == null) {
					fileIO = new FileIO();
				}
			}
		}
		return fileIO;
	}
}
