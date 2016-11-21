package Library;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import Http.ApiHttp;
import ZipArchive.ApiZipArchive;

public class FileLibrary 
{
	public File DownloadFileFromRoute(String route, String destinationPath) throws IOException
	{
		ApiHttp api = new ApiHttp(route);
		return api.DowloadFile(destinationPath);
	}
	
	public void AddFileToArchive(String sourceFilePath, String ZipFilePath)
	{
		ApiZipArchive api = new ApiZipArchive();
		Path p = Paths.get(sourceFilePath);
		String fileName = p.getFileName().toString();
		
		api.Zip(ZipFilePath, sourceFilePath , fileName);
	}
	
	public void ExtractFileFromArchive(String zipFile, String outputFolder)
	{
		ApiZipArchive api = new ApiZipArchive();
		api.Unzip(zipFile, outputFolder);
	}
}
