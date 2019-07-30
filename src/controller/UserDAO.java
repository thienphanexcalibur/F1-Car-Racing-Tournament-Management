/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author justj
 */
public class UserDAO extends BaseDAO {

    private String username;
    private String password;

    public UserDAO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate() throws SQLException {
        boolean hasResult = false;
        String sql = "SELECT * from account WHERE account.Username = ? AND account.Password = ?";
        PreparedStatement ps = getPreparedStatement(sql);
        ps.setString(1, this.username);
        ps.setString(2, this.password);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            hasResult = rs.first();
        }
        rs.close();
        cleanEnvironment(null, ps);
        return hasResult;
    }

}
