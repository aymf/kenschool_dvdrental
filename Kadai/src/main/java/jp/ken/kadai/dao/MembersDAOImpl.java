package jp.ken.kadai.dao;

import java.util.List;

import jp.ken.kadai.entity.Members;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MembersDAOImpl implements MembersDAO<Members> {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Members> allList() {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("FROM Members");
		List<Members> memberList = query.list();
		session.close();
		return memberList;
	}

	@Override
	public Members getById(int id) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("FROM Members WHERE member_id = ?");
		query.setParameter(0, id);
		Members members = (Members)query.uniqueResult();
		session.close();
		return members;
	}
	
	@Override
	public List<Members> getByMailPass(String email, String password) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("FROM Members WHERE member_email = ? AND member_password = ?");
		query.setParameter(0, email);
		query.setParameter(1, password);
		List<Members> members = query.list();
		session.close();
		return members;
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Members> getByName(String name) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("FROM Members WHERE member_name LIKE ?");
		query.setParameter(0, "%" + name + "%");
		List<Members> list = query.list();
		session.close();
		return list;
	}

	@Override
	public boolean insertMembersData(Members members) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(members);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			tx.rollback();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public int updateMembersData(Members members) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(members);
			tx.commit();
			return 1;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return 0;
		} finally {
			session.close();
		}
	}

	@Override
	public int deleteMembersData(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query query = session.createQuery("FROM Members WHERE member_id = ?");
			query.setParameter(0, id);
			Members members = (Members)query.uniqueResult();
			session.delete(members);
			tx.commit();
			return 1;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return 0;
		} finally {
			session.close();
		}
	}
}
