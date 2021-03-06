/**
 * @Title: QuartzJob.java
 * @Package com.xinjian.wechart.quartz
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 13, 2018 2:59:50 PM
 * @version V1.0
 */

package com.xinjian.wechat.quartz;

import com.xinjian.wechat.common.WeChatTask;

/**
 * <p>Title: QuartzJob</p>
 * <p>Description: 定时任务 </p>
 * @author xinjianhou
 * @date Mar 13, 2018
 */
public class QuartzJob {

	/**
	 * <p>Title: workForToken </p>
	 * <p>Description: 获取token 的任务 </p>
	 */
	public void workForToken() {
		try {
			final WeChatTask timer = new WeChatTask();
			timer.getToken_getTicket();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	public void workForUerInfo() {
		try {
			final WeChatTask timer = new WeChatTask();
			timer.getFollowerUserInfo();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
