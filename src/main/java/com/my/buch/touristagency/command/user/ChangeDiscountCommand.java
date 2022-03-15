package com.my.buch.touristagency.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.buch.touristagency.command.Command;
import com.my.buch.touristagency.command.exceptionCommand.CommandException;
import com.my.buch.touristagency.database.dao.UserDAO;
import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;
import com.my.buch.touristagency.database.dao.impl.FactoryDAOImpl;
import com.my.buch.touristagency.managers.ConfigurationManager;
import com.my.buch.touristagency.model.entity.Discount;
import com.my.buch.touristagency.model.entity.User;

public class ChangeDiscountCommand implements Command {
	private static final String PARAM_NAME_ID_USER = "id";

	private final static UserDAO userDAOImpl = FactoryDAOImpl.getInstance().createUserDAO();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String page = null;
		HttpSession session = request.getSession();
		if (session.getAttribute(PARAM_NAME_ID_USER) != null) {
			Long userId = (Long) session.getAttribute(PARAM_NAME_ID_USER);
			User user;
			try {
				user = userDAOImpl.findById(userId);
			} catch (DAOException e) {
				throw new CommandException("Can't change discount!", e);
			}
			int discountOld = user.getDiscount();
			int discountNew = 0;
			if (discountOld + Discount.getStep() > Discount.getMax()) {
				discountNew = Discount.getMax();
			} else {
				discountNew = discountOld + Discount.getStep();
			}
			user.setDiscount(discountNew);
			try {
				userDAOImpl.update(user);
				session.setAttribute("discount", user.getDiscount());
				page = ConfigurationManager.getProperty("path.page.main");
			} catch (DAOException e) {
				throw new CommandException("Can't update discount!", e);
			}
		}
		return page;
	}
}
