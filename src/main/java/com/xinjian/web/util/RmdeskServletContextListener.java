/**
 * @Title: RmdeskServletContextListener.java
 * @Package com.xinjian.web.util
 * @Description: TODO
 * @author xinjianhou
 * @date May 7, 2018 9:41:55 PM
 * @version V1.0
 */

package com.xinjian.web.util;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * <p>Title: RmdeskServletContextListener</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date May 7, 2018
 */
public class RmdeskServletContextListener implements ServletContextListener {

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(final ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}



	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(final ServletContextEvent arg0) {
		System.out.println("-------------进入---ServletContextEvent----------------");
		final Timer timer = new Timer();

		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					POP3ReceiveMailTest.resceive();
				} catch (final Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 1000,1000*60);//1000*60*60*24

	}

}
