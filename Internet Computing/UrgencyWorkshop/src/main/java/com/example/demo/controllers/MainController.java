package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.services.DrugService;
import com.example.demo.services.UserService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private UserService us;
	
	@Autowired
	private DrugService ds;
	
	private void setUp() {
		User u1 = new User("lola", "Mauricio", "Hernández", "lola", Boolean.FALSE);
		User u2 = new User("sara", "Diana", "Hernández", "sara", Boolean.TRUE);
		us.add(u1);
		us.add(u2);
	}

	@PostMapping("/loginDo")
	public String login(Model model, @ModelAttribute User user) {

		User u = us.find(user.getLogin());

		boolean correctLogin = u != null && user.getPassword().equals(u.getPassword());
		if(correctLogin) {
			return "drugDelivery";
		}
		
		return "login";
	}
	
	@GetMapping("drugDelivery")
	public String drugDelivery(Model model) {
		setUp();
		model.addAttribute("patients", us.findAll());
		model.addAttribute("drugs", ds.findAll());
		
		return "drugDelivery";
	}

	@GetMapping("/")
	public ModelAndView main() {
		setUp();
		
		User user = new User();
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", user);
		mav.setViewName("login");
		return mav;
	}
}
