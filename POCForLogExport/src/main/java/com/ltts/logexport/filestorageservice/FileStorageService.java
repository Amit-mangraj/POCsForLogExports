package com.ltts.logexport.filestorageservice;
import java.io.BufferedInputStream;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ltts.logexport.exception.LogException;
import com.ltts.logexport.fileproperties.Properties;
import com.ltts.logexport.ziputility.ConvertToZip;
@Component
public class FileStorageService {
	@Autowired
	Properties myProperties;
	
	@Autowired
	private ConvertToZip convertTozip;
	
	public void saveFile(HttpServletResponse res) throws LogException {
		File file = new File(myProperties.getZipFilepath());
		try(BufferedInputStream inputStream =new BufferedInputStream(new FileInputStream(file));)
		{
			convertTozip.zipFolder();
			res.setContentType("application/octet-stream");
			String headerKey ="Content-Disposition";
			String headerValue="attachment;filename="+file.getName();
			res.setHeader(headerKey, headerValue);
			ServletOutputStream outputStream = res.getOutputStream();
		
			byte[] buffer = new byte[8192];
			int bytesRead=-1;
			while((bytesRead=inputStream.read(buffer))!=-1)
			{
				outputStream.write(buffer,0,bytesRead);
				
			}
			outputStream.close();
		}
		catch(Exception e)
		{
			throw new LogException();
		}
	
	

	}

}
