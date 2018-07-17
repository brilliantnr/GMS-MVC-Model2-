package service;

import java.util.List;

import domain.*;

public interface ExamService {
	public void createExam(ExamBean bean);
	public List<ExamBean> selectAllExam();
	public List<ExamBean> selectExamsearchWord(String word);
	public ExamBean readExamById(String id);
	public int countExam();
	public void updateExam(ExamBean bean);
	public void deleteExam(ExamBean bean);
}
