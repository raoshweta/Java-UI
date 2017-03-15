package com.donate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test2 {

	 @RequestMapping(value = "/best")
	    public String index(){
	        System.out.println("Home Page");
	        return "b";
	    }
}
