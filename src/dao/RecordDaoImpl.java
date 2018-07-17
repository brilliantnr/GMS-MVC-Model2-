package dao;

import java.util.List;

import domain.*;

public class RecordDaoImpl implements RecordDao{

	private static RecordDao instance = new RecordDaoImpl();
	public static RecordDao getInstance() {return instance;}
	private RecordDaoImpl() {}

	@Override
	public void createRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RecordBean> listRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecordBean> readRecordByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecordBean readRecordById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countRecord() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRecord(RecordBean record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String selectFirstRowNum() {
		// TODO Auto-generated method stub
		return null;
	}

}

