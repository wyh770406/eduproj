/**
 * 
 */
package com.tachitomo.eduproj.dto;

import java.io.Serializable;

import lombok.Data;
/**
 * ユーザー情報 検索用リクエストデータ
 */
@Data

/**
 * @author Go
 *
 */
public class UserSearchRequest implements Serializable {
	  /**
	   * ユーザーID
	   */
	  private Long id;
	  
	  /**
	   * ユーザー名
	   */
	  private String name;	  
	  
		public Long getId() {
			return this.id;
		}

		public void setId(Long id) {
			this.id = id;
		}	
		
		public String getName() {
			return this.name;
		}
		
		public void setName(String name) {
			this.name = name;
		}	

}
