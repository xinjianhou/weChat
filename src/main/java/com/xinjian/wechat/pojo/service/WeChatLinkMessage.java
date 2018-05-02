package com.xinjian.wechat.pojo.service;

import java.io.Serializable;

import lombok.Data;

/**
 * <p>Title: WeChatLinkMessage</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 15, 2018
 */
@Data
public class WeChatLinkMessage implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 3836975878087980062L;

	/**
	 * @Fields id : TODO
	 */
	private Integer id;

	/**
	 * @Fields msgId : TODO
	 */
	private Integer msgId;

	/**
	 * @Fields title : TODO
	 */
	private String title;

	/**
	 * @Fields description : TODO
	 */
	private String description;

	/**
	 * @Fields url : TODO
	 */
	private String url;

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		final WeChatLinkMessage other = (WeChatLinkMessage) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getMsgId() == null ? other.getMsgId() == null : this.getMsgId().equals(other.getMsgId()))
				&& (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
				&& (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
				&& (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()));
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getMsgId() == null) ? 0 : getMsgId().hashCode());
		result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
		result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
		result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", msgId=").append(msgId);
		sb.append(", title=").append(title);
		sb.append(", description=").append(description);
		sb.append(", url=").append(url);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}