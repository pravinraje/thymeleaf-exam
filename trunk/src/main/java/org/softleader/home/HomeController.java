package org.softleader.home;

import org.softleader.user.UserDto;
import org.softleader.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	UserService service;

	@RequestMapping("/")
	String index() {
		return "index";
	}

	@RequestMapping("/signin")
	String signin(@RequestParam String username, Model model) {
		UserDto user = service.getByUserName(username);
		if (user != null) {
			return "redirect:/users";
		} else {
			model.addAttribute("error", "The username is invalid.");
			return "index";
		}
	}
}
