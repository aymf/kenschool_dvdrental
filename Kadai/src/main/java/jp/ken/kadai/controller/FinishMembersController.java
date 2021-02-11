package jp.ken.kadai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("finish")
@SessionAttributes({"loginModel","memberModel"})
public class FinishMembersController {
	
	@RequestMapping(method=RequestMethod.POST)
	public String toFinish(Model model, SessionStatus status) {
		status.setComplete();
		model.addAttribute("message","セッションが削除されました。");
		return "finish";
	}

}
