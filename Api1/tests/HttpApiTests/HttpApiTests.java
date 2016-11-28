package HttpApiTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import Library.FileLibrary;

public class HttpApiTests {

	@Test
	public void DownloadFromUriTest() throws IOException 
	{
		FileLibrary lib = new FileLibrary();
		lib.DownloadFileFromRoute("http://mmajchr.kis.p.lodz.pl/zpi2/zadania/3a.txt", "C:/Users/Wojciech/Desktop/3a.txt");
		
		File file = new File("C:/Users/Wojciech/Desktop/3a.txt");
		
		assertTrue(file.exists());
	}

}
