package service;

import java.util.Map;

import dao.ImageDaoImpl;
import domain.ImageBean;

public class ImageServiceImpl implements ImageService {
	private static ImageService instance = new ImageServiceImpl();
	public static ImageService getinstance() {return instance;}
	private ImageServiceImpl() {}

	@Override
	public void add(Map<?, ?> param) {
		ImageDaoImpl.getInstance().insert(param);
	}

	@Override
	public ImageBean retrieve(String id) {
		return ImageDaoImpl.getInstance().selectOne(id);
	}

	@Override
	public void modify(Map<?, ?> param) {
		ImageDaoImpl.getInstance().update(param);
	}

	@Override
	public void remove(ImageBean bean) {
		ImageDaoImpl.getInstance().delete(bean);
	}

}
