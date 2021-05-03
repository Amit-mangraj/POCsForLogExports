package com.ltts.logexport.ziputility;

public class ConvertToZip {
  public static void zipFile() throws IOException, Exception {
    	byte[] buffer = new byte[1024];
    	try{
    	FileOutputStream fileObject = new FileOutputStream(Properties.zipFilepath);
        ZipOutputStream zipObject = new ZipOutputStream(fileObject);
    	ZipEntry ze= new ZipEntry(Properties.logFileName);
    	zipObject.putNextEntry(ze);
    	FileInputStream in = new FileInputStream(Properties.logFilepath);
    	System.out.println("input stream "  + in);
    	int len;
    	while ((len = in.read(buffer)) > 0) {
    		zipObject.write(buffer, 0, len);
    	}
    	in.close();
    	zipObject.closeEntry();
    	zipObject.close();
    	}catch(Exception ex){
    		throw new logException();
    	}
	}
}
