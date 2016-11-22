package tests;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.junit.Before;
import org.junit.Test;

import src.ApiChecksum;



public class TestApiChecksum {

	private String input;
	private String algorithm;
	private String algorithm2;
	private String compareSum;

	@Before
	public void init()
	{
		input = "testowy ciag znakow";
		algorithm = "MD5";
		algorithm2 = "SHA";
		compareSum = "ff0b87f35443325263d5032b303eea18";
	}
	
	@Test
	public void generateChecksumTest()
	{
		try {
			String afterSum = ApiChecksum.createSum(input, algorithm);
			assertEquals(compareSum, afterSum);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
