package jp.ken.kadai.dao;

import java.util.List;

import jp.ken.kadai.entity.Goods;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GoodsDAOImpl implements GoodsDAO<Goods> {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Goods> allGoodsList() {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("FROM Goods ORDER BY goods_category_id");
		List<Goods> allGoodsList = query.list();
		session.close();
		return allGoodsList;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Goods> vagueGoodsList(String vague) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("FROM Goods WHERE goods_name LIKE :inputVague");
		query.setParameter("inputVague", "%" + vague + "%");
		List<Goods> vagueGoodsList = query.list();
		session.close();
		return vagueGoodsList;

	}
}