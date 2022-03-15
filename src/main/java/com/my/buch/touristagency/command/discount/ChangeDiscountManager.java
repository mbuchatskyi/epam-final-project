package com.my.buch.touristagency.command.discount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.buch.touristagency.command.Command;
import com.my.buch.touristagency.command.exceptionCommand.CommandException;
import com.my.buch.touristagency.managers.ConfigurationManager;
import com.my.buch.touristagency.model.entity.Discount;
import com.my.buch.touristagency.service.impl.DiscountServiceImpl;

public class ChangeDiscountManager implements Command{
	private static final String PARAM_NAME_STEP = "step";

	private static final String PARAM_NAME_MAX = "max";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String page = null;
		Integer step = Integer.parseInt(request.getParameter(PARAM_NAME_STEP));
		Integer max = Integer.parseInt(request.getParameter(PARAM_NAME_MAX));
		
		DiscountServiceImpl discountService = new DiscountServiceImpl();
		discountService.checkEditDiscount(step, max);
		
		Discount.getInstance().setStep(step);
		Discount.getInstance().setMax(max);
	
		page = ConfigurationManager.getProperty("path.page.main"); 
		return page;
	}
}
