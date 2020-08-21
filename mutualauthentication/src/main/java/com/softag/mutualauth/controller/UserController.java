package com.softag.mutualauth.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping(value = "/user")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String user(Model model, Principal principal) {

		UserDetails currentUser = (UserDetails) ((Authentication) principal).getPrincipal();
		model.addAttribute("username", currentUser.getUsername());
		return "user";
	}
}
