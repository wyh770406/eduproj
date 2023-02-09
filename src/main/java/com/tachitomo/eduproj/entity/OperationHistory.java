/**
 * @author Go
 * createDate 2022/11/30
 */
package com.tachitomo.eduproj.entity;

import java.sql.Timestamp;

import lombok.Data;
/**
 * 操作履歴情報 Entity
 */
@Data
public class OperationHistory {
	
	/**
	 * 操作履歴の主キー
	 */
    private Long id;

	/**
	 * 操作日時
	 */
	private Timestamp operationTime;	
	
	/**
	 * 利用者ID 
	 */
	private int userId;		

	/**
	 *操作対象
	 */
	private String target;

	/**
	 *操作理由
	 */
	private String reason;

	/**
	 *操作キー
	 */
	private String targetKey;

	/**
	 *操作内容
	 */
	private String message;

	/**
	 *削除フラグ
	 */
	private String deleteFlag;

	/**
	 * 作成日時
	 */
	private Timestamp createTime;

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
	private int createUser;	
	
	/**
	 * 更新利用者ID 
	 */
	private int updateUser;		

}
