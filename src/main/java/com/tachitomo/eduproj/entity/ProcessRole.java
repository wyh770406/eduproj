/**
 * @author Go
 * createDate 2022/11/30
 */
package com.tachitomo.eduproj.entity;

import lombok.Data;
/**
 * 必要権限情報 Entity
 */
@Data
public class ProcessRole {
	
	/**
	 * 必要権限の主キー
	 */
	private Long id;

	/**
	 * 処理ID 
	 */
	private int processId;	
	
	/**
	 * 権限ID
	 */
	private int roleId;		

}
