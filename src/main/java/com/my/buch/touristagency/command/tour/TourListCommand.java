package com.my.buch.touristagency.command.tour;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.buch.touristagency.command.Command;
import com.my.buch.touristagency.command.exceptionCommand.CommandException;
import com.my.buch.touristagency.managers.ConfigurationManager;
import com.my.buch.touristagency.model.entity.Tour;
import com.my.buch.touristagency.service.exceptionService.ServiceException;
import com.my.buch.touristagency.service.impl.TourServiceImpl;

public class TourListCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String page = null;
		TourServiceImpl tService = new TourServiceImpl();
		try {
			List<Tour> tours = tService.findAllTours()
					.stream()
					.sorted(Comparator.comparing(Tour::getIsBurning)
					.reversed())
					.collect(Collectors.toList());
			request.setAttribute("tours", tours);
		} catch (ServiceException e) {
			throw new CommandException(e);
		}
		page = ConfigurationManager.getProperty("path.page.main");
		return page;
	}

}
