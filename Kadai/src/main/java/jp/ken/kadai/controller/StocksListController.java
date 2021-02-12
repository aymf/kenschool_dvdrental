package jp.ken.kadai.controller;

import java.util.List;

import jp.ken.kadai.dao.StocksDAO;
import jp.ken.kadai.dao.GoodsDAO;
import jp.ken.kadai.entity.Stocks;
import jp.ken.kadai.entity.Goods;
import jp.ken.kadai.model.StocksModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StocksListController {
	

	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static StocksDAO<Stocks> stocksDAO = (StocksDAO<Stocks>)context.getBean("stocksDAO");
	@SuppressWarnings("unchecked")
	private static GoodsDAO<Goods> goodsDAO = (GoodsDAO<Goods>)context.getBean("goodsDAO");


	@RequestMapping(value="/stocksList", method=RequestMethod.GET)
	public String toStocksList(Model model) {
		StocksModel sModel = new StocksModel();
		model.addAttribute("stocksModel", sModel);
		System.out.println("1111111");
		return "stocksList";
		
	}
	@RequestMapping(value="/stocksList", method=RequestMethod.POST)
	public String stocksList(@ModelAttribute StocksModel sModel, Model model) {
		System.out.println("zzzzzzz");

			List<Stocks> list = stocksDAO.stocksList();
			model.addAttribute("title", "商品在庫数");
			model.addAttribute("stocksList", list);
		
		return "stocksList";
	}
}
