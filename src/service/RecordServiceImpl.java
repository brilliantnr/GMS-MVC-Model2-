package service;

import java.util.List;

import domain.*;

public class RecordServiceImpl implements RecordService{

	private static RecordService instance = new RecordServiceImpl();
	public static RecordService getInstance() {return instance;}
	private RecordServiceImpl() {}
	
	@Override
	public void createRecord(RecordBean record) {
		
	}

	@Override
	public List<RecordBean> listRecord() {
		return null;
	}

	@Override
	public List<RecordBean> readRecordByName(String name) {
		return null;
	}

	@Override
	public RecordBean readRecordById(String id) {
		return null;
	}

	@Override
	public int countRecord() {
		return 0;
	}

	@Override
	public void updateRecord(RecordBean record) {
		
	}

	@Override
	public void deleteRecord(RecordBean record) {
		
	}

}
