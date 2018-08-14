package service;

import java.util.Map;

import domain.ImageBean;

public interface ImageService {
	public void add(Map<?, ?> param);
	public ImageBean retrieve(String id);
	public void modify(Map<?, ?> param);
	public void remove(ImageBean bean);
}
