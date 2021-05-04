package org.gogildong.store.dao.test;

import java.util.List;

import org.gogildong.common.util.PageInfo;
import org.gogildong.common.util.PageMaker;
import org.gogildong.store.dao.StoreDAO;
import org.gogildong.store.domain.Store;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.log4j.Log4j;
@Log4j
public class StoreTests {
	
	private StoreDAO dao;
	@Before
	public void ready() {
		
		dao = new StoreDAO();
	}
	
	@Test
	public void testList() {
		
		int total = dao.getCount();
		
		PageInfo pageInfo = new PageInfo();

		pageInfo.setPage(1);
		pageInfo.setPerSheet(10);
		
		List<Store> stores = dao.getList(pageInfo);
		
		for (Store store : stores) {
			log.info(store);
		}
	}
	
	@Test
	public void testOne() {
		
		Store store = dao.getOne(9L);
		
		log.info(store);
	}

}
