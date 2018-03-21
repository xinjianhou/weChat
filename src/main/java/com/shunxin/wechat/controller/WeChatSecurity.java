package com.shunxin.wechat.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shunxin.wechat.dispatcher.EventDispatcher;
import com.shunxin.wechat.dispatcher.MsgDispatcher;
import com.shunxin.wechat.util.MessageUtil;
import com.shunxin.wechat.util.SignUtil;

/**
 * <p>
 * Title: WeChatSecurity
 * </p>
 * <p>
 * Description: 消息处理器
 * </p>
 *
 * @author xinjianhou
 * @date Mar 12, 2018
 */
@Controller
@RequestMapping("/wechat")
public class WeChatSecurity {

	/**
	 * <p>
	 * Title: doGet
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param request
	 * @param response
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 */
	@RequestMapping(value = "/security", method = RequestMethod.GET)
	public void doGet(final HttpServletRequest request, final HttpServletResponse response,
			@RequestParam(value = "signature", required = true) final String signature,
			@RequestParam(value = "timestamp", required = true) final String timestamp,
			@RequestParam(value = "nonce", required = true) final String nonce,
			@RequestParam(value = "echostr", required = true) final String echostr) {
		try {
			if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				final PrintWriter out = response.getWriter();
				out.print(echostr);
				out.close();
			} else {
				System.out.println("这里存在非法请求！");
			}
		} catch (final Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * Title: DoPost
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @return
	 */
	@RequestMapping(value = "security", method = RequestMethod.POST)
	// post 方法用于接收微信服务端消息
	public void DoPost(final HttpServletRequest request, final HttpServletResponse response) {
		try {
			final PrintWriter out = response.getWriter();
			final Map<String, String> map = MessageUtil.parseXml(request);
			System.out.println("=============================" + map.toString() + "======================");
			final String msgType = map.get("MsgType");
			if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgType)) {
				EventDispatcher.processEvent(map);
			} else {
				final String msg = MsgDispatcher.processMessage(map);

				out.print(msg);
				out.close();

			}

		} catch (final Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

}
