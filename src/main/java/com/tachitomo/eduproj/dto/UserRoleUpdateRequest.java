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

public class UserRoleUpdateRequest extends UserRoleAddRequest implements Serializable {
 
    /**
     *所有権限ID
     */

    private Long id;
}
