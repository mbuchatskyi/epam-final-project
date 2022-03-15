package com.my.buch.touristagency.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.my.buch.touristagency.command.Command;
import com.my.buch.touristagency.command.exceptionCommand.CommandException;
import com.my.buch.touristagency.managers.ConfigurationManager;
import com.my.buch.touristagency.service.exceptionService.ServiceException;
import com.my.buch.touristagency.service.impl.UserServiceImpl;

public class RegisterCommand implements Command {

	private final static Logger LOG = Logger.getLogger(RegisterCommand.class);

	private static final String PARAM_NAME_LOGIN = "login";

	private static final String PARAM_NAME_PASSWORD = "password";

	private static final String PARAM_NAME_EMAIL = "email";

	private static final String PARAM_FIRST_NAME_NAME = "first_name";

	private static final String PARAM_LAST_NAME = "last_name";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String page = null;
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		String email = request.getParameter(PARAM_NAME_EMAIL);
		String name = request.getParameter(PARAM_FIRST_NAME_NAME);
		String surname = request.getParameter(PARAM_LAST_NAME);
		LOG.debug("Encoding (Register): " + request.getCharacterEncoding());
		UserServiceImpl userService = new UserServiceImpl();
		try {
			if (userService.checkRegister(login, pass, email, name, surname)) {
				page = ConfigurationManager.getProperty("path.page.login");
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
