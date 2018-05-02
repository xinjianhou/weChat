package com.xinjian.wechat.pojo.service;

import java.io.Serializable;

import lombok.Data;
/**
 * <p>Title: WeChatQRCodeEvent</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 15, 2018
 */
@Data
public class WeChatQRCodeEvent implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 3949827966550695011L;

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

	/**
	 * @Fields ticket : TODO
	 */
	private String ticket;

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
		final WeChatQRCodeEvent other = (WeChatQRCodeEvent) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getEventId() == null ? other.getEventId() == null : this.getEventId().equals(other.getEventId()))
				&& (this.getEventKey() == null ? other.getEventKey() == null : this.getEventKey().equals(other.getEventKey()))
				&& (this.getTicket() == null ? other.getTicket() == null : this.getTicket().equals(other.getTicket()));
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
		result = prime * result + ((getTicket() == null) ? 0 : getTicket().hashCode());
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
		sb.append(", ticket=").append(ticket);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}