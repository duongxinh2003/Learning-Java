package com.sonnh.myspringcrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sonnh.myspringcrud.entity.User;
import com.sonnh.myspringcrud.service.UserService;

@Controller //this is controller
public class UserController {
	
	@Autowired //inject UserService to Controller
	private UserService userService;
	
	@RequestMapping(value="/") //accept GET method and mapping with URI = /
	public String index(Model model) {
		List<User> users = userService.getAllUser();
		model.addAttribute("users", users); //pass data to view
		return "index"; //html page
	}
	
	@RequestMapping(value="add")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}
	
	//navigate Edit page
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editUser(@RequestParam("id") Long userId, Model model) {
		Optional<User> userEdit = userService.findUserById(userId);
		model.addAttribute("user", userEdit.get());
		return "editUser";
	}
	
	//Save add
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String save(User user) {
		userService.saveUser(user);
		return "redirect:/";
	}
	
	//Update
	@PostMapping(value="update")
	public String edit(@RequestParam("id") Long id, @ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteUser(@RequestParam("id") Long userId, Model model) {
		userService.deleteUser(userId);
		return "redirect:/";
	}
	
	@RequestMapping(value="search", method=RequestMethod.GET)
	public String search(@RequestParam("name") String name, Model model) {
		List<User> users = userService.findUserByName(name);
		model.addAttribute("users", users);
		return "searchResult";
	}
}
