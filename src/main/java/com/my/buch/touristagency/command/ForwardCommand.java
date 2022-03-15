package com.my.buch.touristagency.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.buch.touristagency.command.exceptionCommand.CommandException;
import com.my.buch.touristagency.managers.ConfigurationManager;

public class ForwardCommand implements Command {
	private static final String PARAM_NAME_PAGE = "page";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String page = null;
		String requestPage = request.getParameter(PARAM_NAME_PAGE);
		switch (requestPage) {
		case "login":
			page = ConfigurationManager.getProperty("path.page.login");
			break;
		case "register":
			page = ConfigurationManager.getProperty("path.page.register");
			break;
		case "main":
			page = ConfigurationManager.getProperty("path.page.main");
			break;
		case "admin":
			page = ConfigurationManager.getProperty("path.page.admin");
			break;
		case "block":
			page = ConfigurationManager.getProperty("path.page.admin.block");
			break;
		case "orders_list":
			page = ConfigurationManager.getProperty("path.page.orders_list");
			break;
		case "discount":
			page = ConfigurationManager.getProperty("path.page.change_discount");
			break;
		case "deletetour":
			page = ConfigurationManager.getProperty("path.page.deletetour");
			break;
		case "burning":
			page = ConfigurationManager.getProperty("path.page.burning");
			break;
		default:
			page = ConfigurationManager.getProperty("path.page.login");
			break;
		}
		return page;
	}
}


