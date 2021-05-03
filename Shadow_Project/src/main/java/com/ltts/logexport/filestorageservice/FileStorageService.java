package com.ltts.logexport.filestorageservice;

public class FileStorageService {
   public static void storage(HttpServletResponse res) throws IOException, Exception
	{
		ConvertToZip.zipFile();
		System.out.println("File zipped");
		File file = new File(Properties.zipFilepath);
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
