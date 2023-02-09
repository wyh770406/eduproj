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
@Data
public class ProcessRoleAddRequest implements Serializable {
 
    /**
     * 処理ID
     */
    private Long ProcessId;
    
    /**
     * 権限ID
     */
    private Long roleId;
}
