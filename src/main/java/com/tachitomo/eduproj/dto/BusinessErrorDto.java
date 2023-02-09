package com.tachitomo.eduproj.dto;

import lombok.Data;

/**
 * エラーのデータのクラス
 * @author Administrator
 *
 */
@Data
public class BusinessErrorDto {
	/** 出力テキストボックス */
	private String msgID;
	/** 出力テキストボックス */
	private String msgName;
	
	public BusinessErrorDto() {
	}
	
	public BusinessErrorDto(String msgID,String msgName) {
		this.msgID=msgID;
		this.msgName=msgName;
	}
	
}
