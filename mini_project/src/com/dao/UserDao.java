package com.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		/**
		 * 회원 추가 메소드 (사용자가 입력한 데이터들을 DB에 추가)
		 * @param conn, m : Connection 객체와 사용자가 입력한 데이터(Member)
		 * @return result : 처리된 행 수 (회원 추가 결과)
		 */
		public int insertMember(Connection conn, User user) {
			// PreparedStatement 객체 생성
			PreparedStatement pstmt = null;
			
			int result = 0;
			String sql = prop.getProperty("InsertUser");
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getPasswd());
				pstmt.setString(3, user.getName());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			
			return result;
		}
		
		/**
		 * 회원 전체 목록 조회
		 * @param conn : Connection 객체
		 * @return list : 회원 전체 목록을 담은 ArryaList<Member> 타입의 데이터
		 */
		public ArrayList<User> selectAllList(Connection conn){
			ArrayList<User> list = new ArrayList<>();

			PreparedStatement pstmt = null;
			ResultSet rset = null;

			//String sql = "SELECT * FROM MEMBER ORDER BY USERNO";
			String sql = prop.getProperty("selectAllList");
			System.out.println(sql);
			try {
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery(sql);

				while(rset.next()) {			// .next():데이터가 있는지 여부 체크
					User user = new User();
					user.setUserId(rset.getString("USER_ID"));
					user.setPasswd(rset.getString("PASSWD"));
					user.setName(rset.getString("NAME"));
					list.add(user);
				}

			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return list;
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
	}
