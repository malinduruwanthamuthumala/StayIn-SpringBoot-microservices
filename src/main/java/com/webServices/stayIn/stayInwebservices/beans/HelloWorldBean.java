package com.webServices.stayIn.stayInwebservices.beans;

import javax.persistence.Entity;

import org.springframework.web.bind.annotation.GetMapping;


public class HelloWorldBean {
	
private String message;

public HelloWorldBean(String message){
	this.message = message;
}

public String getMessage() {
	return message;
}


}

