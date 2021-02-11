package jp.ken.kadai.controller;

import jp.ken.kadai.dao.MembersDAO;
import jp.ken.kadai.entity.Members;
import jp.ken.kadai.model.MembersModel;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("changeMember")
public class MembersChangeController {

	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static MembersDAO<Members> memberDAO = (MembersDAO<Members>)context.getBean("membersDAO");

	@RequestMapping(method=RequestMethod.GET)
	public String changeList(Model model) {
		MembersModel mModel = new MembersModel();
		model.addAttribute("membersModel", mModel);
		List<Members> list = memberDAO.allList();
		model.addAttribute("changeMembersList", list);
		return "changeMembersData";
	}

}
