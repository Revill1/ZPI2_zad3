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
	private String algorithmSHA;
	private String compareSum;
	private Object compareSumSHA;

	@Before
	public void init()
	{
		input = "testowy ciag znakow";
		algorithm = "MD5";
		algorithmSHA = "SHA";
		compareSum = "ff0b87f35443325263d5032b303eea18";
		compareSumSHA = "ad68a0cd4a653a34c23eb9818401879a89bf8fb0";
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
	
	@Test
	public void generateChecksumWithSHATest()
	{
		try {
			String afterSum = ApiChecksum.createSum(input, algorithmSHA);
			assertEquals(compareSumSHA, afterSum);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
