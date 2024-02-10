package com.service;

import com.common.JDBCTemplate;
import com.dao.UserDao;
import com.model.User;

import java.sql.Connection;
import java.util.ArrayList;


public class UserService {
    public int insertMember(User user) {
        Connection conn = JDBCTemplate.getConnection();

        int result = new UserDao().insertMember(conn, user);

        if(result > 0) {			// 회원 추가 성공
            JDBCTemplate.commit(conn);
        } else {					// 회원 추가 실패
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);

        return result;
    }
    public ArrayList<User> selectAllList() {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<User> list = new UserDao().selectAllList(conn);
        JDBCTemplate.close(conn);

        return list;
    }
}
