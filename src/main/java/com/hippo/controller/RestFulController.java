package com.hippo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class RestFulController {
	@RequestMapping(method=RequestMethod.GET, value="Rest/{id}") 
	public String getEmployee(@PathVariable String id) {
		System.out.println("----------------------"+id);
        return "1";  
	}
}
