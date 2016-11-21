package Library;

import java.io.File;
import java.io.IOException;

import Http.ApiHttp;

public class FileLibrary 
{
	public File DownloadFileFromRoute(String route, String destinationPath) throws IOException
	{
		ApiHttp api = new ApiHttp(route);
		return api.DowloadFile(destinationPath);
	}
}
