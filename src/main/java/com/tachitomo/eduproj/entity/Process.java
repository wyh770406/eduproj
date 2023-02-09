/**
 * @author Go
 * createDate 2022/11/30
 */
package com.tachitomo.eduproj.entity;

import java.sql.Timestamp;

import lombok.Data;
/**
 * 処理情報 Entity
 */
@Data
public class Process {
	
	/**
	 * 処理の主キー
	 */
	private Long id;

	/**
	 * 処理名（記号名）
	 */
	private String processName;
	
	/**
	 * 処理名（日本語名）
	 */
	private String processDisplayName;	
	
	/**
	 * 画面ID（記号名）
	 */
	private String screenName;
	
	/**
	 * 画面名（日本語名）
	 */
	private String screenDisplayName;	
	
	/**
	 * 画面ID（記号名）
	 */
	private String methodName;
	
	/**
	 * 画面名（日本語名）
	 */
	private String className;		

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
	private Long createUser;	
	
	/**
	 * 更新利用者ID 
	 */
	private Long updateUser;		

}
