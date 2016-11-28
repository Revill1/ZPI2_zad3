package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ApiChecksum {

	public static String createSum(String input, String algorithm)
			throws NoSuchAlgorithmException {

		MessageDigest mDigest = MessageDigest.getInstance(algorithm);
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		return sb.toString();
	}

	public static boolean testChecksum(String file, String testChecksum,
			String algorithm) throws NoSuchAlgorithmException, IOException {
		MessageDigest mDigest = MessageDigest.getInstance(algorithm);
		FileInputStream input = new FileInputStream(file);

		byte[] data = new byte[1024];
		int read = 0;
		while ((read = input.read(data)) != -1) {
			mDigest.update(data, 0, read);
		}
		;
		byte[] hashBytes = mDigest.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < hashBytes.length; i++) {
			sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		String fileHash = sb.toString();

		return fileHash.equals(testChecksum);

	}
}
