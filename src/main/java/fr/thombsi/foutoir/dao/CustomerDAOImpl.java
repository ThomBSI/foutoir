package fr.thombsi.foutoir.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.thombsi.foutoir.beans.Customer;

public class CustomerDAOImpl implements CustomerDAO {

    private static final String COL_FIRST_NAME = "firstName";
    private static final String COL_LAST_NAME  = "lastName";
    private static final String COL_MAIL       = "mail";
    private static final String COL_PHONE      = "phone";
    private static final String COL_ADRESS     = "adress";
    private static final String COL_ID         = "id";
    private static final String COL_IMAGE_NAME = "imageName";

    private DAOFactory          daoFactory;

    CustomerDAOImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    /**
     * Ajout d'un customer.
     */
    @Override
    public void add( Customer customer ) throws DAOException {

    }

    /**
     */
    @Override
    public Customer findById( Long id ) throws IllegalArgumentException, DAOException {
        // TODO Auto-generated method stub
        return null;
    }

    public Customer map( ResultSet resultSet ) {
        Customer customer = new Customer();
        try {
            customer.setFirstName( resultSet.getString( COL_FIRST_NAME ) );
            customer.setLastName( resultSet.getString( COL_LAST_NAME ) );
            customer.setAdress( resultSet.getString( COL_ADRESS ) );
            customer.setId( resultSet.getLong( COL_ID ) );
            customer.setMail( resultSet.getString( COL_MAIL ) );
            customer.setPhone( resultSet.getString( COL_PHONE ) );
            customer.setImageName( resultSet.getString( COL_IMAGE_NAME ) );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        return customer;
    }

}
