package com.ltts1.Shadow.Controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ltts1.Shadow.Zip.ZipFile;

@Controller
public class HomeController {

	@GetMapping("")
	public String view() {

		return "index";
		
	}
	@GetMapping("/download")
	public void download(HttpServletResponse res)throws IOException
	{
		ZipFile.zip_one_file();
		System.out.println("File zipped");
		File file = new File("D:\\log\\spring.zip");
		res.setContentType("application/octet-stream");
		String headerKey ="Content-Disposition";
		String headerValue="attachment;filename="+file.getName();
		res.setHeader(headerKey, headerValue);
		ServletOutputStream outputStream = res.getOutputStream();
		BufferedInputStream inputStream =new BufferedInputStream(new FileInputStream(file));
		byte[] buffer = new byte[8192];
		int bytesRead=-1;
		while((bytesRead=inputStream.read(buffer))!=-1)
		{
			outputStream.write(buffer,0,bytesRead);
			
		}
		inputStream.close();
		outputStream.close();
	}
	
}
