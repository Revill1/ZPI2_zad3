package src;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SumKontrol {

	public static String createSum(String input, String algorithm) throws NoSuchAlgorithmException {
       
		 MessageDigest mDigest = MessageDigest.getInstance(algorithm);
	        byte[] result = mDigest.digest(input.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < result.length; i++) {
	            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
	        }
	         
	        return sb.toString();
    }
	
	 public static boolean testChecksum(String file, String testChecksum) 
	    {
			return false;
	        
	    }
}
