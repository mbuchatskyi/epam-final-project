package com.my.buch.touristagency.command.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.buch.touristagency.command.Command;
import com.my.buch.touristagency.command.exceptionCommand.CommandException;
import com.my.buch.touristagency.managers.ConfigurationManager;
import com.my.buch.touristagency.model.entity.Order;
import com.my.buch.touristagency.service.exceptionService.ServiceException;
import com.my.buch.touristagency.service.impl.OrderServiceImpl;


public class OrderListCommand implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String page = null;
		OrderServiceImpl oService = new OrderServiceImpl();
		try {
			List<Order> orders = oService.findAllOrders();
			request.setAttribute("orders", orders);
		} catch (ServiceException e) {
			throw new CommandException(e);
		}
		page = ConfigurationManager.getProperty("path.page.orders_list");
		return page;
	}
}
