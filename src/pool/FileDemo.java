package pool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.Scanner;

public class FileDemo {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final String PATH = "C:\\Users\\1027\\Documents\\sample.txt";//업로드// \가 앞에 붙는 건 뒤에것을 인식해라라는 명령 ex)\n
		try {
			File file = new File(PATH);
			FileWriter fw = new FileWriter(file, true);//이어쓰기 할거야(ture)
			FileReader fr = new FileReader(file);
			BufferedWriter writer = new BufferedWriter(fw);
			BufferedReader reader = new BufferedReader(fr);
			while(true) {
				System.out.println("[메뉴] 1.전송 2.읽기 0.종료");
				 switch (s.next()) {
				case "1":
					System.out.println("메시지 입력");
					writer.write(s.next());
					writer.newLine();//줄바꿈. 버퍼로인해쌓여있음
					writer.flush();//한꺼번에send
					break;
				case "2":
					System.out.println("메시지 보기");
					String msg = "";
					while ((msg = reader.readLine()) != null) {
						System.out.println(msg);
					
					}
					reader.close();//다 읽었으면 클로즈해
					break;
				case "0":
					
					break;
				default:
					break;
				}
			}
			
		} catch (Exception e) {e.printStackTrace();} 
		
		
		FileName fn = new FileName(PATH);// DB에는 sample 과 txt 이 분리되어 저장된다. 파일명과 확장자
		System.out.println("파일명 : "+fn.getFilename());
		System.out.println("확장자 : "+fn.getExt());
	}
}

//현재 이너클래스를 외부로 꺼내놓음(이너클래스아님)
class FileName{

	private String path, sep, ext, filename;
	public FileName(String path) {
		this.path=path;
		this.sep=File.separator;
		this.filename=path.substring(path.lastIndexOf("\\")+1,path.lastIndexOf("."));
		this.ext=path.substring(path.lastIndexOf(".")+1);//substring
		//lastIndexOf("\\")+1
		
	}
	public String getPath() {
		return path;
	}
	public String getSep() {
		return sep;
	}
	public String getExt() {
		return ext;
	}
	public String getFilename() {
		return filename;
	}
}	



/*
자바는 램 세상
file은 자바에 있어서 class.forname 
*/



	
	/*public FileName(String path, String sep, String ext) {
	 * 	//inner class는 public을 갖지 않는다.
	//이유는 이 클래스 내부에서만 사용하고자 함이다.
	//만약 다른 곳에서 계속 사용한다면 독립시켜야 한다.
	//= 1회용 사용 클래스
	/*private String fullPath;
	private String 
		pathSeparator,  //path세퍼레이터는 /
		extensionSeparator;  //확장자 세퍼레이터는 .
		//운영체제마다 세퍼레이터 달라서 변수처리해야함!!!! 중요.
		fullPath = path; 			//this.fullPath = fullPath;
		pathSeparator = sep;
		extensionSeparator = ext;
	}*/
	//Alt+Shift+S+R =>setter만 만들기
	//임시적인 녀석이야. 한번쓰고 말거라서 패턴 걸 필요도 없다
	//그래서 inner클래스로 하는 것
	//파일명 갖고 와서 분리하는 과정
	
	//cf. 항상쓰는 거는 static 으로 잡아서 패턴건다.
	//리턴 넣어서 getter,setter 의 혼종만듦
/*	public String fileName(String fullPath) {
		this.fullPath = fullPath;
		return "";
	}

	public String pathSeparator(char pathSeparator) {
		System.out.println("FileDemo 윈도우 파일 구분자 : "+File.separator);
		return File.separator;
	}

확장자 .exe, .java, .xls    ...
		
	public String extensior(String extensionSeparator) {
		this.extensionSeparator = extensionSeparator;
		int dot = fullPath.lastIndexOf(extensionSeparator);
		System.out.println("FileDemo 닷의 위치값 : "+dot);
		return "";
	}
	
}  //inner Class (안드로이드는 이너클래스로만 코딩 많이 한다.)롬복 잘안먹음*/