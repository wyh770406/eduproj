/**
 * @author Go
 * 2022/11/30
 */
package com.tachitomo.eduproj.dto;


import java.io.Serializable;


import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 権限情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleUpdateRequest extends RoleAddRequest implements Serializable {
    /**
     * 権限ID
     */

    private Long id;
}
