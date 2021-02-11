package jp.ken.kadai.controller;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import jp.ken.kadai.dao.MembersDAO;
import jp.ken.kadai.entity.Members;
import jp.ken.kadai.model.MembersModel;
import jp.ken.kadai.model.ErrorCheckGroup1;

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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("editMember")
public class MembersEditController {

	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static MembersDAO<Members> memberDAO = (MembersDAO<Members>)context.getBean("membersDAO");

	@GroupSequence({ Default.class, ErrorCheckGroup1.class })
	interface GroupOrder {}

	@RequestMapping(method=RequestMethod.GET)
	public String toEdit(@RequestParam int paramId, Model model) {
		Members members = memberDAO.getById(paramId);
		MembersModel mModel = new MembersModel();
		BeanUtils.copyProperties(members, mModel);
		mModel.setMember_id(new Integer(paramId).toString());
		model.addAttribute("membersModel", mModel);
		return "editMembersData";
	}

	@RequestMapping(method=RequestMethod.POST, params="editMember")
	public String edit(@RequestParam int member_id,
			@Validated(GroupOrder.class) @ModelAttribute MembersModel mModel,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			mModel.setMember_id(new Integer(member_id).toString());
			model.addAttribute("membersModel", mModel);
			return "editMembersData";
		} else {
			Members members = new Members();
			BeanUtils.copyProperties(mModel, members);
			members.setMember_id(Integer.parseInt(mModel.getMember_id()));
			if (memberDAO.updateMembersData(members) == 1) {
				return "redirect:/changeMember";
			} else {
				model.addAttribute("errorMessage", "SQLエラーが発生しています");
				return "editMembersData";
			}
		}
	}

	@RequestMapping(method=RequestMethod.POST, params="resetMember")
	public String reset(@RequestParam int member_id, Model model) {
		Members members = memberDAO.getById(member_id);
		MembersModel mModel = new MembersModel();
		BeanUtils.copyProperties(members, mModel);
		mModel.setMember_id(new Integer(member_id).toString());
		model.addAttribute("membersModel", mModel);
		return "editMembersData";
	}
}