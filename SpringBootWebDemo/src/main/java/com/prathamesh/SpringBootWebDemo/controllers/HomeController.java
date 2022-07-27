package com.prathamesh.SpringBootWebDemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.prathamesh.SpringBootWebDemo.models.Alien;

@Controller
public class HomeController {
	@RequestMapping("home")
	public ModelAndView home(@RequestParam("name") String name) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("name", name);
		return mv;
	}
	
	@RequestMapping("alien")
	public ModelAndView getAlien(Alien alien) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("alien", alien);
		return mv;
	}
}
