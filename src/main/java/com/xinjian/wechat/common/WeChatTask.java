/**
 * @Title: WeChatTask.java
 * @Package com.xinjian.wechart.common
 * @Description: TODO
 * @author xinjianhou
 * @date Mar 13, 2018 2:17:18 PM
 * @version V1.0
 */

package com.xinjian.wechat.common;

import java.util.HashMap;
import java.util.Map;

import com.xinjian.wechat.util.GlobalConstants;
import com.xinjian.wechat.util.HttpUtils;

import net.sf.json.JSONObject;

/**
 * <p>
 * Title: WeChatTask
 * </p>
 * <p>
 * Description: 微信两小时定时任务体
 * </p>
 *
 * @author xinjianhou
 * @date Mar 13, 2018
 */
public class WeChatTask {

	/**
	 * <p>Title: getFollowerUserInfo </p>
	 * <p>Description:  获取订阅者的详细信息。</p>
	 * @throws Exception
	 */
	public void getFollowerUserInfo() throws Exception {

		try {
			final String userInfo = HttpUtils.sendPostBuffer(GlobalConstants.getString("userInfoUrl")+GlobalConstants.getString("access_token"), "{\n" +
					"    \"user_list\": [\n" +
					"        {\n" +
					"            \"openid\": \"oYkKxwMtA8WKmPb3zLfuxmbbs-Xs\", \n" +
					"            \"lang\": \"zh_CN\"\n" +
					"        }, \n" +
					"        {\n" +
					"            \"openid\": \"otvxTs_JZ6SEiP0imdhpi50fuSZg\", \n" +
					"            \"lang\": \"zh_CN\"\n" +
					"        }\n" +
					"    ]\n" +
					"}");
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * <p>
	 * Title: getToken_getTicket
	 * </p>
	 * <p>
	 * Description: 任务执行体
	 * </p>
	 *
	 * @throws Exception
	 */
	public void getToken_getTicket() throws Exception {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("grant_type", "client_credential");
		params.put("appid", GlobalConstants.getString("AppID"));
		params.put("secret", GlobalConstants.getString("AppSecret"));
		try {
			final String jstoken = HttpUtils.sendGet(GlobalConstants.getString("tokenUrl"), params);
			final String access_token = JSONObject.fromObject(jstoken).getString("access_token");
			// 获取到 token 并赋值保存
			GlobalConstants.interfaceUrlProperties.put("access_token", access_token);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
