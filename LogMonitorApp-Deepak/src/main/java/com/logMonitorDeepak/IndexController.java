package com.logMonitorDeepak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"indexForm"})
public class IndexController {
	
	@Autowired
	private Manager manager;

    @RequestMapping("/dashboard")  
    public ModelAndView index() {
    	ModelAndView modelAndView = new ModelAndView();
    	IndexForm indexForm = new IndexForm();
    	modelAndView.setViewName("dashboard");
    	modelAndView.addObject("indexForm", indexForm);
		return modelAndView;  
    }
    
    @RequestMapping(value = "/processLog")//,method = RequestMethod.POST 
	public String result(@ModelAttribute("indexForm") IndexForm indexForm) {
		System.out.println("Entering /result");
		System.out.println("log url::"+indexForm.getLogUrl()); 
		try {
			indexForm.setInvalidPath("false");
			 manager.processLogs(indexForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "dashboard"; 
	}

}
