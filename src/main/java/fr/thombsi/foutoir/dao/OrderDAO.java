package fr.thombsi.foutoir.dao;

import fr.thombsi.foutoir.beans.Order;

public interface OrderDAO {
    void add( Order order ) throws DAOException;

    Order findById( Long id ) throws DAOException;
}
