package org.gogildong.member.domain;

import java.sql.Date;

import lombok.Data;


@Data
public class Member {

	private String mid,mpw,mname,email;
	private Date regdate, updateDate;
}
