package service;

import java.util.List;

import domain.*;
import dao.*;

public class ExamServiceImpl implements ExamService{
	
	private static ExamService instance = new ExamServiceImpl();
	public static ExamService getInstance() {return instance;}
	private ExamServiceImpl() {}
	
	@Override
	public void createExam(ExamBean exam) {
		
		System.out.println("===== ExamService =====");
        System.out.println(exam);
        // 과목SEQ=null,
        // 성적표SEQ=null
        System.out.println("----- RECORD TABLE INSERT ------");
        RecordBean rec = new RecordBean();
        rec.setAvg("80");
        rec.setGrade("");
        RecordDaoImpl.getInstance().createRecord(rec);
        System.out.println("------ Exam TABLE INSERT ------");
        exam.setScore(exam.getScore().split("/")[0]);
        exam.setSubSeq(
        		SubjectDaoImpl.getInstance().
        		selectSubjectByname("JAVA").get(0).getSubSeq()
        		);
        exam.setRecordSeq(RecordDaoImpl.getInstance()
                .selectFirstRowNum());    
        ExamDaoImpl.getInstance().createExam(exam);
		
		
		/*System.out.println("ExameSErvice------");
		System.out.println(exam);
		exam.setScore(exam.getScore().split("/")[0]);
		
		exam.setSubSeq(
		SubjectDaoImpl.getInstance().
		selectSubjectByname("JAVA").get(0).getSubSeq()
		);
		RecordBean rec = new RecordBean();
		rec.setAvg("");
		rec.setGrade("");
		RecordDaoImpl.getInstance().createRecord(rec);
		exam.setRecordSeq(RecordDaoImpl.getInstance().selectFirstRowNum());
		
		ExamDaoImpl.getInstance().createExam(exam);
		//과목SEQ=null;
		//성적표SEQ=null;
				
				
		SubjectBean one = 
				SubjectDaoImpl.getInstance().
				selectSubjectByname("JAVA").get(0);   //★★★★★★★★
		
		
		*/
		
	}

	@Override
	public List<ExamBean> selectAllExam() {
		return null;
	}

	@Override
	public List<ExamBean> selectExamsearchWord(String word) {
		return null;
	}

	@Override
	public ExamBean readExamById(String id) {
		return null;
	}

	@Override
	public int countExam() {
		return 0;
	}

	@Override
	public void updateExam(ExamBean exam) {
		
	}

	@Override
	public void deleteExam(ExamBean exam) {

	}

}
