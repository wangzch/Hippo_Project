package com.hippo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("main") 
	public String getEmployee() {
        return "main";  
	}
	
	@RequestMapping("tableExample") 
	public String tableExample() {
        return "tableExample";  
	}
	
	@RequestMapping("modalJuZhong") 
	public String modalJuZhong() {
        return "modalJuZhong";  
	}
}
