/**
 * @author Go
 * 2022/11/25
 */
package com.tachitomo.eduproj.dto;


import java.io.Serializable;
import java.sql.Timestamp;



import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * ユーザー情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserUpdateRequest extends UserAddRequest implements Serializable {
    /**
     * ユーザーID
     */

    private Long id;
    /**
     * 名前
     */

    //private String username;
    /**
     * パスワード
     */

    //private String password;
    /**
     * 表示名
     */

    //private String displayName;    
    
	/**
	 * 利用状態
	 */
	private String state;    
	
	/**
	 * エラー回数
	 */
	private int loginFailureTimes;	
	
	/**
	 * エラー日時
	 */
	private Timestamp loginFailureTime;	
	
	/**
	 * ログイン日時
	 */
	private Timestamp loginSuccessTime;
	
	/**
	 * ログイン回数
	 */
	private int loginSuccessTimes;	
	
	/**
	 * 更新日時
	 */
	private Timestamp updateTime;
	

	/**
	 * 更新利用者ID
	 */
	private Long updateUser;	

	/**
	 * バージョン番号
	 */
	private int versionNumber;	  
	
	public Long getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}	
	
	public int getVersionNumber() {
		return this.versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}	
	
	public String getState() {
		return this.state;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}	
	public void setUsername(String username) {
		this.username = username;
	}		
	public void setPassword(String password) {
		this.password = password;
	}	

	public void setState(String state) {
		this.state = state;
	}	
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
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
	
	public Timestamp getLoginFailureTime() {
		return this.loginFailureTime;
	}

	public void setLoginFailureTime(Timestamp loginFailureTime) {
		this.loginFailureTime = loginFailureTime;
	}	
	
	
	public Timestamp getLoginSuccessTime() {
		return this.loginSuccessTime;
	}

	public void setLoginSuccessTime(Timestamp loginSuccessTime) {
		this.loginSuccessTime = loginSuccessTime;
	}		
}
