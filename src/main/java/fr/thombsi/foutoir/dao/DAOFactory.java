package fr.thombsi.foutoir.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory {
    public static final String PROPERTY_FILE  = "/fr/thombsi/foutoir/dao/dao.properties";
    public static final String PROP_URL       = "url";
    public static final String PROP_DRIVER    = "driver";
    public static final String PROP_USER_NAME = " username";
    public static final String PROP_PASS      = "pass";

    private String             url;
    private String             userName;
    private String             pass;

    public DAOFactory( String url, String userName, String pass ) {
        this.url = url;
        this.userName = userName;
        this.pass = pass;
    }

    /**
     * Méthode chargée de récupérer les informations de connection à la BDD, de
     * charger le driver et de retourner une intance de DAOFactory.
     * 
     * @return instance de DAOFactory
     * @throws DAOConfigurationException
     */
    public static DAOFactory getInstance() throws DAOConfigurationException {
        Properties properties = new Properties();
        String url;
        String driver;
        String userName;
        String pass;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertyFile = classLoader.getResourceAsStream( PROPERTY_FILE );
        if ( propertyFile == null ) {
            throw new DAOConfigurationException( "Le fichier de propriétés " + PROPERTY_FILE + " est introuvable.", e );
        }
        try {
            properties.load( propertyFile );
            url = properties.getProperty( PROP_URL );
            driver = properties.getProperty( PROP_DRIVER );
            userName = properties.getProperty( PROP_USER_NAME );
            pass = properties.getProperty( PROP_PASS );
        } catch ( IOException e ) {
            throw new DAOConfigurationException( "Impossible de charger le fichier de propriétés" + PROPERTY_FILE, e );
        }
        try {
            Class.forName( driver );
        } catch ( ClassNotFoundException e ) {
            throw new DAOConfigurationException( "Le driver est introuvable dans le classPath", e );
        }
        DAOFactory instance = new DAOFactory( url, userName, pass );
        return instance;
    }

    /**
     * Récupère la connection à la BDD qui a été établie.
     * 
     * @return
     * @throws SQLException
     */
    Connection getConnection() throws SQLException {
        return DriverManager.getConnection( url, userName, pass );
    }

    /**
     * Récupère l'implémentation du DAO pour les Customer.
     * 
     * @return
     */
    public CustomerDAO getCustomerDAO() {
        return new CustomerDAOImpl( this );
    }

    /**
     * Récupère l'implémentation du DAO pour les order.
     * 
     * @return
     */
    public CustomerDAO getOrderDAO() {
        return new OrderDAOImpl( this );
    }
}
