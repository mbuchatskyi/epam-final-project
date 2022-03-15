package com.my.buch.touristagency.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.my.buch.touristagency.database.connectiontodb.ConnectionPool;
import com.my.buch.touristagency.database.connectiontodb.ConnectionPoolException;
import com.my.buch.touristagency.database.dao.DiscountDAO;
import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;
import com.my.buch.touristagency.model.entity.Discount;

public class DiscountDAOImpl implements DiscountDAO {
	private final static String MYSQL_UPDATE_DISCOUNT = "UPDATE `discount`\r\n" + "SET step = ?, max = ?\r\n"
			+ "WHERE id=0;";

	private final static String MYSQL_GET_DISCOUNT_STEP = "SELECT discount.step, discount.max FROM `DISCOUNT`\r\n"
			+ "WHERE id=0; ";

	@Override
	public boolean update(Discount discount) throws DAOException {
		try (Connection cn = ConnectionPool.getInstance().getConnection();
				PreparedStatement ps = cn.prepareStatement(MYSQL_UPDATE_DISCOUNT)) {
			setPreparedStatement(discount, ps);
			return (ps.executeUpdate() != 0);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
	}

	private void setPreparedStatement(Discount discount, PreparedStatement ps) throws DAOException {
		try {
			ps.setInt(1, Discount.getStep());
			ps.setInt(2, Discount.getMax());
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
	}

	@Override
	public boolean getDiscountFromDB() throws DAOException {
		boolean flag = false;
		try (Connection cn = ConnectionPool.getInstance().getConnection();
				PreparedStatement ps = cn.prepareStatement(MYSQL_GET_DISCOUNT_STEP);) {
			ResultSet resultSet = ps.executeQuery();
			 resultSet.next();
			Discount.getInstance().setStep(resultSet.getInt(1));
			Discount.getInstance().setMax(resultSet.getInt(2));
			flag = true;
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
		return flag;
	}
	
	public static void main(String[] args) throws DAOException {
		DiscountDAOImpl da = new DiscountDAOImpl();
		da.getDiscountFromDB();
		System.out.println(Discount.getMax());
	}

}
