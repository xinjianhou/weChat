/**
 * @Title: RmdeskServletContextListener.java
 * @Package com.xinjian.web.util
 * @Description: TODO
 * @author xinjianhou
 * @date May 7, 2018 9:41:55 PM
 * @version V1.0
 */

package com.xinjian.web.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xinjian.web.service.mail.IReceiveMaillService;

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
		final IReceiveMaillService mailService = (IReceiveMaillService) WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext()).getBean("receiveMaillServiceImpl");

		final Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					mailService.resceive();
				} catch (final Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		final ScheduledExecutorService service = Executors
				.newSingleThreadScheduledExecutor();
		// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
		service.scheduleAtFixedRate(runnable, 10, 10, TimeUnit.SECONDS);

	}

}
