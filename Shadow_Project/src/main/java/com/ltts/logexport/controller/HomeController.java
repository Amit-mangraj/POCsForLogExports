package com.ltts.logexport.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ltts.logexport.exception.logException;
import com.ltts.logexport.filestorageservice.FileStorageService;

@Controller
public class HomeController {
	@GetMapping("")
	public String view() {
		return "home";
	}

	@GetMapping("/download")
	public ModelAndView download(HttpServletResponse res) throws Exception {
		ModelAndView mv = null;
		try {
			FileStorageService.storage(res);
			mv = new ModelAndView("home");
		} catch (Exception ex) {
			mv = new ModelAndView("error");
			throw new logException();
		}
		return mv;
	}

}
