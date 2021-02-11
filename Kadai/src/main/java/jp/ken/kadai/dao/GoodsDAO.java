package jp.ken.kadai.dao;

import java.util.List;

public interface GoodsDAO<T> {
	
	public List<T> allGoodsList();

	public List<T> vagueGoodsList(String vague);

}
