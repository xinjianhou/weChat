/**
 * @Title: Utils.java
 * @Package com.xinjian.web.util
 * @Description: TODO
 * @author xinjianhou
 * @date Apr 25, 2018 7:59:52 PM
 * @version V1.0
 */

package com.xinjian.web.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <p>Title: Utils</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 25, 2018
 */
public class Utils {

	/**
	 * <p>Title: getFollowerLabe </p>
	 * <p>Description: 获取需要显示的label</p>
	 * @param type
	 * @return
	 */
	public static String[] getFollowerLabe(final String type) {
		String[] label = null;
		if("sex".equalsIgnoreCase(type)) {
			label = new  String[]{"男性","女性","未知"};
		}else if("age".equalsIgnoreCase(type)) {
			label = new String[]{"50后","60后","70后","80后","90后","00后"};
		}
		return label;
	}
	/**
	 * <p>Title: getLastWeek </p>
	 * <p>Description: 获取今天之前一周的星期</p>
	 * @return
	 */
	public static String[] getLastWeek() {

		final Calendar cal = Calendar.getInstance();
		final List<String> week = new ArrayList<String>();
		/*获取一周七天的值*/
		for(int i = 0 ; i < 7 ; i++){
			/*将日历日期提前1天*/
			cal.add(Calendar.DATE,-1);
			/*获取当前日历的日期的星期数（1:星期天）*/
			//final int week_index = cal.get(Calendar.DAY_OF_WEEK);
			final Date date=cal.getTime();
			/*日期格式化 yyyy-MM-dd M必须大写*/
			final SimpleDateFormat formatter = new SimpleDateFormat("EE");
			final String dateString = formatter.format(date);
			week.add(dateString);
		}
		Collections.reverse(week);
		return week.toArray(new String[7]);
	}
}
