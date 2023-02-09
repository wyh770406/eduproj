/**
 * @author Go
 * createDate 2022/11/30
 */
package com.tachitomo.eduproj.entity;

import java.sql.Timestamp;

import lombok.Data;
/**
 * 権限情報 Entity
 */
@Data
public class Role {

	/**
	 * 権限の主キー
	 */
    private Long id;

	/**
	 * 権限名
	 */
	private String name;

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

	//TODO @Dataが効かないので仮追加
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
