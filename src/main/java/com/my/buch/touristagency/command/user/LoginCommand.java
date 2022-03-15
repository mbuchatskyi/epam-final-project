package com.my.buch.touristagency.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.buch.touristagency.command.Command;
import com.my.buch.touristagency.command.exceptionCommand.CommandException;
import com.my.buch.touristagency.managers.ConfigurationManager;
import com.my.buch.touristagency.model.entity.User;
import com.my.buch.touristagency.service.exceptionService.ServiceException;
import com.my.buch.touristagency.service.impl.UserServiceImpl;

public class LoginCommand implements Command {
	private static final String PARAM_NAME_LOGIN = "login";

	private static final String PARAM_NAME_PASSWORD = "password";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String page = null;
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		UserServiceImpl userService = new UserServiceImpl();
		try {
			if (userService.checkLogin(login, pass)) {
				User user = userService.findUserByName(login);
				HttpSession session = request.getSession(true);
				if (session.getAttribute("user") == null) {
					session.setAttribute("user", user.getLogin());
				}
				if (session.getAttribute("role") == null) {
					session.setAttribute("role", user.getRoleId());
				}
				if (session.getAttribute("id") == null) {
					session.setAttribute("id", user.getId());
				}
				if (session.getAttribute("discount") == null) {
					session.setAttribute("discount", user.getDiscount());
				}
				if (session.getAttribute("blocked") == null) {
					session.setAttribute("blocked", user.getIsBlocked());
				}
				page = ConfigurationManager.getProperty("path.page.main");
			} else {
				request.setAttribute("errorLoginPassMessage",
						"Incorrect login or password");
				page = ConfigurationManager.getProperty("path.page.login");
			}
		} catch (ServiceException e) {
			throw new CommandException(e);
		}
		return page;
	}
}
