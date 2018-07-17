package service;

import java.util.List;

import domain.*;

public interface SubjectService {
	public void createSubject(SubjectBean bean);
	public List<SubjectBean> listSubject();
	public List<SubjectBean> readSubjectByname(String word);
	public SubjectBean readSubjectById(String id);
	public int countSubject();
	public SubjectBean updateSubject(SubjectBean bean);
	public void deleteSubject(SubjectBean bean);

}
