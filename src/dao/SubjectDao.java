package dao;

import java.util.List;

import domain.SubjectBean;

public interface SubjectDao {
//select,insert,update,delete
	public void createSubject(SubjectBean bean);
	public List<SubjectBean> listSubject();
	public List<SubjectBean> selectSubjectByname(String word);
	public SubjectBean selectSubjectById(String id);
	public int countSubject();
	public SubjectBean updateSubject(SubjectBean bean);
	public void deleteSubject(SubjectBean bean);
	
}
