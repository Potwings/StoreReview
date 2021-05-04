package org.gogildong.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.gogildong.common.controller.MultiController;
import org.gogildong.review.dao.ReviewDAO;
import org.gogildong.review.domain.Like;
import org.gogildong.review.domain.Review;

import lombok.extern.log4j.Log4j;

@WebServlet("/review/*")
@MultipartConfig(location = "C:\\upload")
public class ReviewController extends MultiController {
	private static final long serialVersionUID = 1L;

	private ReviewDAO reviewDAO = new ReviewDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public String registerGET(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long sno = Long.parseLong(request.getParameter("sno"));

		request.setAttribute("sno", sno);

		return "review/register";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public String registerPOST(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		try {
//
//			Collection<Part> parts = request.getParts();
//
//			parts.forEach(part -> {
//
//				System.out.println(part);
//
//				String fileName = part.getSubmittedFileName();
//
//				if (fileName != null) {
//					System.out.println(fileName);
//					try {
//						part.write(fileName);
//					} catch (Exception e) {
//						System.out.println(e.getMessage());
//					}
//				} else {
//
//					String partName = part.getName();
//
//					String value = request.getParameter(partName);
//
//					System.out.println("--------------------------" + value);
//
//				}
//
//				System.out.println("---------------------------");
//
//			});
//
//			return "re:/store/info?sno=11";
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return "re:/store/list";
//	}

		Review review = new Review();

		request.setCharacterEncoding("UTF-8");
		Long sno = Long.parseLong(request.getParameter("sno"));
		Part filepart = request.getPart("file");
		String fileName = filepart.getSubmittedFileName();
		filepart.write(fileName);

		review.setSno(sno);
		review.setMid(request.getParameter("mid"));
		review.setContext(request.getParameter("context"));
		review.setScore(getInt(request, "score", 5));
		review.setImg(fileName);

		reviewDAO.insertReview(review);

		return "re:/store/info?sno=" + sno;
	}

	public String deletePOST(HttpServletRequest req, HttpServletResponse res) throws IOException {

		Long sno = Long.parseLong(req.getParameter("sno"));

		Long rno = Long.parseLong(req.getParameter("rno"));

		String reviewmid = req.getParameter("mid");

		HttpSession session = req.getSession();

		String realmid = (String) (session.getAttribute("mid"));

		if (reviewmid.equals(realmid)) {
			reviewDAO.deleteReview(rno);
		} else {
			return "review/error";
		}
		return "re:/store/info?sno=" + sno;

	}

	public String viewGET(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Long rno = Long.parseLong(request.getParameter("rno"));

		Review review = reviewDAO.getOneReview(rno);

		request.setAttribute("review", review);

		return "/review/view";
	}

	public String likePOST(HttpServletRequest req, HttpServletResponse res) throws IOException {

		
		String referer = req.getHeader("Referer");
		
		Long rno = Long.parseLong(req.getParameter("rno"));
		String mid = req.getParameter("mid");
		int value = Integer.parseInt(req.getParameter("value"));
		
		System.out.println(value);
		
		System.out.println(mid);
		System.out.println(rno);
		
		Like like = Like.builder().rno(rno).mid(mid).build();

		Like realLike = reviewDAO.selectLike(like);
		
		if (mid!="") {
				if (realLike == null) {
				reviewDAO.insertLike(like);

			} else if (realLike.getValue() == 1L) {
				reviewDAO.disLike(like);

			} else {
				reviewDAO.updateLike(like);

			}
		} else {
			return "re:/member/login";

		}
		return "re:"+referer;


	}

}
