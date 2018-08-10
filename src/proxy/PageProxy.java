package proxy;

import lombok.Data;

@Data
public class PageProxy implements proxy {
	private Pagination pagination;
	
	@Override
	public void carryOut(Object o) {
		System.out.println("--PageProxy");
		this.pagination = new Pagination();
		pagination.carryOut(o);
	}

}
