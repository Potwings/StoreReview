package org.gogildong.member.controller;

import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gogildong.common.controller.MultiController;
import org.gogildong.member.dao.MemberDAO;
import org.gogildong.member.domain.Member;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member/*")
public class MemberController extends MultiController {
	private static final long serialVersionUID = 1L;

	private MemberDAO memberDAO = new MemberDAO();

	/**
	 * @see MultiController#MultiController()
	 */
	public MemberController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public String loginGET(HttpServletRequest request, HttpServletResponse response) {

		String referer = request.getHeader("REFERER");
		
		System.out.println(referer);

//		Long sno = Long.parseLong(request.getParameter("sno"));
//		
//		Store store = storeDAO.getOne(sno);
		
		HttpSession session = request.getSession();

		session.setAttribute("referer", referer);
		
//		request.setAttribute("referer", referer);

		return "member/login";
	}

	public String loginPOST(HttpServletRequest request, HttpServletResponse response) {
		try {

//			Long sno = Long.parseLong(request.getParameter("sno"));

//			Store store = storeDAO.getOne(sno);

			HttpSession session = request.getSession();
			
			String referer = (String)(session.getAttribute("referer"));

//			String referer = request.getParameter("referer");
			
			
			System.out.println(referer);

			Member checkmember = new Member();
			
			String mid = request.getParameter("mid");
			
			String mpw = request.getParameter("mpw");

			checkmember.setMid(mid);
			checkmember.setMpw(mpw);
			
			Member realmember = memberDAO.checkID(checkmember);
			
			if(realmember == null)
			{ 
				
				return "member/login";
			
			}else {

			session.setAttribute("mid", mid);

//			session.setAttribute("store", store);

			return "re:" + referer;}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login/login";
	}
	
	public String logoutGET(HttpServletRequest req, HttpServletResponse res) {
		
		HttpSession session = req.getSession();
		
		session.invalidate();
		
		String referer = req.getHeader("Referer");
		
		
		return "re:"+referer;
	}

}
