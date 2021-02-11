package jp.ken.kadai.dao;

import java.util.List;

import jp.ken.kadai.entity.Categories;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CategoriesDAOImpl implements CategoriesDAO<Categories>{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Categories> allGoodsList() {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("FROM Categories");
		List<Categories> allGoodsList = query.list();
		session.close();
		return allGoodsList;
	}

}
