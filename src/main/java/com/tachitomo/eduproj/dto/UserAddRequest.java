/**
 * @author Go
 * 2022/11/25
 */
package com.tachitomo.eduproj.dto;


import java.io.Serializable;



import lombok.Data;
/**
 * ユーザー情報登録 リクエストデータ
 */
@Data
public class UserAddRequest implements Serializable {
    /**
     * 名前
     */

    public String username;
    /**
     * パスワード
     */

    public String password;
    /**
     * 表示名
     */

    public String displayName;
    
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
	public String getDisplayName() {
		return this.displayName;
	}	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}	
}
