package jp.ken.kadai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("company")
public class Company {
	
	@RequestMapping(method=RequestMethod.GET)
	public String company() {
		return "company";
	}

}
