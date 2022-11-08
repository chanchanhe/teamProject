package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.KoreaMemberDao;

public class memberDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		
		 String id = request.getParameter("id");
         new KoreaMemberDao().deleteOne(id);
         forward.setPath(request.getContextPath() + "/managepage.member");
         return forward;      
	}

}
