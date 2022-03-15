package com.my.buch.touristagency.command.tour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.buch.touristagency.command.Command;
import com.my.buch.touristagency.command.exceptionCommand.CommandException;
import com.my.buch.touristagency.database.dao.TourDAO;
import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;
import com.my.buch.touristagency.database.dao.impl.FactoryDAOImpl;
import com.my.buch.touristagency.managers.ConfigurationManager;
import com.my.buch.touristagency.model.entity.Tour;
import com.my.buch.touristagency.service.exceptionService.ServiceException;

public class MakeTourBurningCommand implements Command {
	private static final String PARAM_NAME_TOUR_ID = "tourid";

	private final static TourDAO tourDAOImpl = FactoryDAOImpl.getInstance().createTourDAO();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String page = null;
		Long tourid = Long.parseLong(request.getParameter(PARAM_NAME_TOUR_ID));

		Tour tour = null;
		try {
			tour = tourDAOImpl.findById(tourid);
		} catch (DAOException e) {
			throw new ServiceException("DB error find!");
		}
		tour.setBurning(true);
		try {
			tourDAOImpl.update(tour);
		} catch (DAOException e) {
			throw new ServiceException("DB error update!");
		}
		page = ConfigurationManager.getProperty("path.page.main");
		return page;
	}
}
