/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.*;
import java.util.ArrayList;

/**
 *
 * @author justj
 */
public class RegisterDAO extends BaseDAO {

    public RegisterDAO() {

    }

    public ArrayList<Stage> getStages() throws SQLException {
        ArrayList<Stage> stages = new ArrayList<>();
        String sql = "SELECT * from stage";
        Statement statement = getStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            stages.add(new Stage(rs.getInt(1), rs.getInt(2)));
        }
        rs.close();
        cleanEnvironment(statement, null);
        return stages;
    }

    public ArrayList<Racer> getRacers(Team team) throws SQLException {
        ArrayList<Racer> racers = new ArrayList<>();
        String sql = "SELECT * from racer WHERE racer.TeamID = ?";
        PreparedStatement ps = getPreparedStatement(sql);
        ps.setInt(1, team.getID());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            racers.add(new Racer(rs.getInt(1), team, rs.getString(3), rs.getString(4), rs.getInt(5)));

        }
        rs.close();
        cleanEnvironment(null, ps);
        return racers;
    }

    public ArrayList<Register> createRegister(Team team, ArrayList<Racer> racers) throws SQLException {
        ArrayList<Register> registers = new ArrayList<>();
        for (Racer r : racers) {
            String sql = "INSERT INTO register (teamID, racerID) VALUES (?,?)";
            PreparedStatement ps = getPreparedStatement(sql);
            ps.setInt(1, team.getID());
            ps.setInt(2, r.getID());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                int key = rs.getInt(1);
                registers.add(new Register(key, racers, team));
            }
            rs.close();
        }
//        cleanEnvironment(null, ps);
        return registers;
    }

    public int registerStage(Stage stage, ArrayList<Register> registers) throws SQLException {
        int result = 0;
        String sql = "INSERT INTO stage_register (StageID, RegisterID) VALUES(?, ?)";
        PreparedStatement ps = getPreparedStatement(sql);
        for (Register reg : registers) {
            ps.setInt(1, stage.getID());
            ps.setInt(2, reg.getID());
            result = ps.executeUpdate();
        }
        cleanEnvironment(null, ps);
        return result;
    }

    public ArrayList<Team> getUnregisteredTeam(Stage stage, Tournament tournament) throws SQLException {
        System.out.println(stage.getID());
        ArrayList<Team> teams = new ArrayList<>();
        String sql = "SELECT * FROM team WHERE team.id NOT IN (SELECT DISTINCT register.TeamID FROM register INNER JOIN stage_register ON stage_register.StageID = ?)";
        PreparedStatement ps = getPreparedStatement(sql);
        ps.setInt(1, stage.getID());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            teams.add(new Team(rs.getInt(1), tournament, rs.getString(3), rs.getString(4)));
        }
        rs.close();
        cleanEnvironment(null, ps);
        return teams;
    }
}
