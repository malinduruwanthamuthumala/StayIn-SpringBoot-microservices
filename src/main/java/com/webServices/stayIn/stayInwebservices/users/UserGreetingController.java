package com.webServices.stayIn.stayInwebservices.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserGreetingController {
	
	@RequestMapping(method = RequestMethod.GET,path="/greet")
	public String greet() {
		return "Hello User";
	}
	
	@GetMapping(path ="/secondgreet")
	public String greet2() {
		return "Hello User2";
	}

}
