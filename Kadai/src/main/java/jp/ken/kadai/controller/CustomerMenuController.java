package jp.ken.kadai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("customerMenu")
public class CustomerMenuController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String menu() {
		return "CustomerMenu";
	}
	
}
