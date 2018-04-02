package myTest;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Stephen Cai on 2017-09-08 17:26.
 */
public class EncodeFileToBase64Binary {
	public static String encodeFileToBase64Binary(String fileName)
			throws IOException {

		File file = new File(fileName);
		byte[] bytes = loadFile(file);
		byte[] encoded = Base64.encodeBase64(bytes);
		String encodedString = new String(encoded);

		return encodedString;
	}
	public static byte[] loadFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);

		long length = file.length();
		if (length > Integer.MAX_VALUE) {
			// File is too large
		}
		byte[] bytes = new byte[(int)length];

		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
			offset += numRead;
		}

		if (offset < bytes.length) {
			throw new IOException("Could not completely read file "+file.getName());
		}

		is.close();
		return bytes;
	}

	public static void main(String[] args) throws IOException {
		String res = encodeFileToBase64Binary("/Users/caifeng/Documents/Piaoniu/兜礼/证书/piaoniu.p12");
		System.out.println(res);
		System.out.println("--------");
		String res1 = encodeFileToBase64Binary("/Users/caifeng/Documents/Piaoniu/兜礼/证书/piaoniu.truststore");
		System.out.println(res1);
	}
}
