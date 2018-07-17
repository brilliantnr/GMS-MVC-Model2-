package dao;

import java.util.List;

import domain.SubjectBean;

public class SubjectDaoImpl implements SubjectDao{
	private static SubjectDao instance = new SubjectDaoImpl();
	public static SubjectDao getInstance() {return instance;}
	private SubjectDaoImpl() {}
	@Override
	public void createSubject(SubjectBean bean) {
		
	}

	@Override
	public List<SubjectBean> listSubject() {
		return null;
	}

	@Override
	public List<SubjectBean> selectSubjectByname(String word) {
		return null;
	}

	@Override
	public SubjectBean selectSubjectById(String id) {
		return null;
	}

	@Override
	public int countSubject() {
		return 0;
	}

	@Override
	public SubjectBean updateSubject(SubjectBean bean) {
		return null;
	}

	@Override
	public void deleteSubject(SubjectBean bean) {
		
	}

}
