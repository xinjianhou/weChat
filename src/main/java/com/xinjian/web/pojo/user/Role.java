package com.xinjian.web.pojo.user;

import com.xinjian.web.pojo.BasePOJO;

import lombok.Data;

/**
 * <p>Title: Role</p>
 * <p>Description: </p>
 * @author xinjianhou
 * @date Mar 17, 2018
 */
@Data
public class Role extends BasePOJO {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 7846072980627509752L;

	/**
	 * @Fields roleId : TODO
	 */
	private Integer roleId;

	/**
	 * @Fields roleCd : TODO
	 */
	private String roleCd;

	/**
	 * @Fields roleName : TODO
	 */
	private String roleName;

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
		final Role other = (Role) that;
		return (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
				&& (this.getRoleCd() == null ? other.getRoleCd() == null : this.getRoleCd().equals(other.getRoleCd()))
				&& (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
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
		result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
		result = prime * result + ((getRoleCd() == null) ? 0 : getRoleCd().hashCode());
		result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
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
		sb.append(", roleId=").append(roleId);
		sb.append(", roleCd=").append(roleCd);
		sb.append(", roleName=").append(roleName);
		sb.append(", status=").append(status);
		sb.append(", createTime=").append(createTime);
		sb.append(", updateTime=").append(updateTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}