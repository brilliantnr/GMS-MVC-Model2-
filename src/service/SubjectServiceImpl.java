package service;

import java.util.List;

import domain.*;

public class SubjectServiceImpl implements SubjectService{

	private static SubjectService instance = new SubjectServiceImpl();
	public static SubjectService getInstance() {return instance;}
	private SubjectServiceImpl() {
	}
	
	
	@Override
	public void createSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SubjectBean> listSubject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectBean> readSubjectByname(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectBean readSubjectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countSubject() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SubjectBean updateSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSubject(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}


}
