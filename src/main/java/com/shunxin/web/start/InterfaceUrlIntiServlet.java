package com.shunxin.web.start;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author xinjianhou
 *
 * @date Mar 11, 2018
 */
public class InterfaceUrlIntiServlet extends HttpServlet {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -1268697282948624543L;

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(final ServletConfig config) throws ServletException{

		InterfaceUrlInti.init();

	}


}
