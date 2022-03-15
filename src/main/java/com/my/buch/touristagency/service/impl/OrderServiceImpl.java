package com.my.buch.touristagency.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.my.buch.touristagency.database.dao.OrderDAO;

import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;
import com.my.buch.touristagency.database.dao.impl.FactoryDAOImpl;
import com.my.buch.touristagency.model.entity.Order;
import com.my.buch.touristagency.service.OrderService;
import com.my.buch.touristagency.service.exceptionService.ServiceException;

public class OrderServiceImpl implements OrderService {
	private static final Logger LOG = Logger.getLogger(OrderServiceImpl.class);

	private final static long ORDER_ID_FOR_INSERT = 0L;
	private final static long ORDER_STATUS_ID_FOR_INSERT = 1L;

	private final static OrderDAO orderDAOImpl = FactoryDAOImpl.getInstance().createOrderDAO();

	@Override
	public boolean checkOrder(int total_price, Long order_status_id, Long tour_id, Long user_id)
			throws ServiceException {
		boolean flag = false;
		try {
			Order order = new Order();
			order.setId(ORDER_ID_FOR_INSERT);
			order.setTotalPrice(total_price);
			order.setDateOfOrder(new java.util.Date());
			order.setOrderStatusId(ORDER_STATUS_ID_FOR_INSERT);
			order.setTourId(tour_id);
			order.setUserId(user_id);
			LOG.debug("Order date: " + new java.util.Date());
			if (orderDAOImpl.insert(order)) {
				flag = true;
			}
		} catch (DAOException e) {
			throw new ServiceException("Failed to create order or to update user balance (Order).", e);
		}

		return flag;
	}

	@Override
	public List<Order> findAllOrders() throws ServiceException {
		try {
			return orderDAOImpl.findAllOrders();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
