/**
 * @author Go
 * 2022/11/30
 */
package com.tachitomo.eduproj.dto;


import java.io.Serializable;


import lombok.Data;
/**
 * 必要権限情報登録 リクエストデータ
 */

public class ProcessRoleUpdateRequest extends UserRoleAddRequest implements Serializable {
 
    /**
     *必要権限ID
     */

    private Long id;
}
