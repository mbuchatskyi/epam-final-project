package com.my.buch.touristagency.command.tour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.my.buch.touristagency.command.Command;
import com.my.buch.touristagency.command.exceptionCommand.CommandException;
import com.my.buch.touristagency.managers.ConfigurationManager;
import com.my.buch.touristagency.service.exceptionService.ServiceException;
import com.my.buch.touristagency.service.impl.TourServiceImpl;

public class CreateTourCommand implements Command{
	private final static Logger LOG = Logger.getLogger(CreateTourCommand.class);

	private static final String PARAM_NAME = "name";

	private static final String PARAM_NAME_DESCRIPTION = "description";

	private static final String PARAM_NAME_PRICE = "price";
	
	private static final String PARAM_NAME_PEOPLE_AMOUNT = "people_amount";

	private static final String PARAM_HOTEL = "hotel_id";

	private static final String PARAM_TOUR_TYPE = "tour_type_id";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String page = null;
		String name = request.getParameter(PARAM_NAME);
		String description = request.getParameter(PARAM_NAME_DESCRIPTION);
		Integer price = Integer.parseInt(request.getParameter(PARAM_NAME_PRICE));
		Integer people_amount = Integer.parseInt(request.getParameter(PARAM_NAME_PEOPLE_AMOUNT));
		Long hotel = Long.parseLong(request.getParameter(PARAM_HOTEL));
		Long tourtype = Long.parseLong(request.getParameter(PARAM_TOUR_TYPE));
		LOG.debug("Encoding (Tour creating): " + request.getCharacterEncoding());
		TourServiceImpl tourService = new TourServiceImpl();
		try {
			if (tourService.checkCreateTour(name, description, price, people_amount, hotel, tourtype)) {
				page = ConfigurationManager.getProperty("path.page.main");
			} else {
				request.setAttribute("errorRegisterPassMessage",
						"Incorrect login or password");
				page = ConfigurationManager.getProperty("path.page.register");
			}
		} catch (ServiceException e) {
			throw new CommandException(e);
		}
		return page;
	}
}
