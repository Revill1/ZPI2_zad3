package FileLibraryTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import Library.FileLibrary;

public class FileLibraryTests {

	FileLibrary lib = new FileLibrary();
	
	@Test
	public void DownloadFromUrlTest() throws IOException 
	{
		lib.DownloadFileFromRoute("http://mmajchr.kis.p.lodz.pl/zpi2/zadania/3a.txt", "C:/Users/wojciech.pelka/Desktop/3a.txt");
		
		File file = new File("C:/Users/wojciech.pelka/Desktop/3a.txt");
		
		assertTrue(file.exists());
	}
	
	@Test
	public void AddFileToArchiveTest()
	{
		lib.AddFileToArchive("C:/Users/wojciech.pelka/Desktop/TEST.txt", "C:/Users/wojciech.pelka/Desktop/TestZIP.zip");
		
		File archivedFile = new File("C:/Users/wojciech.pelka/Desktop/TestZIP.zip");
		
		assertTrue(archivedFile.exists());
	}
	
	@Test
	public void ExtractFileFromArchiveTest()
	{
		lib.ExtractFileFromArchive("C:/Users/wojciech.pelka/Desktop/TestZIP.zip", "C:/Users/wojciech.pelka/Desktop/TestZIP");
		
		File extractedFile = new File("C:/Users/wojciech.pelka/Desktop/TestZIP");
		
		assertTrue(extractedFile.isDirectory());
		assertTrue(extractedFile.list().length>0);
		
	}

}
