package com.my.buch.touristagency.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.buch.touristagency.command.exceptionCommand.CommandException;

public interface Command {
	
	/**
	 * Execute.
	 *
	 * @param request  the request from the client
	 * @param response the response
	 * @return the string
	 * @throws CommandException the command exception
	 */
	String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException;
}
