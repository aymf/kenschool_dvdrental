package jp.ken.kadai.controller;

import java.util.List;

import jp.ken.kadai.dao.CategoriesDAO;
import jp.ken.kadai.dao.GoodsDAO;
import jp.ken.kadai.entity.Categories;
import jp.ken.kadai.entity.Goods;
import jp.ken.kadai.model.RentalGoodsModel;

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

public class RentalGoodsController {

	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static CategoriesDAO<Categories> categoriesDAO = (CategoriesDAO<Categories>)context.getBean("categoriesDAO");
	@SuppressWarnings("unchecked")
	private static GoodsDAO<Goods> goodsDAO = (GoodsDAO<Goods>)context.getBean("goodsDAO");

	@RequestMapping(value="/topMenu", method=RequestMethod.GET)
	public String menu() {
		return "topMenu";
	}

	@RequestMapping(value="/allGoodsList", method=RequestMethod.GET)
	public String toAllGoodsList(Model model) {
		RentalGoodsModel rModel = new RentalGoodsModel();
		model.addAttribute("rentalGoodsModel", rModel);
		return "allGoodsList";
	}
	@RequestMapping(value="/allGoodsList", method=RequestMethod.POST)
	public String allGoodsList(@ModelAttribute RentalGoodsModel rModel, Model model) {
		if(rModel.getSelectRadio().equals("categories")) {
			List<Categories> list = categoriesDAO.allGoodsList();
			model.addAttribute("title", "商品カテゴリ一覧");
			model.addAttribute("categoriesAllGoodsList", list);
		
		} else {
			List<Goods> list = goodsDAO.allGoodsList();
			model.addAttribute("title", "商品一覧");
			model.addAttribute("goodsAllGoodsList", list);
		}
		return "allGoodsList";
	}

	@RequestMapping(value="/vagueGoodsList", method=RequestMethod.GET)
	public String toVagueList(Model model) {
		RentalGoodsModel rModel = new RentalGoodsModel();
		model.addAttribute("rentalGoodsModel", rModel);
		return "vagueGoodsList";
	}
	@RequestMapping(value="/vagueGoodsList", method=RequestMethod.POST)
	public String vagueList(@Validated @ModelAttribute RentalGoodsModel rModel,
				BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "vagueGoodsList";
		} else {
			List<Goods> list = goodsDAO.vagueGoodsList(rModel.getVagueField());
			model.addAttribute("title", "検索結果");
			model.addAttribute("vagueGoodsList", list);
			return "vagueGoodsList";
		}
	}
}