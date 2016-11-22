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
	private byte[] toDecrypt;
	
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
			toDecrypt = ApiCyphering.encrypt(encryptString, rawKeys, algorythmType);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void encriptTest()
	{
		byte[] afterEncrypts = ApiCyphering.encrypt(encryptString, rawKeys, algorythmType);
		assertEquals(compare, afterEncrypts.toString());
	}
	
	@Test
	public void dencriptTest()
	{
		String afterDecrypt = ApiCyphering.decrypt(toDecrypt, rawKeys, algorythmType);
		assertEquals(encryptString, afterDecrypt);
	}
}
