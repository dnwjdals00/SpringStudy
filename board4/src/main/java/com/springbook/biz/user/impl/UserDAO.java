  
package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

//@Repository("userDAO")
public class UserDAO {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	private final String USER_GET ="select * from users where id=? and password=?";

	public UserVO getUser(UserVO vo) {//Integer,String, UserVO,BoardVO,
		 UserVO user=null;
		 try {
			   System.out.println("===>JDBC로 getUser() 기능 처리");
			   conn=JDBCUtil.getConnection();
			   pstmt=conn.prepareStatement(USER_GET);
			   pstmt.setString(1, vo.getId());
			   pstmt.setString(2, vo.getPassword());
			   rs=pstmt.executeQuery();
			 if(rs.next()) {
				 user=new UserVO();
				 user.setId(rs.getString("id"));
				 user.setPassword(rs.getString("password"));
				 user.setName(rs.getString("name"));
				 user.setRole(rs.getString("role"));
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 JDBCUtil.close(rs, pstmt, conn);
		 }
		return user;
	}
	
	
	

}
