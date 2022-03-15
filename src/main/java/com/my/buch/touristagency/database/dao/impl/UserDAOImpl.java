package com.my.buch.touristagency.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import com.my.buch.touristagency.database.connectiontodb.ConnectionPool;
import com.my.buch.touristagency.database.connectiontodb.ConnectionPoolException;
import com.my.buch.touristagency.database.dao.UserDAO;
import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;
import com.my.buch.touristagency.model.entity.User;

public class UserDAOImpl implements UserDAO {

	private final static Logger LOG = Logger.getLogger(UserDAOImpl.class);

	private static final String MYSQL_INSERT_USER = "INSERT INTO `user`(login, password, role_id, email, first_name, last_name, is_blocked, discount)"
			+ "VALUES(?,?,?,?,?,?,?,?)";

	private static final String MYSQL_UPDATE_USER = "UPDATE tour_agency.user\r\n"
			+ "SET login=?, password=?, role_id=?, email=?, first_name=?, last_name=?, is_blocked=?, discount=?\r\n"
			+ "WHERE id=?;";

	private static final String MYSQL_SELECT_USER_BY_NAME = "SELECT * FROM `user` WHERE login=?";

	private static final String MYSQL_SELECT_USER_BY_ID = "SELECT * FROM `user`\r\n"
			+ "WHERE id=?;\r\n";

	private static final String MYSQL_SELECT_ALL_USERS = "SELECT *" + "FROM user";

	private static final String PARAM_ID_USER = "id";
	private static final String PARAM_LOGIN = "login";
	private static final String PARAM_PASSWORD = "password";
	private static final String PARAM_ROLE = "role_id";
	private static final String PARAM_EMAIL = "email";
	private static final String PARAM_FIRST_NAME = "first_name";
	private static final String PARAM_LAST_NAME = "last_name";
	private static final String PARAM_BLOCKED = "is_blocked";
	private static final String PARAM_DISCOUNT = "discount";

	@Override
	public boolean insert(User user) throws DAOException {
		try (Connection cn = ConnectionPool.getInstance().getConnection();
				PreparedStatement ps = cn.prepareStatement(MYSQL_INSERT_USER)) {
			setUserPreparedStatement(user, ps);
			return (ps.executeUpdate() != 0);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
	}

	@Override
	public boolean update(User user) throws DAOException {
		try (Connection cn = ConnectionPool.getInstance().getConnection();
				PreparedStatement ps = cn.prepareStatement(MYSQL_UPDATE_USER)) {
			setUserPreparedStatement(user, ps);
			ps.setLong(9, user.getId());
			return (ps.executeUpdate() != 0);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
	}

	@Override
	public User findById(long id) throws DAOException {
		User user = new User();
		try (Connection cn = ConnectionPool.getInstance().getConnection();
				PreparedStatement ps = cn.prepareStatement(MYSQL_SELECT_USER_BY_ID)) {
			ps.setLong(1, id);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				user = createUser(resultSet);
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
		return user;
	}

	@Override
	public List<User> findAllUsers() throws DAOException {
		List<User> users = new ArrayList<>();
		try (Connection cn = ConnectionPool.getInstance().getConnection(); Statement st = cn.createStatement()) {
			ResultSet resultSet = st.executeQuery(MYSQL_SELECT_ALL_USERS);
			while (resultSet.next()) {
				users.add(createUser(resultSet));
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
		return users;
	}

	private void setUserPreparedStatement(User user, PreparedStatement ps) throws DAOException {
		try {
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getRoleId());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getFirstName());
			ps.setString(6, user.getLastName());
			ps.setBoolean(7, user.getIsBlocked());
			ps.setInt(8, user.getDiscount());
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
	}

	/**
	 * Creates user from result set.
	 *
	 * @param resultSet the resultSet
	 * @throws DAOException the DAO exception
	 */
	private User createUser(ResultSet resultSet) throws DAOException {
		try {
			User user = new User();
			user.setId(resultSet.getLong(PARAM_ID_USER));
			user.setLogin(resultSet.getString(PARAM_LOGIN));
			user.setPassword(resultSet.getString(PARAM_PASSWORD));
			user.setRoleId(resultSet.getInt(PARAM_ROLE));
			user.setEmail(resultSet.getString(PARAM_EMAIL));
			user.setFirstName(resultSet.getString(PARAM_FIRST_NAME));
			user.setLastName(resultSet.getString(PARAM_LAST_NAME));
			user.setIsBlocked(resultSet.getBoolean(PARAM_BLOCKED));
			user.setDiscount(resultSet.getInt(PARAM_DISCOUNT));
			return user;
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
	}

	@Override
	public User findByName(String name) throws DAOException {
		User user = null;
		try (Connection cn = ConnectionPool.getInstance().getConnection();
				PreparedStatement ps = cn.prepareStatement(MYSQL_SELECT_USER_BY_NAME)) {
			ps.setString(1, name);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				LOG.debug(resultSet.getString(PARAM_LOGIN));
				LOG.debug(resultSet.getInt(PARAM_ROLE));
				user = createUser(resultSet);
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
		return user;
	}
}
