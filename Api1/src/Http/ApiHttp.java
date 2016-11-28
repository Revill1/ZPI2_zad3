package Http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
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
		URL url = new URL(address);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(destinationPath);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        
        fis.close();
        bis.close();
        
        return null;
	}
}
