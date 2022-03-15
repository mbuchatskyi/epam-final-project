package com.my.buch.touristagency.controller.filters;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class SecurityFilter implements Filter{

	/**
	 * The Constant LOG.
	 */
	private final static Logger LOG = Logger.getLogger(SecurityFilter.class);

	/**
	 * The Constant PARAM_NAME_COMMAND
	 */
	private static final String PARAM_NAME_COMMAND = "command";

	/**
	 * The Constant PARAM_NAME_PAGE.
	 */
	private static final String PARAM_NAME_PAGE = "page";
	
	/**
	 * The Constant PARAM_NAME_USER_ROLE.
	 */
	private static final String PARAM_NAME_USER_ROLE = "role";
	
	/**
	 * The Constant PARAM_NAME_USER_ROLE.
	 */
	private static final String PARAM_NAME_USER_ID = "id";

	/**
	 * The Constant COMMAND_NAME_FORWARD.
	 */
	private static final String COMMAND_NAME_FORWARD = "forward";

	/**
	 * The Constant REDIRECT_ADDRESS.
	 */
	private static final String REDIRECT_ADDRESS = "welcome?command=tour_list";

	/**
	 * The restricted command list.
	 */
	private ArrayList<String> commands;

	/**
	 * The restricted page list.
	 */
	private ArrayList<String> pages;

	/**
	 * Inits the.
	 *
	 * @param fConfig the f config
	 * @throws ServletException the servlet exception
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		commands = new ArrayList<>();
		pages = new ArrayList<>();
	}

	/**
	 * Do filter.
	 *
	 * @param request  the request
	 * @param response the response
	 * @param chain    the chain
	 * @throws IOException      Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		boolean pass = true;
		int role = 0;
		if (session.getAttribute(PARAM_NAME_USER_ROLE) != null & session.getAttribute(PARAM_NAME_USER_ID) != null) {
			role = (Integer) session.getAttribute(PARAM_NAME_USER_ROLE);
		}
		LOG.debug("User role = " + session.getAttribute(PARAM_NAME_USER_ROLE) + ", isNotAdmin = " + (role != 3));
		LOG.debug("User id = " + session.getAttribute(PARAM_NAME_USER_ID));
		if (role != 1) {
			pass = checkRestrictedCommands(httpRequest);
		}

		if (pass) {
			chain.doFilter(request, response);
		} else {
			httpResponse.sendRedirect(REDIRECT_ADDRESS);
		}
	}

	/**
	 * Destroy.
	 */
	public void destroy() {
	}

	private boolean checkRestrictedCommands(HttpServletRequest httpRequest) {
		boolean toReturn = true;
		String command = httpRequest.getParameter(PARAM_NAME_COMMAND);
		if (command != null && commands.contains(command)) {
			if (command.equals(COMMAND_NAME_FORWARD)) {
				String page = httpRequest.getParameter(PARAM_NAME_PAGE);
				if (page != null && pages.contains(page)) {
					toReturn = false;
				}
			} else {
				toReturn = false;
			}
		}
		return toReturn;
	}
}
