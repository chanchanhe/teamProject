package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.KoreaMemberDao;
import kr.or.kosa.dto.KoreaMember;

public class memberEditPage implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String session = (String) request.getSession().getAttribute("userid");
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		 
        if (session == null || !session.equals("admin")) {
           forward.setPath(request.getContextPath() + "/loginpage.member");
        } else {
           String id = request.getParameter("id");
           KoreaMember km = new KoreaMemberDao().findOne(id);
           request.setAttribute("member", km);
          
          // forward.setPath("WEB-INF/views/Ex03_MemberEdit.jsp");
           forward.setPath("WEB-INF/views/Ex03_MemberEdit.jsp");
        }
        return forward;
	}

}
