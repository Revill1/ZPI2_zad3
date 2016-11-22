package tests;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import src.ApiCyphering;

public class testApiCyphering {

	private String encryptString;
	private byte[] key;
	private SecretKey secret;
	private SecretKey tmp;
	private byte[] rawKeys;
	private String algorythmType;
	private String compare;
	
	@Before
	public void init()
	{
		try {
			KeyGenerator kGen = KeyGenerator.getInstance("AES");
			kGen.init(128);
			SecretKey sKey = kGen.generateKey();
			rawKeys = sKey.getEncoded();
			encryptString = "string do szyfrowania";
			algorythmType = "AES";
			compare = "[B@15975490";
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void encriptTest()
	{
		byte[] afterEncrypt = ApiCyphering.encrypt(encryptString, rawKeys, algorythmType);
		System.out.println(afterEncrypt.toString());
		assertEquals(compare, afterEncrypt.toString());
	}
}
