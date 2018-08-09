package service;

import java.util.*;
import domain.*;

public interface MemberService {
	public void add(MemberBean bean);
	public List<MemberBean> search(Map<?, ?>param);
	public MemberBean retrieve(String id);
	public int count();
	public void modify(Map<?, ?>param);
	public void remove(MemberBean bean);  //짜기시작할때는 map으로하자
	public boolean login(MemberBean bean);
}
