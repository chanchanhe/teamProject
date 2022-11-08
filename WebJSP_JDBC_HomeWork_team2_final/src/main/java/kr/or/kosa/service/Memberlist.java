package kr.or.kosa.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.KoreaMemberDao;
import kr.or.kosa.dto.KoreaMember;

public class Memberlist implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		 String session = (String) request.getSession().getAttribute("userid");
		 ActionForward forward = new ActionForward();
		 forward.setRedirect(false);
		 
         if (session == null || !session.equals("admin")) {
        	 forward.setPath(request.getContextPath() + "/loginpage.member");
         } else { // 회원 리스트 페이지
            List<KoreaMember> list = new KoreaMemberDao().findAll();
            request.setAttribute("list", list);
            forward.setPath("WEB-INF/views/Ex03_Memberlist.jsp");
         }
		     
        return forward;
	}

}
