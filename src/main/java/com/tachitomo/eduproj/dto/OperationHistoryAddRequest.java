/**
 * @author Go
 * 2022/11/30
 */
package com.tachitomo.eduproj.dto;


import java.io.Serializable;
import java.sql.Timestamp;



import lombok.Data;
/**
 * 権限情報登録 リクエストデータ
 */
@Data
public class OperationHistoryAddRequest implements Serializable {
    /**
     * 操作理由
     */


    private String reason;
    
    /**
     * 操作キー
     */


    private String targetKey;
    
    /**
     * 操作対象
     */


    private String target;
    
    /**
     * 操作内容
     */


    private String message;    
    
    /**
     * 利用者ID
     */
    private Long userId;
    
    /**
     * 操作日時
     */
    private Timestamp operationTime;    
    
    /**
     * 作成日時
     */
    private Timestamp createTime;   
    
    /**
     * 更新日時
     */
    private Timestamp updateTime;    
    
	/**
	 * 作成利用者ID
	 */
	private Long createUser;

	/**
	 * 更新利用者ID
	 */
	private Long updateUser;    
    
	/**
	 * バージョン番号
	 */
	private int versionNumber;  
	
	public int getVersionNumber() {
		return this.versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}	
	
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}	
	
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}	
	
	public Long getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}	
	
	public Long getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}	
	
	public Timestamp getOperationTime() {
		return this.operationTime;
	}

	public void setOperationTime(Timestamp operationTime) {
		this.operationTime = operationTime;
	}
	
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
	
	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}	
	
	public String getTargetKey() {
		return this.targetKey;
	}

	public void setTargetKey(String targetKey) {
		this.targetKey = targetKey;
	}	
	
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}	
	

}
