package com.prathamesh.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest req, HttpServletResponse res) {
		int a = Integer.parseInt(req.getParameter("a"));
		int b = Integer.parseInt(req.getParameter("b"));
		int k = a+b;
		
		ModelAndView mv = new ModelAndView("display");
		mv.addObject("result", k);
		return mv;
	}
	
	@RequestMapping("/sub")
	public ModelAndView sub(@RequestParam("a") int a,  @RequestParam("b") int b) {
		int k = a-b;
		
		ModelAndView mv = new ModelAndView("substract");
		mv.addObject("result", k);
		return mv;
	}
	
	
	
}
