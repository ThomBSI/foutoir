package fr.thombsi.foutoir.dao;

import fr.thombsi.foutoir.beans.Customer;

public interface CustomerDAO {
    void add( Customer customer ) throws DAOException;

    Customer findById( Long id ) throws DAOException;
}
