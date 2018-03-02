package com.inspt.guarderiacaracol.web;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inspt.guarderiacaracol.domain.AppUser;
import com.inspt.guarderiacaracol.service.IAppUserService;
import com.inspt.guarderiacaracol.view.AppUserView;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private IAppUserService userService;

//	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
//	public ModelAndView login(){
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("login");
//		return modelAndView;
//	}
//	
//	@RequestMapping(value="/registration", method = RequestMethod.GET)
//	public ModelAndView registration(){
//		ModelAndView modelAndView = new ModelAndView();
//		AppUserView user = new AppUserView();
//		modelAndView.addObject("user", user);
//		modelAndView.setViewName("registration");
//		return modelAndView;
//	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Principal user(Principal user) {
		return user;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public @ResponseBody void createNewUser(@Valid AppUserView appUser, BindingResult bindingResult) {
//		ModelAndView modelAndView = new ModelAndView();
		AppUser userExists = userService.findByUsername(appUser.getUsername());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user", "There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
//			modelAndView.setViewName("registration");
		} else {
			userService.save(appUser.toDTO());
//			modelAndView.addObject("successMessage", "User has been registered successfully");
//			modelAndView.addObject("user", new AppUser());
//			modelAndView.setViewName("registration");
			
		}
//		return modelAndView;
	}
	
}
