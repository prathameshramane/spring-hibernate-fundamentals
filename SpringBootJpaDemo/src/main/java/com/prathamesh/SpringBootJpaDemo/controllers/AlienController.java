package com.prathamesh.SpringBootJpaDemo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.prathamesh.SpringBootJpaDemo.models.Alien;
import com.prathamesh.SpringBootJpaDemo.repositories.AlienRepository;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepository alienRepo;
	
	@RequestMapping("home")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("addAlien")
	public String addAlien(Alien alien) {
		alienRepo.save(alien);
		return "success.jsp";
	}
	

	@RequestMapping("getAlien")
	public ModelAndView addAlien(@RequestParam("id") int id) {
		Alien a = alienRepo.findById(id).orElse(new Alien());
		ModelAndView mv = new ModelAndView("getAlien.jsp");
		
		System.out.println(alienRepo.findByAname("Prathamesh").toString());
		System.out.println(alienRepo.findByAidGreaterThan(192).toString());
		System.out.println(alienRepo.findByAnameSortById("Prathamesh").toString());
		
		mv.addObject("alien", a);
		return mv;
	}
	
	@GetMapping("aliens")
	public List<Alien> findAll() {
		return alienRepo.findAll();
	}
	

	@PostMapping(value="aliens")
	public Alien addNewAlien(@RequestBody Alien a) {
		System.out.println("Running");
		System.out.println(a);
		alienRepo.save(a);
		return a;
	}
}
