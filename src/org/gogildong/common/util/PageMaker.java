package org.gogildong.common.util;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageMaker {

	private boolean prev;
	private boolean next;
	private int start;
	private int end;
	private int realEnd;
	private PageInfo pageInfo;
	private int total;
	private int currentPage;
	private int tempEnd;

	public PageMaker(PageInfo pageInfo, int total) {

		this.pageInfo = pageInfo;
		this.total = total;
		
		currentPage = pageInfo.getPage();

		tempEnd = currentPage + 1;

		start = currentPage - 1;
		
		if(start<1) {
			start = 1;
			tempEnd = 3;
		}

		realEnd = (int) (Math.ceil(total / pageInfo.getPerSheet()));

		end = tempEnd < realEnd ? tempEnd : realEnd;

		prev = start != 1;

		next = end < realEnd ? true : false;

	}

}
