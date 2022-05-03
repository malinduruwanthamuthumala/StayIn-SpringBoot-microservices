package com.webServices.stayIn.stayInwebservices.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webServices.stayIn.stayInwebservices.beans.HelloWorldBean;

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

	@GetMapping(path = "/getHelloWorldBean")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path = "/greet/{name}")
	public String greetWithName(@PathVariable String name ) {
		return "Hello" + name;
		
	}
}
