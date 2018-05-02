package com.xinjian.wechat.service.message.response;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xinjianhou
 *
 * @date Mar 11, 2018
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NewsResMessage extends BaseResMessage {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 3862749539007113465L;
	/**
	 * @Fields ArticleCount : TODO
	 */
	private int ArticleCount;
	/**
	 * @Fields Articles : TODO
	 */
	private List<Article> Articles;
}
