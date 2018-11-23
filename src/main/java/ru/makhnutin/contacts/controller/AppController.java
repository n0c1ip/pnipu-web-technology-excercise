package ru.makhnutin.contacts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/")
	String homePage(ModelMap modal) {
		modal.addAttribute("title","Contacts Application");
		return "index";
	}

	@RequestMapping("/list")
	String listPage() {
		return "list";
	}

	@RequestMapping("/login")
	String loginPage() {
		return "login";
	}
}
