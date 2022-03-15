package com.my.buch.touristagency.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.my.buch.touristagency.command.Action;
import com.my.buch.touristagency.command.Command;
import com.my.buch.touristagency.command.exceptionCommand.CommandException;
import com.my.buch.touristagency.managers.ConfigurationManager;

@WebServlet(urlPatterns = "/welcome", initParams = @WebInitParam(name = "init_log4j", value = "log4j.xml"))
public class Controller extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static Logger LOG = Logger.getLogger(Controller.class);
	
	/**
     * Inits the.
     *
     * @throws ServletException the servlet exception
     */
    @Override
    public void init() throws ServletException {
        String prefix = getServletContext().getRealPath("/");
        String filename = getInitParameter("init_log4j");
        if (filename != null) {
            new DOMConfigurator().doConfigure(prefix + filename, LogManager.getLoggerRepository());
        }
    }

    /**
     * Destroy.
     */
    @Override
    public void destroy() {
        super.destroy();
    }

    /**
     * Do get.
     *
     * @param request the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Do post.
     *
     * @param request the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * Process request.
     *
     * @param request the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        Action client = new Action();
        Command command = client.defineCommand(request, response);
        try {
            page = command.execute(request, response);
        } catch (CommandException e) {
            LOG.error(e);
        }
        if (page != null) {
            LOG.debug("redirect = " + request.getAttribute("redirect"));
            LOG.debug("referer = " + request.getHeader("referer"));
            if (request.getAttribute("redirect") != null){
                response.sendRedirect(request.getAttribute("redirect").toString());
            } else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
                dispatcher.forward(request, response);
            }
        } else {
            page = ConfigurationManager.getProperty("path.page.main");
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
