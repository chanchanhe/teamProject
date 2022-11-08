package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.KoreaMemberDao;
import kr.or.kosa.dto.KoreaMember;

public class memberDetail implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();
    forward.setRedirect(false);
	String session = (String) request.getSession().getAttribute("userid");
	
    if (session == null || !session.equals("admin")) {
       forward.setPath(request.getContextPath() + "/loginpage.member");
    } else {
       String id = request.getParameter("id");
       KoreaMember koreaMember = new KoreaMemberDao().findOne(id);
       request.setAttribute("member", koreaMember);
       forward.setPath("WEB-INF/views/Ex03_MemberDetail.jsp");
    }
    return forward;
  } 
}
