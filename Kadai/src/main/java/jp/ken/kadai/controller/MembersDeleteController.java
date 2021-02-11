package jp.ken.kadai.controller;

import jp.ken.kadai.dao.MembersDAO;
import jp.ken.kadai.entity.Employees;
import jp.ken.kadai.entity.Members;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("deleteMember")
public class MembersDeleteController {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static MembersDAO<Members> memberDAO = (MembersDAO<Members>)context.getBean("membersDAO");

	@RequestMapping(method=RequestMethod.GET)
	public String toDelete(@RequestParam int paramId, Model model) {
		Members members = memberDAO.getById(paramId);
		model.addAttribute("deleteMembersData", members);
		return "deleteMembersData";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String delete(@RequestParam int member_id, Model model) {
		if (memberDAO.deleteMembersData(member_id) == 1) {
			return "redirect:/changeMember";
		} else {
			model.addAttribute("errorMessage", "SQLエラーが発生しています");
			return "deleteMembersData";
		}
	}

}
