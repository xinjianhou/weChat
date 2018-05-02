package com.xinjian.wechat.pojo.service;

import java.io.Serializable;

import lombok.Data;
/**
 * <p>Title: WeChatVideoMessage</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 15, 2018
 */
@Data
public class WeChatVideoMessage implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 696088977495877283L;

	/**
	 * @Fields id : TODO
	 */
	private Integer id;

	/**
	 * @Fields msgId : TODO
	 */
	private Integer msgId;

	/**
	 * @Fields mediaId : TODO
	 */
	private String mediaId;

	/**
	 * @Fields thumbMediaId : TODO
	 */
	private String thumbMediaId;

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
		final WeChatVideoMessage other = (WeChatVideoMessage) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getMsgId() == null ? other.getMsgId() == null : this.getMsgId().equals(other.getMsgId()))
				&& (this.getMediaId() == null ? other.getMediaId() == null : this.getMediaId().equals(other.getMediaId()))
				&& (this.getThumbMediaId() == null ? other.getThumbMediaId() == null : this.getThumbMediaId().equals(other.getThumbMediaId()));
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
		result = prime * result + ((getMediaId() == null) ? 0 : getMediaId().hashCode());
		result = prime * result + ((getThumbMediaId() == null) ? 0 : getThumbMediaId().hashCode());
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
		sb.append(", mediaId=").append(mediaId);
		sb.append(", thumbMediaId=").append(thumbMediaId);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}