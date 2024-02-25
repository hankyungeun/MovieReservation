package com.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.common.JDBCTemplate;
import com.model.User;



public class UserDao {

		private Properties prop = new Properties();
		
		public UserDao() {
			//xml읽기
			try {
				prop.loadFromXML(new FileInputStream("/Users/hangyeong-eun/Documents/dev/MovieReservation/mini_project/resources/query.xml"));
				
			} catch (InvalidPropertiesFormatException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 회원가입
		public int insertUser(Connection conn, User user) {
			// PreparedStatement 객체 생성
			PreparedStatement pstmt = null;
			
			int result = 0;
			String sql = prop.getProperty("insertUser");
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getPasswd());
				pstmt.setString(3, user.getName());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLIntegrityConstraintViolationException e){
				System.out.println("\n이미 존재하는 사용자입니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			
			return result;
		}
		
		public int deleteMember(Connection conn, String userId) {
			PreparedStatement pstmt = null;
			int result = 0;
			String sql = "DELETE FROM MEMBER WHERE USERID = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				result = pstmt.executeUpdate();
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}

		// 로그인
		public User login(Connection conn, String userId, String passwd) {
			User result = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			String sql = prop.getProperty("login");

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setString(2, passwd);
				rset = pstmt.executeQuery();
				if (rset.next()) {
					User user = new User();
					user.setUserId(rset.getString("USER_ID"));
					user.setPasswd(rset.getString("PASSWD"));
					user.setName(rset.getString("NAME"));
					result = user;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return result;
		}
	}
