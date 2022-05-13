package com.example.messagingstompwebsocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {

	@RequestMapping("/hello1")
	public String page(){
		return "html/hello1";
	}
}
