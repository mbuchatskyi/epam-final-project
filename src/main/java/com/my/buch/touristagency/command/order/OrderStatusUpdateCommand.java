package com.my.buch.touristagency.command.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.buch.touristagency.command.Command;
import com.my.buch.touristagency.command.exceptionCommand.CommandException;
import com.my.buch.touristagency.database.dao.OrderDAO;
import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;
import com.my.buch.touristagency.database.dao.impl.FactoryDAOImpl;
import com.my.buch.touristagency.managers.ConfigurationManager;
import com.my.buch.touristagency.model.entity.Order;

public class OrderStatusUpdateCommand implements Command {
	private static final String PARAM_NAME_ID_ORDER = "idorder";

	private final static OrderDAO orderDAOImpl = FactoryDAOImpl.getInstance().createOrderDAO();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String page = null;
		Long id = Long.parseLong(request.getParameter(PARAM_NAME_ID_ORDER));
	
		Order order = null;
		try {
			order = orderDAOImpl.findById(id);
		} catch (DAOException e) {
			throw new CommandException("DB error", e);
		}
		order.setOrderStatusId(2L);
		try {
			orderDAOImpl.update(order);
		} catch (DAOException e) {
			throw new CommandException("Can't ban user! DB error", e);
		}
		page = ConfigurationManager.getProperty("path.page.orders_list");
		return page;
	}

}
