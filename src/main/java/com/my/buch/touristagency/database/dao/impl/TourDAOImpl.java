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
import com.my.buch.touristagency.database.dao.TourDAO;
import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;
import com.my.buch.touristagency.model.entity.Tour;

public class TourDAOImpl implements TourDAO {
	private static final String MYSQL_INSERT_TOUR = "INSERT INTO `tour`(name, description, price, is_burning, people_amount, is_deleted, hotel_id, tour_type_id)"
			+ "VALUES(?,?,?,?,?,?,?,?)";

	private static final String MYSQL_SELECT_ALL_TOURS = "SELECT * from `tour`";
	
	private static final String MYSQL_UPDATE_TOUR = "UPDATE tour_agency.tour\r\n"
			+ "SET name=?, description=?, price=?, is_burning=?, people_amount=?, is_deleted=?, hotel_id=?, tour_type_id=?\r\n"
			+ "WHERE id=?;";
	
	private static final String MYSQL_SELECT_TOUR_BY_ID = "SELECT * from `tour` WHERE id=? ;";
	
	private static final String PARAM_ID_TOUR = "id";
	private static final String PARAM_NAME = "name";
	private static final String PARAM_DESC = "description";
	private static final String PARAM_PRICE = "price";
	private static final String PARAM_IS_BURNING = "is_burning";
	private static final String PARAM_PEOPLE_AMOUNT = "people_amount";
	private static final String PARAM_IS_DELETED = "is_deleted";
	private static final String PARAM_HOTEL = "hotel_id";
	private static final String PARAM_TOUR_TYPE = "tour_type_id";

	@Override
	public boolean insert(Tour tour) throws DAOException {
		try (Connection cn = ConnectionPool.getInstance().getConnection();
				PreparedStatement ps = cn.prepareStatement(MYSQL_INSERT_TOUR)) {
			setTourPreparedStatement(tour, ps);
			return (ps.executeUpdate() != 0);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
	}

	private void setTourPreparedStatement(Tour tour, PreparedStatement ps) throws DAOException {
		try {
			ps.setString(1, tour.getName());
			ps.setString(2, tour.getDescription());
			ps.setInt(3, tour.getPrice());
			ps.setBoolean(4, tour.getIsBurning());
			ps.setInt(5, tour.getPeopleAmount());
			ps.setBoolean(6, tour.getIsDeleted());
			ps.setLong(7, tour.getHotelId());
			ps.setLong(8, tour.getTourTypeId());
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
	}

	@Override
	public boolean update(Tour tour) throws DAOException {
		try (Connection cn = ConnectionPool.getInstance().getConnection();
				PreparedStatement ps = cn.prepareStatement(MYSQL_UPDATE_TOUR)) {
			setTourPreparedStatement(tour, ps);
			ps.setLong(9, tour.getId());
			return (ps.executeUpdate() != 0);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
	}

	@Override
	public List<Tour> findAllActualTours() throws DAOException {
		List<Tour> tours = new ArrayList<>();
		try (Connection cn = ConnectionPool.getInstance().getConnection(); Statement st = cn.createStatement()) {
			ResultSet resultSet = st.executeQuery(MYSQL_SELECT_ALL_TOURS);
			while (resultSet.next()) {
				tours.add(createTour(resultSet));
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
		return tours;
	}

	/**
	 * Creates tour from result set.
	 *
	 * @param resultSet the resultSet
	 * @throws DAOException the DAO exception
	 */
	private Tour createTour(ResultSet resultSet) throws DAOException {
		try {
			Tour tour = new Tour();
			tour.setId(resultSet.getLong(PARAM_ID_TOUR));
			tour.setName(resultSet.getString(PARAM_NAME));
			tour.setDescription(resultSet.getString(PARAM_DESC));
			tour.setPrice(resultSet.getInt(PARAM_PRICE));
			tour.setBurning(resultSet.getBoolean(PARAM_IS_BURNING));
			tour.setPeopleAmount(resultSet.getInt(PARAM_PEOPLE_AMOUNT));
			tour.setDeleted(resultSet.getBoolean(PARAM_IS_DELETED));
			tour.setHotelId(resultSet.getLong(PARAM_HOTEL));
			tour.setTourTypeId(resultSet.getLong(PARAM_TOUR_TYPE));
			return tour;
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
	}

	@Override
	public Tour findById(Long id) throws DAOException {
		Tour tour = new Tour();
		try (Connection cn = ConnectionPool.getInstance().getConnection();
				PreparedStatement ps = cn.prepareStatement(MYSQL_SELECT_TOUR_BY_ID)) {
			ps.setLong(1, id);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				tour = createTour(resultSet);
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException("SQL exception (request or table failed): " + e, e);
		}
		return tour;
	}
}
