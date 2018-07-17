package service;

import java.util.List;

import domain.*;

public interface RecordService {
	public void createRecord(RecordBean record);
	public List<RecordBean> listRecord();
	public List<RecordBean> readRecordByName(String name);
	public RecordBean readRecordById(String id);
	public int countRecord();
	public void updateRecord(RecordBean record);
	public void deleteRecord(RecordBean record);
}
