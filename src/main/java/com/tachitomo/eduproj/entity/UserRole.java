/**
 * @author Go
 * createDate 2022/11/30
 */
package com.tachitomo.eduproj.entity;

import lombok.Data;
/**
 * 所有権限情報 Entity
 */
@Data
public class UserRole {
	
	/**
	 * 所有権限の主キー
	 */
    private Long id;	

	/**
	 * 利用者ID 
	 */
	private Long userId;	
	
	/**
	 * 権限ID
	 */
	private Long roleId;		
	
	/**
	 * 権限name
	 */
	private String roleName;
	
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}	
}
