package proxy;

import lombok.Data;
import service.MemberServiceImpl;

@Data
public class Pagination implements proxy{
	
	int memberCount, rowCount, blockSize, blockNum, pageNum, pageCount, beginPage, endPage, beginRow, endRow;
	boolean existPrev, existNext;

	 @Override
	public void carryOut(Object o) {
		this.pageNum = (int) o;
		this.memberCount = MemberServiceImpl.getInstance().countMember();
		this.rowCount = MemberServiceImpl.getInstance().countMember(); // 게시물수
		this.blockSize = 5; // 1~5, 6~10
		this.pageCount = (int) Math.ceil(rowCount / blockSize); // 총페이지수
		this.beginPage = (int) (Math.floor((pageNum - 1) / blockSize) * blockSize + 1);
		this.blockNum=(int) Math.floor(beginPage / blockSize + 1) ;
		this.endPage = (pageCount > blockNum * blockSize) ? blockNum * blockSize : pageCount;
		
		this.beginRow = (pageNum - 1) * blockSize + 1;
		this.endRow = pageNum * blockSize;
		this.existPrev = false;
		this.existNext = false;
	        if(beginPage>1) {
	            existPrev=true;
	            if(endPage!=pageCount) {
	                existNext=true;
	            }
	        }else {
	            if(endPage!=pageCount) {
	                existNext=true;
	            }
	        }
	}
}
