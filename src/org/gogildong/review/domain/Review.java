package org.gogildong.review.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	
	private Long rno,sno;
	private String mid,context,img;
	private int score;
	private Date regdate, updateDate;
	private int lcount;
	private Like like;
	private int value;
	
	
	
	
	

}
