package com.my.buch.touristagency.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.my.buch.touristagency.command.client.CommandEnum;

public class Action {
	 private final static Logger LOG = Logger.getLogger(Action.class);

	    private static final String PARAM_NAME_COMMAND = "command";

	    /**
	     * Define command.
	     *
	     * @param request the request
	     * @param response the response
	     * @return the action command
	     */
	    public Command defineCommand(HttpServletRequest request, HttpServletResponse response) {
	        Command current = new ConfigCommand();
	        String action = request.getParameter(PARAM_NAME_COMMAND);
	        LOG.debug("Action = " + action);
	        if (action == null || action.isEmpty()) {
	            return current;
	        }
	        try {
	            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
	            current = currentEnum.getCurrentCommand();
	        } catch (IllegalArgumentException e) {
	            request.setAttribute("wrongAction", action
	                    + "wrong action");
	        }
	        return current;
	    }
}
