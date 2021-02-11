package jp.ken.kadai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categories {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int goods_category_id;
	private String goods_category_name;
	private String goods_category_kana;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="goods_category_id", insertable=false, updatable=false)
	private List<Goods> goods = new ArrayList<Goods>();
	
	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	
	public int getGoods_category_id() {
		return goods_category_id;
	}

	public void setGoods_category_id(int goods_category_id) {
		this.goods_category_id = goods_category_id;
	}

	public String getGoods_category_name() {
		return goods_category_name;
	}

	public void setGoods_category_name(String goods_category_name) {
		this.goods_category_name = goods_category_name;
	}

	public String getGoods_category_kana() {
		return goods_category_kana;
	}

	public void setGoods_category_kana(String goods_category_kana) {
		this.goods_category_kana = goods_category_kana;
	}


}
