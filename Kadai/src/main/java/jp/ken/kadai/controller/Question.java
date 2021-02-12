package jp.ken.kadai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("question")
public class Question {
	
	@RequestMapping(method=RequestMethod.GET)
	public String question() {
		return "question";
	}

}
