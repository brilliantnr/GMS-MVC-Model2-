package dao;

import java.util.List;

import domain.*;

public interface ExamDao {
	public void createExam(ExamBean exam);
	public List<ExamBean> listExam();
	public List<ExamBean> readExamByName(String name);
	public ExamBean readExamById(String id);
	public int countExam();
	public void updateExam(ExamBean exam);
	public void deleteExam(ExamBean exam);
}
