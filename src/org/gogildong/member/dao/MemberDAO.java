package org.gogildong.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.gogildong.common.dao.MyBatisMaker;
import org.gogildong.member.domain.Member;

public class MemberDAO {
	
	private static final String NAMESPACE = "org.gogildong.member.dao.MemberMapper";
	
	public Member checkID(Member member) {
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			return session.selectOne(NAMESPACE+ ".checkID", member);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
