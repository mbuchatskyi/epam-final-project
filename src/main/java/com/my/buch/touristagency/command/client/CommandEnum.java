package com.my.buch.touristagency.command.client;

import com.my.buch.touristagency.command.Command;
import com.my.buch.touristagency.command.ForwardCommand;
import com.my.buch.touristagency.command.discount.ChangeDiscountManager;
import com.my.buch.touristagency.command.order.OrderListCommand;
import com.my.buch.touristagency.command.order.OrderStatusUpdateCanceledCommand;
import com.my.buch.touristagency.command.order.OrderStatusUpdateCommand;
import com.my.buch.touristagency.command.order.OrderTourCommand;
import com.my.buch.touristagency.command.tour.CreateTourCommand;
import com.my.buch.touristagency.command.tour.DeleteTourCommand;
import com.my.buch.touristagency.command.tour.MakeTourBurningCommand;
import com.my.buch.touristagency.command.tour.TourListCommand;
import com.my.buch.touristagency.command.tour.ToursForAdminCommand;
import com.my.buch.touristagency.command.tour.ToursForManagerCommand;
import com.my.buch.touristagency.command.user.BlockUserCommand;
import com.my.buch.touristagency.command.user.ChangeDiscountCommand;
import com.my.buch.touristagency.command.user.LoginCommand;
import com.my.buch.touristagency.command.user.LogoutCommand;
import com.my.buch.touristagency.command.user.RegisterCommand;
import com.my.buch.touristagency.command.user.UnblockUserCommand;

public enum CommandEnum {
	
	/** The login. */
	LOGIN(new LoginCommand()),

	/** The logout. */
	LOGOUT(new LogoutCommand()),

	/** The register user. */
	REGISTER(new RegisterCommand()),

	/** The tour list. */
	TOUR_LIST(new TourListCommand()),
	
	/** The tour list for admin. */
	TOUR_LIST_FOR_ADMIN(new ToursForAdminCommand()),
	
	/** The tour list for manager. */
	TOUR_LIST_FOR_MANAGER(new ToursForManagerCommand()),

	/** The creating tour. */
	CREATE_TOUR(new CreateTourCommand()),

	/** The deleting tour. */
	DELETE_TOUR(new DeleteTourCommand()),
	
	/** The changing user discount. */
	CHANGE_DISCOUNT(new ChangeDiscountCommand()),
	
	/** The changing discount parametrs. */
	CHANGE_DISCOUNT_MANAGER(new ChangeDiscountManager()),

	/** The ordering tour. */
	ORDER_TOUR(new OrderTourCommand()),

	/** The blocking user. */
	BLOCK_USER(new BlockUserCommand()),

	/** The unblocking user. */
	UNBLOCK_USER(new UnblockUserCommand()),

	/** The order list. */
	ORDER_LIST(new OrderListCommand()),
	
	/** The changing order status to paid */
	ORDER_STATUS_UPDATE_PAID(new OrderStatusUpdateCommand()),
	
	/** The changing order status to canceled */
	ORDER_STATUS_UPDATE_CANCELED(new OrderStatusUpdateCanceledCommand()),
	
	/** The deleting tour */
	TOUR_DELETE(new DeleteTourCommand()),
	
	/** The creating burning tour */
	BURNING_TOUR(new MakeTourBurningCommand()),

	/** The forward. */
	FORWARD(new ForwardCommand());

	/** The command. */
	Command command;

	/**
     * CommandEnum constructor.
     *
     * @param command the current command
     */
    CommandEnum(Command command) {
        this.command = command;
    }

	/**
	 * Gets the current command.
	 *
	 * @return the current command
	 */
	public Command getCurrentCommand() {
		return command;
	}
}
