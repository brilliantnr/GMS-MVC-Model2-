package dao;

import java.util.Map;
import domain.ImageBean;

public interface ImageDao {
	public void insert(Map<?, ?> param);
	public ImageBean selectOne(String id);
	public void update(Map<?, ?> param);
	public void delete(ImageBean bean);
}
