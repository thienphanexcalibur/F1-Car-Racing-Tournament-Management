/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author justj
 */
public class TeamRacerDAO extends BaseDAO {

    public TeamRacerDAO() {
    }

    public ArrayList<Team> getTeams(Tournament tournament) throws SQLException {
        ArrayList<Team> teams = new ArrayList<>();
        String sql = "SELECT * from team";
        Statement statement = null;
        try {
            statement = getStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                teams.add(new Team(rs.getInt(1), tournament, rs.getString(3), rs.getString(4)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeamRacerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        cleanEnvironment(statement, null);
        return teams;
    }

    public Manager getManager() throws SQLException {
        Manager manager = null;
        String sql = "SELECT account.id, account.name, manager.ID from account INNER JOIN manager ON manager.accountID = account.id";
        Statement statement = getStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            manager = new Manager(rs.getInt(3), new Account(rs.getInt(1), rs.getString(2), "", "", "", ""));
        }
        rs.close();
        cleanEnvironment(statement, null);
        return manager;
    }

    public ArrayList<Racer> getAllRacers() throws SQLException {
        ArrayList<Racer> racers = new ArrayList<>();
        String sql = "SELECT * from racer";
        Statement statement = getStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Supporter supporter = new Supporter(0, null, null, null);
            supporter.setID(rs.getInt(2));
//            Team team = new Team();
//            racers.add(new Racer(rs.getInt(1), supporter, new Team().setID(rs.getInt(3)), rs.getString(4), rs.getString(5), rs.getString(6)));
        }
        return null;
    }

    public void removeTeam(Team team) throws SQLException {
        String sql = "DELETE FROM team WHERE team.ID = ?";
        PreparedStatement ps = getPreparedStatement(sql);
        ps.setInt(1, team.getID());
        ps.execute();
    }

    public boolean addTeam(Team team, ArrayList<Racer> racers) throws SQLException {
        int resultRacer = -1;
        int resultTeam = -1;
        String queryTeam = "INSERT INTO team(TournamentID, Name, Description) VALUES (?, ?,?)";
        String queryRacer = "INSERT INTO racer(TeamID, Name, Dob, Experience) VALUES (?,?,?,?)";
        PreparedStatement psTeam = getPreparedStatement(queryTeam);
        PreparedStatement psRacer = getPreparedStatement(queryRacer);
        int tournamentID = team.getTournament().getID();
        psTeam.setInt(1, tournamentID);
        psTeam.setString(2, team.getName());
        psTeam.setString(3, team.getDescription());
        resultTeam = psTeam.executeUpdate();
        if (resultTeam != 0) {
            ResultSet rs = psTeam.getGeneratedKeys();
            while (rs.next()) {
                int key = rs.getInt(1);
                for (Racer rc : racers) {
                    psRacer.setInt(1, key);
                    psRacer.setString(2, rc.getName());
                    psRacer.setString(3, rc.getDob());
                    psRacer.setInt(4, rc.getExperience());
                    resultTeam = psRacer.executeUpdate();
                    System.out.println(resultRacer);
                }
            }
            rs.close();
        }
        cleanEnvironment(null, psTeam);
        cleanEnvironment(null, psRacer);
        System.out.println(resultTeam);
        return resultTeam == 1 && resultRacer == 1;
    }
}
