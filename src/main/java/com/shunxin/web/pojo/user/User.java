package com.shunxin.web.pojo.user;

import com.shunxin.web.pojo.BasePOJO;

import lombok.Data;

@Data
public class User extends BasePOJO {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 5874195777001412503L;

	/**
	 * @Fields userId : TODO
	 */
	private Integer userId;

	/**
	 * @Fields userName : TODO
	 */
	private String userName;

	/**
	 * @Fields password : TODO
	 */
	private String password;

	/**
	 * @Fields realName : TODO
	 */
	private String realName;

	/**
	 * @Fields status : TODO
	 */
	private String status;



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
		final User other = (User) that;
		return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
				&& (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
				&& (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
				&& (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
		result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
		result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
		result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
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
		sb.append(", userId=").append(userId);
		sb.append(", userName=").append(userName);
		sb.append(", password=").append(password);
		sb.append(", realName=").append(realName);
		sb.append(", status=").append(status);
		sb.append(", createTime=").append(createTime);
		sb.append(", updateTime=").append(updateTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}