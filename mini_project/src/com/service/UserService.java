package com.service;

import com.common.JDBCTemplate;
import com.dao.UserDao;
import com.model.User;

import java.sql.Connection;
import java.util.ArrayList;


public class UserService {

    public User user;

    public int insertUser(User user) {
        Connection conn = JDBCTemplate.getConnection();
        int result = new UserDao().insertUser(conn, user);

        if(result > 0) {			// 회원 추가 성공
            JDBCTemplate.commit(conn);
        } else {					// 회원 추가 실패
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);

        return result;
    }

    public User login(String userId, String pw) {
        Connection conn = JDBCTemplate.getConnection();
        User user = new UserDao().login(conn, userId, pw);
        JDBCTemplate.close(conn);
        this.user = user;
        return user;
    }
}
