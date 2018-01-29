package com.inspt.guarderiacaracol.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.inspt.guarderiacaracol.domain.AppUser;
import com.inspt.guarderiacaracol.service.IAppUserService;
import com.inspt.guarderiacaracol.view.AppUserView;

@Controller
public class LoginController {
	
	@Autowired
	private IAppUserService userService;

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		AppUserView user = new AppUserView();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid AppUserView appUser, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		AppUser userExists = userService.findByUsername(appUser.getUsername());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user", "There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.save(appUser.toDTO());
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new AppUser());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		AppUser user = userService.findByUsername(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " (" + user.getUsername() + ")");
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	
}
