package com.xinjian.wechat.pojo.service;

import java.io.Serializable;

import lombok.Data;
/**
 * <p>Title: WeChatLocationMessage</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Apr 15, 2018
 */
@Data
public class WeChatLocationMessage implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -8004113780281708160L;

	/**
	 * @Fields id : TODO
	 */
	private Integer id;

	/**
	 * @Fields msgId : TODO
	 */
	private Integer msgId;

	/**
	 * @Fields locationX : TODO
	 */
	private String locationX;

	/**
	 * @Fields locationY : TODO
	 */
	private String locationY;

	/**
	 * @Fields scale : TODO
	 */
	private String scale;

	/**
	 * @Fields label : TODO
	 */
	private String label;

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
		final WeChatLocationMessage other = (WeChatLocationMessage) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getMsgId() == null ? other.getMsgId() == null : this.getMsgId().equals(other.getMsgId()))
				&& (this.getLocationX() == null ? other.getLocationX() == null : this.getLocationX().equals(other.getLocationX()))
				&& (this.getLocationY() == null ? other.getLocationY() == null : this.getLocationY().equals(other.getLocationY()))
				&& (this.getScale() == null ? other.getScale() == null : this.getScale().equals(other.getScale()))
				&& (this.getLabel() == null ? other.getLabel() == null : this.getLabel().equals(other.getLabel()));
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
		result = prime * result + ((getLocationX() == null) ? 0 : getLocationX().hashCode());
		result = prime * result + ((getLocationY() == null) ? 0 : getLocationY().hashCode());
		result = prime * result + ((getScale() == null) ? 0 : getScale().hashCode());
		result = prime * result + ((getLabel() == null) ? 0 : getLabel().hashCode());
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
		sb.append(", locationX=").append(locationX);
		sb.append(", locationY=").append(locationY);
		sb.append(", scale=").append(scale);
		sb.append(", label=").append(label);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}