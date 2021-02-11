package jp.ken.kadai.controller;

import jp.ken.kadai.model.EmployeesModel;
import jp.ken.kadai.model.ErrorCheckGroup1;
import jp.ken.kadai.dao.MembersDAO;
import jp.ken.kadai.entity.Members;
import jp.ken.kadai.model.MembersModel;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("memberList")
public class MemberRegistController {
	
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static MembersDAO<Members> membersDAO = (MembersDAO<Members>)context.getBean("membersDAO");

	@GroupSequence({ Default.class, ErrorCheckGroup1.class})
	interface GroupOrder{}
	
	@RequestMapping(method=RequestMethod.GET)
	public String toRegist(Model model) {
			MembersModel mModel = new MembersModel();
		model.addAttribute("membersModel", mModel);
		System.out.println("000000");
		return "listMembersData";
	}

@RequestMapping(method=RequestMethod.POST, params="memberList")
public String regist(
		@Validated(GroupOrder.class) @ModelAttribute MembersModel mModel,
		BindingResult result, Model model) {
	if(result.hasErrors()) {
		model.addAttribute("errorMessage", "エラーが発生しています");
		System.out.println("000001");
		return "listMembersData";
	}else {
		Members members = new Members();
		BeanUtils.copyProperties(mModel, members);
		if(membersDAO.insertMembersData(members)) {
			System.out.println("0000002");
			return "listMembersData";
		}else {
			model.addAttribute("errorMessage", "SQLエラーが発生しています");
			System.out.println("0000003");
			return "listMembersData";
		}
	}
  }

@RequestMapping(method=RequestMethod.POST, params="memberReset")
public String reset(Model model) {
	MembersModel mModel = new MembersModel();
	model.addAttribute("membersModel", mModel);
	return "listMembersData";
}
}