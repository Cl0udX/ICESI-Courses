package com.example.demo;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
	
	private UserRepository ur;

	@GetMapping("/add")
	public ModelAndView add() {		
		return new ModelAndView();
	}

	@GetMapping("/edit")
	public ModelAndView edit() {
		return new ModelAndView();
	}

	@GetMapping("/delete")
	public ModelAndView delete() {
		return new ModelAndView();
	}

	@GetMapping("/list")
	public ModelAndView list() {
		ur.save(new User());
		Iterator<User> i = ur.findAll().iterator();
		List<User> list = new ArrayList<>();
		while(i.hasNext()) {
			list.add(i.next());
		}
		
		System.out.println(list.size());
		
		return new ModelAndView("list.html", "users", list);
	}

}
