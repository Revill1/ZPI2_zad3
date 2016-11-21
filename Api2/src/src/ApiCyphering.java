package src;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ApiCyphering {
	
	
	public static byte[] encrypt(String strToEncrypt, byte[] key)
    {
		try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            final byte[] encryptedString = cipher.doFinal(strToEncrypt.getBytes());
            return encryptedString;
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(byte[] byteToDecrypt, byte[] key)
    {
      
        return null;
    }


}
