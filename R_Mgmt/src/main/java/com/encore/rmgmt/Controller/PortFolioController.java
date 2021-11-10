package com.encore.rmgmt.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("/portfolio")
@RequestMapping("portfolio/*")
public class PortFolioController {

	@RequestMapping(value="/portfolio/insert", method=RequestMethod.GET)
	public ModelAndView insert(){
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping(value="/portfolio/update", method=RequestMethod.GET)
	public ModelAndView update(){
		ModelAndView mv = new ModelAndView();
		return mv;
	}

}
