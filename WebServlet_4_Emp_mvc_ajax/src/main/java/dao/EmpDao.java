package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Emp;
import utils.SingletonHelper;


public class EmpDao {
    Connection conn = null;
	    
    public EmpDao() {
    	conn = SingletonHelper.getConnection("oracle");
    }

    public List<Emp> getEmpListById(int empno){	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Emp> emplist = new ArrayList<Emp>();
		
		try {
			Emp emp = null;
			
			pstmt = conn.prepareStatement("select empno , ename , sal , job from emp where empno like ? || '%' ");
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			
	        while(rs.next()) {
	        	emp = new Emp();
	        	emp.setEmpno(rs.getInt("empno"));
	        	emp.setEname(rs.getString("ename"));
	        	emp.setSal(rs.getInt("sal"));
	        	emp.setJob(rs.getString("job")); 
	        	
	        	emplist.add(emp);
	        }
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				SingletonHelper.close(rs);
				SingletonHelper.close(pstmt);
			}
			
			return emplist;
	}
	
}
