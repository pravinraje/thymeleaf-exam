package org.softleader.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping("/users")
	String getUserPage(Model model) {
		model.addAttribute("users", service.findAll());
		return "list";
	}
}
