package com.my.buch.touristagency.command.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.buch.touristagency.command.Command;
import com.my.buch.touristagency.command.exceptionCommand.CommandException;
import com.my.buch.touristagency.database.dao.DiscountDAO;
import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;
import com.my.buch.touristagency.database.dao.impl.FactoryDAOImpl;
import com.my.buch.touristagency.managers.ConfigurationManager;
import com.my.buch.touristagency.model.entity.Discount;
import com.my.buch.touristagency.service.exceptionService.ServiceException;
import com.my.buch.touristagency.service.impl.OrderServiceImpl;
import com.my.buch.touristagency.service.impl.TourServiceImpl;
import com.my.buch.touristagency.service.impl.UserServiceImpl;

public class OrderTourCommand implements Command {
	private static final String PARAM_NAME_ID_USER = "iduser";

	private static final String PARAM_NAME_ID_TOUR = "idtour";

	private static final String PARAM_NAME_PRICE = "price";

	private final static DiscountDAO discountDAOImpl = FactoryDAOImpl.getInstance().createDiscountDAO();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String page = null;
		Long userId = Long.parseLong(request.getParameter(PARAM_NAME_ID_USER));
		Long tourId = Long.parseLong(request.getParameter(PARAM_NAME_ID_TOUR));
		int price = Integer.parseInt(request.getParameter(PARAM_NAME_PRICE));
		Long statusIdLong = 1L;
		TourServiceImpl tourService = new TourServiceImpl();
		UserServiceImpl userService = new UserServiceImpl();
		try {
			discountDAOImpl.getDiscountFromDB();
		} catch (DAOException e1) {
			throw new CommandException("Can't get discount's parameters! DB error", e1);
		}
		try {
			request.setAttribute("tour", tourService.findTourById(tourId));
			request.setAttribute("step", Discount.getStep());
			request.setAttribute("max", Discount.getMax());
			if (userId != null) {
				request.setAttribute("userProf", userService.findUserById(userId));
			}
			OrderServiceImpl orderService = new OrderServiceImpl();
			if (orderService.checkOrder(price, statusIdLong, tourId, userId)) {
				page = ConfigurationManager.getProperty("path.page.order.success");
			} else {
				page = ConfigurationManager.getProperty("path.page.main");
			}
		} catch (ServiceException e) {
			throw new CommandException(e);
		}
		return page;
	}
}
