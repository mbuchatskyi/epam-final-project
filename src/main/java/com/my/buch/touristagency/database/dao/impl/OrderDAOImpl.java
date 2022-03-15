package com.my.buch.touristagency.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.buch.touristagency.database.connectiontodb.ConnectionPool;
import com.my.buch.touristagency.database.connectiontodb.ConnectionPoolException;
import com.my.buch.touristagency.database.dao.OrderDAO;
import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;
import com.my.buch.touristagency.model.entity.Order;

public class OrderDAOImpl implements OrderDAO {
	private static final String PARAM_ID_ORDER = "id";
	private static final String PARAM_PRICE = "total_price";
	private static final String PARAM_DATE = "date_of_order";
	private static final String PARAM_STATUS = "order_status_id";
	private static final String PARAM_TOUR_ID = "tour_id";
	private static final String PARAM_USER_ID = "user_id";

	private static final String MYSQL_INSERT_ORDER = "INSERT INTO `order` (total_price, date_of_order, order_status_id, tour_id, user_id)\r\n"
			+ "VALUES (?, ?, ?, ?, ?);";

	private static final String MYSQL_SELECT_ALL_ORDERS = "SELECT *" + "FROM `order`";
	
	private static final String MYSQL_UPDATE_ORDER = "UPDATE tour_agency.order\r\n"
			+ "SET total_price=?, date_of_order=?, order_status_id=?, tour_id=?, user_id=?\r\n"
			+ "WHERE id=?;";

	private static final String MYSQL_SELECT_ORDER_BY_ID = "SELECT * FROM `order`\r\n"
			+ "WHERE id=?;\r\n";
	
	@Override
	public boolean insert(Order order) throws DAOException {
		try (Connection cn = ConnectionPool.getInstance().getConnection();
				PreparedStatement ps = cn.prepareStatement(MYSQL_INSERT_ORDER)) {
			setTourPreparedStatement(order, ps);
			return (ps.executeUpdate() != 0);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
	}

	private void setTourPreparedStatement(Order order, PreparedStatement ps) throws DAOException {
		try {
			ps.setInt(1, order.getTotalPrice());
			ps.setDate(2, new java.sql.Date(order.getDateOfOrder().getTime()));
			ps.setLong(3, order.getOrderStatusId());
			ps.setLong(4, order.getTourId());
			ps.setLong(5, order.getUserId());
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
	}

	@Override
	public List<Order> findAllOrders() throws DAOException {
		List<Order> users = new ArrayList<>();
		try (Connection cn = ConnectionPool.getInstance().getConnection(); Statement st = cn.createStatement()) {
			ResultSet resultSet = st.executeQuery(MYSQL_SELECT_ALL_ORDERS);
			while (resultSet.next()) {
				users.add(createOrder(resultSet));
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
		return users;
	}

	/**
	 * Creates user from result set.
	 *
	 * @param resultSet the resultSet
	 * @throws DAOException the DAO exception
	 */
	private Order createOrder(ResultSet resultSet) throws DAOException {
		try {
			Order order = new Order();
			order.setId(resultSet.getLong(PARAM_ID_ORDER));
			order.setTotalPrice(resultSet.getInt(PARAM_PRICE));
			order.setDateOfOrder(resultSet.getDate(PARAM_DATE));
			order.setOrderStatusId(resultSet.getLong(PARAM_STATUS));
			order.setTourId(resultSet.getLong(PARAM_TOUR_ID));
			order.setUserId(resultSet.getLong(PARAM_USER_ID));	
			return order;
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
	}
	
	@Override
	public boolean update(Order order) throws DAOException {
		try (Connection cn = ConnectionPool.getInstance().getConnection();
				PreparedStatement ps = cn.prepareStatement(MYSQL_UPDATE_ORDER)) {
			setPreparedStatement(order, ps);
			ps.setLong(6, order.getId());
			return (ps.executeUpdate() != 0);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
	}
	
	private void setPreparedStatement(Order order, PreparedStatement ps) throws DAOException {
		try {
			ps.setLong(1, order.getTotalPrice());
			ps.setDate(2, new java.sql.Date(order.getDateOfOrder().getTime()));
			ps.setLong(3, order.getOrderStatusId());
			ps.setLong(4, order.getTourId());
			ps.setLong(5, order.getUserId());
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
	}

	@Override
	public Order findById(long id) throws DAOException {
		Order order = new Order();
		try (Connection cn = ConnectionPool.getInstance().getConnection();
				PreparedStatement ps = cn.prepareStatement(MYSQL_SELECT_ORDER_BY_ID)) {
			ps.setLong(1, id);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				order = createOrder(resultSet);
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
		return order;
	}
}
