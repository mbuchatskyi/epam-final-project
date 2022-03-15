package com.my.buch.touristagency.service.impl;

import com.my.buch.touristagency.database.dao.DiscountDAO;
import com.my.buch.touristagency.database.dao.exceptionDAO.DAOException;
import com.my.buch.touristagency.database.dao.impl.FactoryDAOImpl;
import com.my.buch.touristagency.model.entity.Discount;
import com.my.buch.touristagency.model.entity.User;
import com.my.buch.touristagency.service.DiscountService;
import com.my.buch.touristagency.service.exceptionService.ServiceException;

public class DiscountServiceImpl implements DiscountService{
	private final static DiscountDAO discountDAOImpl = FactoryDAOImpl.getInstance().createDiscountDAO();

	@Override
	public boolean checkEditDiscount(int step, int max) throws ServiceException {
		boolean flag = false;
		try {
			Discount discount = Discount.getInstance();
			discount.setStep(step);
			discount.setMax(max);
			if (discountDAOImpl.update(discount)) {
				flag = true;
			}
		} catch (DAOException e) {
			throw new ServiceException("Failed to update discount.", e);
		}
		return flag;
	}

	@Override
	public boolean checkEditUserDiscount(User user) throws ServiceException {
		boolean flag = false;
		try {
			Discount discount = Discount.getInstance();
			
			if (discountDAOImpl.update(discount)) {
				flag = true;
			}
		} catch (DAOException e) {
			throw new ServiceException("Failed to update discount.", e);
		}
		return flag;
	}

}
