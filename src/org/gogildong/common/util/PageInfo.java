package org.gogildong.common.util;

import lombok.Getter;
import lombok.Builder.Default;
import lombok.Data;

@Data
public class PageInfo {

	private Long sno;
	private int page;
	private int perSheet;

	public void setPage(int page) {

		if (page <= 0) {
			this.page = 1;
			return;
		}

		this.page = page;
	}

	public void setPerSheet(int perSheet) {

		if (perSheet > 100) {
			this.perSheet = 100;
			return;
		}

		if (perSheet < 3) {

			this.perSheet = 3;
			return;
		}

		this.perSheet = perSheet;
	}

}
