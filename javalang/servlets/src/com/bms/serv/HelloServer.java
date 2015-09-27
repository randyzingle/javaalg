package com.bms.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloServer
 */
@WebServlet(
		urlPatterns = { "/HelloServer", "/helloserver" }, 
		initParams = { 
				@WebInitParam(name = "name", value = "Baldur", description = "default name of guest")
		})
public class HelloServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String bname = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServer() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) {
    	bname = config.getInitParameter("name");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter pw = response.getWriter()) {
			ServletContext context = request.getServletContext();
			// send a cookie named JSESSIONID to the client for session tracking
			SessionCookieConfig config = context.getSessionCookieConfig();
//			config.setHttpOnly(true); -> can't do this here as the context has been initialized already?
			// get the session
			HttpSession session = request.getSession(true);
			session.setAttribute("class", "paladin");
			String name = request.getParameter("name");
			if (name==null) name = bname;
			pw.append("<html><head></head><body><h2>Hey there " + name + "!!</h2></body></html>");
			pw.flush();
		} finally {
			// ... try with resources should auto-close the printwriter
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
