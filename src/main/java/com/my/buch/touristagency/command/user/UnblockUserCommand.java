package com.my.buch.touristagency.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.my.buch.touristagency.command.Command;
import com.my.buch.touristagency.command.exceptionCommand.CommandException;
import com.my.buch.touristagency.database.dao.UserDAO;
import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;
import com.my.buch.touristagency.database.dao.impl.FactoryDAOImpl;
import com.my.buch.touristagency.managers.ConfigurationManager;
import com.my.buch.touristagency.model.entity.User;

public class UnblockUserCommand implements Command{
	private final static UserDAO userDAOImpl = FactoryDAOImpl.getInstance().createUserDAO();

	private static final String PARAM_NAME_LOGIN = "login";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String page = null;
		String name = request.getParameter(PARAM_NAME_LOGIN);
		User user = null;
		try {
			user = userDAOImpl.findByName(name);
		} catch (DAOException e) {
			throw new CommandException("Can't find user! DB error", e);
		}
		if (user == null) {
			request.setAttribute("err", "Can't find user");
		} else {
			if (user.getIsBlocked() == false) {
				request.setAttribute("isalreadyunblockederror", "User is already unbanned!");
			} else {
				user.setIsBlocked(false);
				try {
					userDAOImpl.update(user);
				} catch (DAOException e) {
					throw new CommandException("Can't ban user! DB error", e);
				}
			}
		}
		page = ConfigurationManager.getProperty("path.page.userblocked");
		return page;
	}

}
