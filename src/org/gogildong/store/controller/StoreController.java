package org.gogildong.store.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gogildong.common.controller.MultiController;
import org.gogildong.common.util.PageInfo;
import org.gogildong.common.util.PageMaker;
import org.gogildong.review.dao.ReviewDAO;
import org.gogildong.review.domain.Like;
import org.gogildong.review.domain.Review;
import org.gogildong.store.dao.StoreDAO;
import org.gogildong.store.domain.Store;

/**
 * Servlet implementation class StoreController
 */
@WebServlet("/store/*")
public class StoreController extends MultiController {
	private static final long serialVersionUID = 1L;

	private StoreDAO storeDAO = new StoreDAO();

	private ReviewDAO reviewDAO = new ReviewDAO();

	public String listGET(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int total = storeDAO.getCount();

		PageInfo pageInfo = new PageInfo();

		pageInfo.setPage(getInt(req, "page", 1));
		pageInfo.setPerSheet(getInt(req, "persheet", 3));

		PageMaker pageMaker = new PageMaker(pageInfo, total);

		List<Store> stores = storeDAO.getList(pageInfo);

		req.setAttribute("pageMaker", pageMaker);
		req.setAttribute("stores", stores);

		return "store/list";
	}

	public String infoGET(HttpServletRequest req, HttpServletResponse res) {

		Long sno = Long.parseLong(req.getParameter("sno"));
		
		Store store = storeDAO.getOne(sno);
		
		int total = reviewDAO.getTotal(sno);
		
		PageInfo pageInfo = new PageInfo();
		
		pageInfo.setPage(getInt(req, "page", 1));
		pageInfo.setPerSheet(getInt(req, "persheet", 3));
		pageInfo.setSno(sno);
		
		PageMaker pageMaker = new PageMaker(pageInfo,total);
		
		List<Review> reviews = reviewDAO.getReviewList(pageInfo);

		HttpSession session = req.getSession();

		String mid = (String) (session.getAttribute("mid"));

		List<Review> newreviews = new ArrayList<>();

		for (Review review : reviews) {

			Long rno = review.getRno();

			Like like = Like.builder().rno(rno).mid(mid).build();

			int value = reviewDAO.getValue(like);

			review.setValue(value);

			newreviews.add(review);

		}
		
		
		req.setAttribute("pageMaker", pageMaker);

		req.setAttribute("reviews", newreviews);

		req.setAttribute("store", store);

		return "store/info";

//		
//		List<Like> realLikes = new ArrayList<Like>();
//		
//		for (Review review : reviews) {
//			Long rno = review.getRno();
//			
//			String mid = review.getMid();
//			
//			Like like = Like.builder().rno(rno).mid(mid).build();
//
//			Like realLike = reviewDAO.selectLike(like);
//			
//			realLikes.add(realLike);
//		}
//		
//		for (Like like : realLikes) {
//			
//		}
//		
	}

}
