package jp.ken.kadai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="goods")
public class Goods {
	
	@Id
	@Column(name="goods_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int goods_id;

	private String goods_name;
	private String goods_kana;
	private int goods_category_id;
	
	@OneToOne
	@JoinColumn(name="goods_category_id", insertable=false, updatable=false)
	private Categories categories;

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_kana() {
		return goods_kana;
	}

	public void setGoods_kana(String goods_kana) {
		this.goods_kana = goods_kana;
	}

	public int getGoods_category_id() {
		return goods_category_id;
	}

	public void setGoods_category_id(int goods_category_id) {
		this.goods_category_id = goods_category_id;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	

}
