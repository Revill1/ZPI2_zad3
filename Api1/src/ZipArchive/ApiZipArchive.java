package ZipArchive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
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
	
	public void Unzip(String zipFile, String outputFolder)
	{
		byte[] buffer = new byte[1024];

	     try{

	    	File folder = new File(outputFolder);
	    	if(!folder.exists()){
	    		folder.mkdir();
	    	}

	    	ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
	    	
	    	ZipEntry ze = zis.getNextEntry();

	    	while(ze!=null){

	    	   String fileName = ze.getName();
	           File newFile = new File(outputFolder + File.separator + fileName);

	           System.out.println("file unzip : "+ newFile.getAbsoluteFile());

	            //create all non exists folders
	            //else you will hit FileNotFoundException for compressed folder
	            new File(newFile.getParent()).mkdirs();

	            FileOutputStream fos = new FileOutputStream(newFile);

	            int len;
	            while ((len = zis.read(buffer)) > 0) {
	       		fos.write(buffer, 0, len);
	            }

	            fos.close();
	            ze = zis.getNextEntry();
	    	}

	        zis.closeEntry();
	    	zis.close();

	    	System.out.println("Done");

	    }catch(IOException ex){
	       ex.printStackTrace();
	    }
	}
}
