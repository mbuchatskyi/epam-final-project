package com.my.buch.touristagency.service.impl;

import java.util.List;

import com.my.buch.touristagency.database.dao.UserDAO;
import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;
import com.my.buch.touristagency.database.dao.impl.FactoryDAOImpl;
import com.my.buch.touristagency.model.entity.User;
import com.my.buch.touristagency.service.UserService;
import com.my.buch.touristagency.service.exceptionService.ServiceException;
import com.my.buch.touristagency.util.PasswordCoding;
import com.my.buch.touristagency.util.Validator;
import com.my.buch.touristagency.util.exceptionUtil.UtilException;

public class UserServiceImpl implements UserService {
	private final static long USER_ID_FOR_INSERT = 0;

	private final static int USER_DEFAULT_ROLE = 1;

	private final static int USER_DEFAULT_DISCOUNT = 0;

	private final static boolean USER_DEFAULT_IS_BLOCKED = false;

	private final static UserDAO userDAOImpl = FactoryDAOImpl.getInstance().createUserDAO();

	@Override
	public User findUserById(Long id) throws ServiceException {
		try {
			return userDAOImpl.findById(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public User findUserByName(String login) throws ServiceException {
		try {
			return userDAOImpl.findByName(login);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean checkCreateUser(String enterLogin, String enterPassword, String enterEmail, String enterFirstName,
			String enterLastName, int enterRoleId, boolean enterIsBlocked, int enterDiscount) throws ServiceException {
		boolean flag = false;
		if (Validator.validateLogin(enterLogin) && Validator.validatePassword(enterPassword)
				&& Validator.validateEmail(enterEmail) && Validator.validateName(enterFirstName)
				&& Validator.validateSurname(enterLastName)) {
			flag = generalCreateUser(enterLogin, enterPassword, enterEmail, enterFirstName, enterLastName, enterRoleId,
					enterIsBlocked, enterDiscount);
		}
		return flag;
	}

	@Override
	public boolean checkLogin(String enterLogin, String enterPassword) throws ServiceException {
		boolean flag = false;
		List<User> users = null;
		try {
			users = userDAOImpl.findAllUsers();
			for (int i = 0; i < users.size(); i++) {
				if (enterLogin.equals(users.get(i).getLogin())) {
					if (PasswordCoding.md5Encode(enterPassword).equals(users.get(i).getPassword())) {
						flag = true;
					}
				}
			}
		} catch (DAOException e) {
			throw new ServiceException("Failed to find all users.", e);
		} catch (UtilException e) {
			throw new ServiceException(e);
		}
		return flag;
	}

	@Override
	public boolean checkRegister(String enterLogin, String enterPassword, String enterEmail, String enterFirstName,
			String enterLastName) throws ServiceException {
		boolean flag = false;
		if (Validator.validateLogin(enterLogin) && Validator.validatePassword(enterPassword)
				&& Validator.validateEmail(enterEmail) && Validator.validateName(enterFirstName)
				&& Validator.validateSurname(enterLastName)) {
			flag = generalCreateUser(enterLogin, enterPassword, enterEmail, enterFirstName, enterLastName,
					USER_DEFAULT_ROLE, USER_DEFAULT_IS_BLOCKED, USER_DEFAULT_DISCOUNT);
		}
		return flag;
	}

	/**
	 * General create user.
	 *
	 * @param enterLogin    the enter login
	 * @param enterPass     the enter pass
	 * @param enterEmail    the enter email
	 * @param enterName     the enter name
	 * @param enterSurname  the enter surname
	 * @param enterRole     the enter role
	 * @param enterDiscount the enter discount
	 * @param enterMoney    the enter money
	 * @return true, if successful
	 * @throws ServiceException the service exception
	 */
	private boolean generalCreateUser(String enterLogin, String enterPassword, String enterEmail, String enterFirstName,
			String enterLastName, int enterRoleId, boolean enterIsBlocked, int enterDiscount) throws ServiceException {
		boolean flag = false;
		try {
			if (userDAOImpl.findByName(enterLogin) == null) {
				User user = new User();
				user.setId(USER_ID_FOR_INSERT);
				user.setLogin(enterLogin);
				user.setPassword(PasswordCoding.md5Encode(enterPassword));
				user.setRoleId(USER_DEFAULT_ROLE);
				user.setEmail(enterEmail);
				user.setFirstName(enterFirstName);
				user.setLastName(enterLastName);
				user.setIsBlocked(USER_DEFAULT_IS_BLOCKED);
				user.setDiscount(USER_DEFAULT_DISCOUNT);

				if (userDAOImpl.insert(user)) {
					flag = true;
				}
			}
		} catch (DAOException e) {
			throw new ServiceException("Failed to create user (Register).", e);
		} catch (UtilException e) {
			throw new ServiceException(e);
		}
		return flag;
	}

}
