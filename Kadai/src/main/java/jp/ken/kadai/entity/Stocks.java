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
@Table(name="stocks")
public class Stocks {
	
	@Id
	private int goods_id;

	private int stock_quantity;
	
	@OneToOne
	@JoinColumn(name="goods_id", insertable=false, updatable=false)
	private Stocks stocks;

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public int getStock_quantity() {
		return stock_quantity;
	}

	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}

	public Stocks getStocks() {
		return stocks;
	}

	public void setStocks(Stocks stocks) {
		this.stocks = stocks;
	}

}
