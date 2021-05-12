package com.ltts.logexport.controller;
import java.io.File;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.ltts.logexport.exception.*;
import com.ltts.logexport.fileproperties.Properties;
import com.ltts.logexport.filestorageservice.FileStorageService;

@Controller
public class HomeController {
	@Autowired 
	private FileStorageService fileStorage;
	
	@Autowired
	Properties myProperties;

	@GetMapping("")
	public String view() {

		return "home";
		
	}
	@GetMapping("/download")
	public void download(HttpServletResponse res)throws Exception
	{
 
		try
		{
			fileStorage.saveFile(res);
			File file = new File(myProperties.getZipFilepath());
			
			//After downloading file to localhost zipped file to be deleted from the remote server
			file.delete();
		}
		catch(Exception ex)
		{
			throw new logException();
		}
	}

}
