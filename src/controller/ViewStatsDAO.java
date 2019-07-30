/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author justj
 */
public class ViewStatsDAO extends BaseDAO {

    public ViewStatsDAO() {
    }

    public ArrayList<HashMap> getStats(boolean sortByScore, boolean sortByStage) throws SQLException {
        ArrayList<HashMap> hms = new ArrayList<>();
        String sql = "";
        if (sortByStage) {
            sql = "SELECT * from lap "
                    + "INNER JOIN "
                    + "((SELECT DISTINCT T.ID AS 'RegisterID', T.StageID, team.Name AS 'Team Name', team.ID AS 'Team ID', racer.Name as 'Racer Name' "
                    + "from racer "
                    + "INNER JOIN team "
                    + "INNER JOIN (SELECT stage_register.StageID, register.ID, register.TeamID, register.RacerID from register "
                    + "INNER JOIN stage_register "
                    + "ON register.ID = stage_register.RegisterID ORDER BY `stage_register`.`StageID` ASC) AS T "
                    + "WHERE racer.ID = T.RacerID AND racer.TeamID = team.ID ORDER BY T.StageID ASC) AS Z) "
                    + "ON lap.RegisterID = Z.RegisterID";
        }
        if (sortByScore) {
            sql = "SELECT * from lap INNER JOIN ((SELECT DISTINCT T.ID AS 'RegisterID', T.StageID, team.Name AS 'Team Name', team.ID AS 'Team ID', racer.Name as 'Racer Name' from racer INNER JOIN team INNER JOIN (SELECT stage_register.StageID, register.ID, register.TeamID, register.RacerID from register INNER JOIN stage_register ON register.ID = stage_register.RegisterID ORDER BY `stage_register`.`StageID` ASC) AS T WHERE racer.ID = T.RacerID AND racer.TeamID = team.ID ORDER BY T.StageID ASC) AS Z) ON lap.RegisterID = Z.RegisterID ORDER BY lap.TotalScore ASC";
        }
        Statement statement = getStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            HashMap<String, String> hm = new HashMap<>();
            hm.put("RegisterID", Integer.toString(rs.getInt(5)));
            hm.put("StageID", Integer.toString(rs.getInt(6)));
            hm.put("TeamName", rs.getString(7));
            hm.put("TeamID", Integer.toString(rs.getInt(8)));
            hm.put("RacerName", rs.getString(9));
            hm.put("TotalScore", Float.toString(rs.getFloat(3)));
            hm.put("TotalFaults", Integer.toString(rs.getInt(4)));
            hms.add(hm);
        }
        rs.close();
        cleanEnvironment(statement, null);
        return hms;
    }
}
