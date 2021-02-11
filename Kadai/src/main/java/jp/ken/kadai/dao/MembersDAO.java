package jp.ken.kadai.dao;

import java.util.List;

import jp.ken.kadai.entity.Members;

public interface MembersDAO<T> {
	
	public List<T> allList();

	public Members getById(int id);
	
	public List<T> getByMailPass(String email, String password);

	public List<T> getByName(String name);

	public boolean insertMembersData(Members members);

	public int updateMembersData(Members members);

	public int deleteMembersData(int id);

}
