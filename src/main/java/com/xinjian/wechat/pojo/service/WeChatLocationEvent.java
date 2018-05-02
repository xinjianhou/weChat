package com.xinjian.wechat.pojo.service;

import java.io.Serializable;

import lombok.Data;
/**
 * <p>Title: WeChatLocationEvent</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 15, 2018
 */
@Data
public class WeChatLocationEvent implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 7880812196744528308L;

	/**
	 * @Fields id : TODO
	 */
	private Integer id;

	/**
	 * @Fields eventId : TODO
	 */
	private Integer eventId;

	/**
	 * @Fields latitude : TODO
	 */
	private String latitude;

	/**
	 * @Fields longitude : TODO
	 */
	private String longitude;

	/**
	 * @Fields precisionVal : TODO
	 */
	private String precisionVal;

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
		final WeChatLocationEvent other = (WeChatLocationEvent) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getEventId() == null ? other.getEventId() == null : this.getEventId().equals(other.getEventId()))
				&& (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
				&& (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
				&& (this.getPrecisionVal() == null ? other.getPrecisionVal() == null : this.getPrecisionVal().equals(other.getPrecisionVal()));
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
		result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
		result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
		result = prime * result + ((getPrecisionVal() == null) ? 0 : getPrecisionVal().hashCode());
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
		sb.append(", latitude=").append(latitude);
		sb.append(", longitude=").append(longitude);
		sb.append(", precisionVal=").append(precisionVal);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}