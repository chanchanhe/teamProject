package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.KoreaMemberDao;
import kr.or.kosa.dto.KoreaMember;

public class joinok implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id"); 
        String pwd = request.getParameter("pwd"); 
        String name = request.getParameter("mname"); 
        int age = Integer.parseInt(request.getParameter("age")); 
        String gender = request.getParameter("gender"); 
        String email = request.getParameter("email"); 
        String ip = request.getRemoteAddr().toString();
        KoreaMember koreaMember = new KoreaMember(id, pwd, name, age, gender, email, ip);
        
        int result = new KoreaMemberDao().saveOne(koreaMember);
        
        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        
        if (result > 0) {
           forward.setPath(request.getContextPath() + "/loginpage.member");
        } else {
           forward.setPath(request.getContextPath() + "/joinformpage.member");
           
        }
        return forward;
	}
}
