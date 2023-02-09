/**
 * @author Go
 * 2022/11/30
 */
package com.tachitomo.eduproj.dto;


import java.io.Serializable;

import lombok.Data;
/**
 * 所有権限情報登録 リクエストデータ
 */
@Data
public class UserRoleAddRequest implements Serializable {
 
    /**
     * 利用者ID 
     */
    private Long userId;
    
    /**
     * 権限ID
     */
    private Long roleId;
}
