package fr.thombsi.foutoir.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOUtils {

    public static PreparedStatement initPrepRequest(
            Connection connection,
            String sql,
            boolean returnGeneratedKey,
            Object... objects )
            throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(
                sql,
                returnGeneratedKey ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
        for ( int i = 0; i < objects.length; i++ ) {
            preparedStatement.setObject( i + 1, objects[i] );
        }
        return null;
    }

    public static void close( ResultSet resultSet ) {
        if ( resultSet != null ) {
            try {
                resultSet.close();
            } catch ( SQLException e ) {
                System.out.println( "Echec de fermeture du ResultSet " + e.getMessage() );
            }
        }
    }

    public static void close( Statement statement ) {
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException e ) {
                System.out.println( "Echec de fermeture du Statement " + e.getMessage() );
            }
        }
    }

    public static void close( Connection connection ) {
        if ( connection != null ) {
            try {
                connection.close();
            } catch ( SQLException e ) {
                System.out.println( "Echec de fermeture de la connexion " + e.getMessage() );
            }
        }
    }

    public static void close( Connection connection, Statement statement ) {
        close( connection );
        close( statement );
    }

    public static void close( Connection connection, Statement statement, ResultSet resultSet ) {
        close( connection );
        close( resultSet );
        close( statement );
    }
}
