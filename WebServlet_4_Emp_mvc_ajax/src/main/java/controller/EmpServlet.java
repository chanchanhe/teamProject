package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dto.Emp;

@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EmpServlet() {
        super();
        
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
  	    response.setContentType("text/html;charset=UTF-8"); //클라언트에게 전달한 페이지의 정보 구성
  	    PrintWriter out = response.getWriter();
  	    
  	    String empno = request.getParameter("empno");
  	    
  	    EmpDao emp = new EmpDao();
  	    List<Emp> empSereach = emp.getEmpListById(Integer.parseInt(empno));
 	    
  	    request.setAttribute("empSereach", empSereach);
  	    
  	    RequestDispatcher dis = request.getRequestDispatcher("/Ex06_EmpSearch.jsp");
  	    dis.forward(request, response);
  	    
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
