package dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import domain.ImageBean;
import enums.Domain;
import template.*;

public class ImageDaoImpl implements ImageDao{
	private static ImageDao instance = new ImageDaoImpl();
	public static ImageDao getInstance() {return instance;}
	public ImageDaoImpl() {}
	private QueryTemplate q = null;
	
	@Override
	public void insert(Map<?, ?> param) {
		System.out.println("ImageDaoImpl insert ---");
		q= new AddQuery();
		HashMap<String, Object> map = new HashMap<>();
		//Iterator 패턴 ★★★
		Iterator<?> keys = param.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			map.put(key, param.get(key));
		}
		map.put("table", Domain.IMAGE);
		q.play(map);
	}

	@Override
	public ImageBean selectOne(String id) {
		System.out.println("ImageDaoImpl selectOne --- ");
		q=new RetrieveQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.IMAGE);
		map.put("id", id);
		q.play(map);
		return (ImageBean) q.getO();
	}

	@Override
	public void update(Map<?, ?> param) {
		System.out.println("ImageDaoImpl update --- ");
		q=new ModifyQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.IMAGE);
		q.play(map);
	}

	@Override
	public void delete(ImageBean bean) {
		System.out.println("ImageDaoImpl delete --- ");
		q=new RemoveQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.IMAGE);
		map.put("image", bean);
		q.play(map);
	}

}
