package org.gogildong.review.dao.test;

import java.util.List;

import org.gogildong.common.util.PageInfo;
import org.gogildong.review.dao.ReviewDAO;
import org.gogildong.review.domain.Like;
import org.gogildong.review.domain.Review;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class ReviewDAOTests {

	private ReviewDAO dao;
	@Before
	public void ready() {
		dao = new ReviewDAO();
	}
	
	@Test
	public void testgetReview() {
		
		Long sno = 9L;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(1);
		pageInfo.setPerSheet(3);
		
		pageInfo.setSno(sno);
		
		List<Review> reviews = dao.getReviewList(pageInfo);
		
		for (Review review : reviews) {
			log.info(review);
		}
	
		
	}
	
	@Test
	public void testdelete() {
		Long rno = 59L;
		
		dao.deleteReview(rno);
	}
	
	@Test
	public void testInsert() {
		Review review = Review.builder()
				.sno(10L)
				.mid("ygk")
				.context("test")
				.score(5)
				.img("/upload/test.jpg")
				.build();
		
		dao.insertReview(review);
				
	}
	
	@Test
	public void testgetOne() {
		
		Long rno = 171L;
		Review review = dao.getOneReview(rno);
		
		log.info(review);
		
	}
	
	@Test
	public void testgetValue() {
		
		Long rno = 10L;
		String mid = "test";
		
		Like like = Like.builder().mid(mid).rno(rno).build();
		
		int value = dao.getValue(like);
		
		log.info(value);
		
		
	}
	
}
