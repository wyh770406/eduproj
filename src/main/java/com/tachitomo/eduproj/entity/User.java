/**
 *
 */
package com.tachitomo.eduproj.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
 * ユーザー情報 Entity
 */
@Data
@Getter
@Setter
public class User {

    /**
     * 利用者の主キー
     */
    private Long id;

	/**
	 * パスワード有効期間（自）
	 */
	private Date passwordFrom;

	/**
	 * パスワード有効期間（至）
	 */
	private Date passwordTo;

	/**
	 * ログイン日時
	 */
	private Timestamp loginSuccessTime;

	/**
	 * エラー日時
	 */
	private Timestamp loginFailureTime;

	/**
	 * ユーザ名
	 */
	private String username;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * 表示名
	 */
	private String displayName;

	/**
	 * 利用状態
	 */
	private String state;

	/**
	 * 所属部署コード
	 */
	private String deptCode;

	/**
	 * ログイン回数
	 */
	private int loginSuccessTimes;

	/**
	 * エラー回数
	 */
	private int loginFailureTimes;

	/**
	 * 作成日時
	 */
	public Timestamp createTime;

	/**
	 * 更新日時
	 */
	private Timestamp updateTime;

	/**
	 * バージョン番号
	 */
	private int versionNumber;

	/**
	 * 作成利用者ID
	 */
	private Long createUser;

	/**
	 * 更新利用者ID
	 */
	private Long updateUser;

	/**
	 * 権限リスト
	 */
	private List<Role> roleList = new ArrayList<Role>();
	
	/**
	 * 権限リスト
	 */
	private List<UserRole> userRoleList = new ArrayList<UserRole>();

	/**
	 * 権限リスト取得
	 * 利用者の権限リストを取得する。
     * @return 権限リスト
	 */
	public List<Role> getRoles() {
		return roleList;
	}

	/**
	 * 所有権限判定
	 * 権限IDで示す権限を所有していること判定する。
	 * 権限を所有している場合、Trueを返却。
	 * 権限を所有していない場合、Falseを返却。
     * @param  権限ID
     * @return 所有有無
	 */
	public boolean hasRole(int id) {
		return roleList.stream()
			.filter(r -> r.getId() == id)
			.count() > 0;
	}
	
	/**
	 * 権限リスト取得
     * @return 権限リスト
	 */
	public List<UserRole> getUserRoles() {
		return userRoleList;
	}

	/**
	 * 所有権限判定
     * @param  権限ID
     * @return 所有有無
	 */
	public boolean hasUserRole(int id) {
		return true;
	}

	public List<UserRole> getUserRoleList() {
		return this.userRoleList;
	}

	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}	
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getLoginFailureTimes() {
		return this.loginFailureTimes;
	}
	
	public int getLoginSuccessTimes() {
		return this.loginSuccessTimes;
	}	

	public void setLoginFailureTimes(int loginFailureTimes) {
		this.loginFailureTimes = loginFailureTimes;
	}	
	
	public void setLoginSuccessTimes(int loginSuccessTimes) {
		this.loginSuccessTimes = loginSuccessTimes;
	}	
	
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}	
	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}		
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
	public Date getPasswordFrom() {
		return this.passwordFrom;
	}

	public void setPasswordFrom(Date passwordFrom) {
		this.passwordFrom = passwordFrom;
	}	
	
	public Date getPasswordTo() {
		return this.passwordTo;
	}

	public void setPasswordTo(Date passwordTo) {
		this.passwordTo = passwordTo;
	}
	
	public int getVersionNumber() {
		return this.versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}	
	
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}	
	
	public String getDisplayName() {
		return this.displayName;
	}	

}
