package domain;

import lombok.Data;

@Data
public class ExamBean {
	private String examSeq, memId, score, month, subSeq, recordSeq;

	
	@Override
	public String toString() {
		return "-------시험정보--------"
				+ "\n 시험SEQ=" + examSeq 
				+ ", \n 학생ID=" + memId 
				+ ", \n 점수=" + score 
				+ ", \n 월=" + month
				+ ", \n 과목SEQ=" + subSeq 
				+ ", \n 성적표SEQ=" + recordSeq 
				+ "\n ---------------------";
	}
//처음시작하면 만들어 놓음
	
}
