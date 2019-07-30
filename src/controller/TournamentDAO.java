/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;

/**
 *
 * @author justj
 */
public class TournamentDAO extends BaseDAO {

    public TournamentDAO() {
    }

    public Tournament getTournament() throws SQLException {
        Tournament tournament = null;
        String sql = "SELECT * from tournament";
        Statement statement = getStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            tournament = new Tournament(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        }
        rs.close();
        cleanEnvironment(statement, null);
        return tournament;
    }
}
