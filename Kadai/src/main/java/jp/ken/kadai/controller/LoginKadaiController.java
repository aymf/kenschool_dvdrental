package jp.ken.kadai.controller;

import jp.ken.kadai.model.LoginKadaiModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("login")
@SessionAttributes("loginModel")
public class LoginKadaiController {
	
	@ModelAttribute("loginModel")
	public LoginKadaiModel setUpLoginForm() {
		return new LoginKadaiModel();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String toLogin() {
		return "loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String toRegist(@Validated @ModelAttribute LoginKadaiModel lModel, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "loginForm";
		}else if(!(lModel.getUserId().equals("duke") && lModel.getPassword().equals("dolphin7"))) {
			model.addAttribute("errorMessage","ユーザーIDもしくはパスワードが間違っています。");
			return "loginForm";
		}else {
			return "redirect:/regist";
		}
	}
}