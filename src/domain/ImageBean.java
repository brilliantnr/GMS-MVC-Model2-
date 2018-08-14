package domain;

import lombok.Data;

@Data
public class ImageBean {
	private String imgseq;
	private String imgname;
	private String extension;
	private String userid;  //프로필 이미지
}
