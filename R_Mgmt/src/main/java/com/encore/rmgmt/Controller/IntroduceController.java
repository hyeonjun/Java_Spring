package com.encore.rmgmt.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("/introduce")
@RequestMapping("introduce/*")
public class IntroduceController {

	@RequestMapping(value="/introduce/write", method=RequestMethod.GET)
	public ModelAndView write(){
		ModelAndView mv = new ModelAndView(); 
		return mv;
	}

}
