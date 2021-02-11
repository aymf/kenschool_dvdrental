package jp.ken.kadai.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import jp.ken.kadai.model.ListDataKadaiModel;
import jp.ken.kadai.model.Group1;
import jp.ken.kadai.model.EmployeeKadaiModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeKadaiController {
	
	@GroupSequence({ Default.class, Group1.class })
	interface GroupOrder1{}
	
	//年月日（西暦）
	//引数：0→生年月日、それ以外→入社年月日
	private List<ListDataKadaiModel> getYear(int flag){
		int start = 0;
		if(flag == 0) start = 1970;
		else start = 2000;
		
		List<ListDataKadaiModel> yearLists = new ArrayList<ListDataKadaiModel>();
		Calendar calendar = Calendar.getInstance();
		for (int i=start; i<=calendar.get(Calendar.YEAR); i++) {
			yearLists.add(new ListDataKadaiModel(Integer.toString(i),Integer.toString(i)));
		}
		return yearLists;
	}
	
	//年月日（月）
	private List<ListDataKadaiModel> getMonth(){
		List<ListDataKadaiModel> monthLists = new ArrayList<ListDataKadaiModel>();
		Calendar calendar = Calendar.getInstance();
		for (int i=1; i<=12; i++) {
			monthLists.add(new ListDataKadaiModel(Integer.toString(i),Integer.toString(i)));
		}
		return monthLists;
	}
	//年月日（日）
	private List<ListDataKadaiModel> getDay(){
		List<ListDataKadaiModel> dayLists = new ArrayList<ListDataKadaiModel>();
		Calendar calendar = Calendar.getInstance();
		for (int i=1; i<=31; i++) {
			dayLists.add(new ListDataKadaiModel(Integer.toString(i),Integer.toString(i)));
		}
		return dayLists;
	}
	
	
	//GET通信
	@RequestMapping(value="/rental",method=RequestMethod.GET)
	public String regit(Model model) {
		EmployeeKadaiModel eModel = new EmployeeKadaiModel();
	
		model.addAttribute("employeeModel",eModel);
		model.addAttribute("bYear",getYear(0));
		model.addAttribute("bMonth",getMonth());
		model.addAttribute("bDay",getDay());
		model.addAttribute("eYear",getYear(1));
		model.addAttribute("eMonth",getMonth());
		model.addAttribute("eDay",getDay());

		return "empRegistrationKadai";
	}
	//POST通信
		@RequestMapping(value="/rental",method=RequestMethod.POST)
		public String confilm(@Validated(GroupOrder1.class)@ModelAttribute EmployeeKadaiModel eModel, BindingResult result, Model model) {
			if(result.hasErrors()) {
				model.addAttribute("employeeModel",eModel);
				model.addAttribute("bYear",getYear(0));
				model.addAttribute("bMonth",getMonth());
				model.addAttribute("bDay",getDay());
				model.addAttribute("eYear",getYear(1));
				model.addAttribute("eMonth",getMonth());
				model.addAttribute("eDay",getDay());
				return "empRegistrationKadai";
			}
			model.addAttribute("name",eModel.getName());
			model.addAttribute("kana",eModel.getKana());
			
			if(eModel.getGender().equals("man")) model.addAttribute("gender","男");
			else model.addAttribute("gender","女");
			
			model.addAttribute("bYear",eModel.getbYear());
			model.addAttribute("bMonth",eModel.getbMonth());
			model.addAttribute("bDay",eModel.getbDay());
			model.addAttribute("zip",eModel.getZip());
			model.addAttribute("address",eModel.getAddress());
			model.addAttribute("phone",eModel.getPhone());
			model.addAttribute("mail",eModel.getMail());
			
		
			
			String[] selectCapacities = eModel.getCapacities();
			Map<String,String> capacityLists = new HashMap<String,String>();
			
			String capLists = "";
			for(String data : selectCapacities) {
				capLists += capacityLists.get(data) + "<br />";
			}
			model.addAttribute("capacities",capLists);
			
			return "empConfirmKadai";
		}

}
