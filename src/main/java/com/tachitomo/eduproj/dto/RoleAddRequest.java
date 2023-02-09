/**
 * @author Go
 * 2022/11/30
 */
package com.tachitomo.eduproj.dto;


import java.io.Serializable;



import lombok.Data;
/**
 * 権限情報登録 リクエストデータ
 */
@Data
public class RoleAddRequest implements Serializable {
    /**
     * 権限名
     */

    private String name;

}
