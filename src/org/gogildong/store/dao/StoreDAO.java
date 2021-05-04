package org.gogildong.store.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.gogildong.common.dao.MyBatisMaker;
import org.gogildong.common.util.PageInfo;
import org.gogildong.store.domain.Store;

public class StoreDAO {
	
	private static final String NAMESPACE = "org.gogildong.store.dao.StoreMapper";

	public List<Store> getList(PageInfo pageInfo) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectList(NAMESPACE + ".getList",pageInfo);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;

	}
	
	public Store getOne(Long sno) {
		
		try {SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession();
		
			return session.selectOne(NAMESPACE + ".getOne", sno);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getCount() {
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()){
			
			return session.selectOne(NAMESPACE+".getCount");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
