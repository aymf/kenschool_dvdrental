package jp.ken.kadai.dao;

import java.util.List;

import jp.ken.kadai.entity.Stocks;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StocksDAOImpl implements StocksDAO<Stocks>{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Stocks> stocksList() {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("FROM Stocks");
		List<Stocks> stocksList = query.list();
		session.close();
		return stocksList;
	}

}
