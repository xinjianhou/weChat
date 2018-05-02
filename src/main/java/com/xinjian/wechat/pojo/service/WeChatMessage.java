package com.xinjian.wechat.pojo.service;

import java.io.Serializable;

import lombok.Data;

/**
 * <p>Title: WeChatMessage</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 15, 2018
 */
@Data
public class WeChatMessage implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 9223150493249466518L;

	/**
	 * @Fields id : TODO
	 */
	private Integer id;

	/**
	 * @Fields toUserName : TODO
	 */
	private String toUserName;

	/**
	 * @Fields fromUserName : TODO
	 */
	private String fromUserName;

	/**
	 * @Fields createTime : TODO
	 */
	private Long createTime;

	/**
	 * @Fields msgType : TODO
	 */
	private String msgType;

	/**
	 * @Fields msgId : TODO
	 */
	private Long msgId;

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
		final WeChatMessage other = (WeChatMessage) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getToUserName() == null ? other.getToUserName() == null : this.getToUserName().equals(other.getToUserName()))
				&& (this.getFromUserName() == null ? other.getFromUserName() == null : this.getFromUserName().equals(other.getFromUserName()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getMsgType() == null ? other.getMsgType() == null : this.getMsgType().equals(other.getMsgType()))
				&& (this.getMsgId() == null ? other.getMsgId() == null : this.getMsgId().equals(other.getMsgId()));
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getToUserName() == null) ? 0 : getToUserName().hashCode());
		result = prime * result + ((getFromUserName() == null) ? 0 : getFromUserName().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result + ((getMsgType() == null) ? 0 : getMsgType().hashCode());
		result = prime * result + ((getMsgId() == null) ? 0 : getMsgId().hashCode());
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
		sb.append(", toUserName=").append(toUserName);
		sb.append(", fromUserName=").append(fromUserName);
		sb.append(", createTime=").append(createTime);
		sb.append(", msgType=").append(msgType);
		sb.append(", msgId=").append(msgId);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}