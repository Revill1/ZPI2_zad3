package Http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.MalformedInputException;

public class ApiHttp 
{
	String address;
	
	public ApiHttp(String address)
	{
		this.address = address;
	}
	
	public File DowloadFile(String destinationPath) throws IOException
	{
		int i;
		
		URL url = new URL(address); 
		URLConnection con = url.openConnection();
		File file = new File(destinationPath);
		BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file.getName()));
		
		while((i=bis.read())!=-1)
		{
			bos.write(i);
		}
		
		return null;
	}
}
