/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author justj
 */
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {

    public BaseDAO() {

    }

    Statement getStatement() throws SQLException {
        return connection.getMySQLConnection().createStatement();
    }

    PreparedStatement getPreparedStatement(String statement) throws SQLException {
        return connection.getMySQLConnection().prepareStatement(
                statement,
                Statement.RETURN_GENERATED_KEYS
        );
    }

    void cleanEnvironment(Statement statement, PreparedStatement preparedStatement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
