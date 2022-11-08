package kr.or.kosa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.service.Memberlist;
import kr.or.kosa.service.joinok;
import kr.or.kosa.service.loginok;
import kr.or.kosa.service.memberDelete;
import kr.or.kosa.service.memberDetail;
import kr.or.kosa.service.memberEditPage;
import kr.or.kosa.service.memberEditok;
import kr.or.kosa.service.memberSearch;

@WebServlet("*.member")
public class KoreaMemberController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public KoreaMemberController() {
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
       String requestURI = request.getRequestURI();
       String conntextPath = request.getContextPath();
       String urlcommand = requestURI.substring(conntextPath.length());
      
	   Action action=null;
	   ActionForward forward=null;
	   
	   String session = null;
      
//      request.setCharacterEncoding("UTF-8");
      
      if (urlcommand.equals("/managepage.member")) { // 관리 페이지 가기
        action = new Memberlist();
        forward = action.execute(request, response);
      } else if (urlcommand.equals("/mainpage.member")) { // 메인페이지 가기
        forward = new ActionForward();
 		forward.setRedirect(false);
 		forward.setPath("/Ex02_JDBC_Main.jsp");
		
      } else if (urlcommand.equals("/loginpage.member")) { // 로그인 페이지 가기
        
         session = (String) request.getSession().getAttribute("userid");
		 forward = new ActionForward();
		 
        if (session == null) { //로그인 페이지 가기!!
           forward.setPath("WEB-INF/views/Ex02_JDBC_Login.jsp");
        } else { // 메인 페이지로 가기
           forward.setPath(request.getContextPath() + "/mainpage.member");
        }
        
      } else if (urlcommand.equals("/joinformpage.member")) { // 가입 페이지 가기
	     session = (String) request.getSession().getAttribute("userid");
		 forward = new ActionForward();
		 forward.setRedirect(false); 
		 
	        if (session == null) { // 가입 페이지로 가기
	           forward.setPath("WEB-INF/views/Ex02_JDBC_JoinForm.jsp");
	           
	        } else { // 메인 페이지로 가기
	           forward.setPath(request.getContextPath() + "/mainpage.member");
	        }
	             
      } else if (urlcommand.equals("/joinok.member")) { // 회원가입 요청
        action = new joinok();
        forward = action.execute(request, response); 
      } else if (urlcommand.equals("/loginok.member")) { // 로그인 요청
         action = new loginok();
         forward = action.execute(request, response);        
      } else if(urlcommand.equals("/logout.member")) { // 로그아웃 요청
		request.getSession().invalidate();	
        forward = new ActionForward();
        forward.setRedirect(false);
    	forward.setPath(request.getContextPath() + "/loginpage.member");   	
      } else if(urlcommand.equals("/memberDetail.member")) { // 멤버 상세 페이지 요청
         action = new memberDetail();
         forward = action.execute(request, response);
      } else if(urlcommand.equals("/memberDelete.member")) { // 회원 삭제   	  
    	  action = new memberDelete();
          forward = action.execute(request, response);       
      } else if(urlcommand.equals("/memberEditPage.member")) { // 수정 페이지 요청
         action = new memberEditPage();
         forward = action.execute(request, response);   
      } else if(urlcommand.equals("/memberEditok.member")) { // 회원 수정
         action = new memberEditok();
         forward = action.execute(request, response);   
      } else if (urlcommand.equals("/memberSearch.member")) { // 회원검색
    	  action = new memberSearch();
          forward = action.execute(request, response);  
      }
      
      if(forward != null) {
  		if(forward.isRedirect()) { //true 페이지 재 요청 (location.href="페이지"
  			response.sendRedirect(forward.getPath());
  		}else { //기본적으로 forward ....
  			    //1. UI 전달된 경우
  			    //2. UI + 로직
  			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
  			dis.forward(request, response);
  		}
  	}
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request, response);
   }

}