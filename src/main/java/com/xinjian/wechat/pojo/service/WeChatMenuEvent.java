package com.xinjian.wechat.pojo.service;

import java.io.Serializable;

import lombok.Data;
/**
 * <p>Title: WeChatMenuEvent</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 15, 2018
 */
@Data
public class WeChatMenuEvent implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 4079166985747327255L;

	/**
	 * @Fields id : TODO
	 */
	private Integer id;

	/**
	 * @Fields eventId : TODO
	 */
	private Integer eventId;

	/**
	 * @Fields eventKey : TODO
	 */
	private String eventKey;

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
		final WeChatMenuEvent other = (WeChatMenuEvent) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getEventId() == null ? other.getEventId() == null : this.getEventId().equals(other.getEventId()))
				&& (this.getEventKey() == null ? other.getEventKey() == null : this.getEventKey().equals(other.getEventKey()));
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getEventId() == null) ? 0 : getEventId().hashCode());
		result = prime * result + ((getEventKey() == null) ? 0 : getEventKey().hashCode());
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
		sb.append(", eventId=").append(eventId);
		sb.append(", eventKey=").append(eventKey);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}