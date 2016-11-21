package ZipArchive;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ApiZipArchive 
{
	public void Zip(String zipFilePath, String targetFilePath, String fileToZipName)
	{
		byte[] buffer = new byte[1024];

    	try{

    		FileOutputStream fos = new FileOutputStream(zipFilePath);
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		ZipEntry ze= new ZipEntry(fileToZipName);
    		zos.putNextEntry(ze);
    		FileInputStream in = new FileInputStream(targetFilePath);

    		int len;
    		while ((len = in.read(buffer)) > 0) {
    			zos.write(buffer, 0, len);
    		}

    		in.close();
    		zos.closeEntry();

    		zos.close();

    		System.out.println("Done");

    	}catch(IOException ex){
    	   ex.printStackTrace();
    	}
	}
}
