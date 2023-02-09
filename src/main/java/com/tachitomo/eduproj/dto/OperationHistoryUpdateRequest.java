/**
 * @author Go
 * 2022/11/25
 */
package com.tachitomo.eduproj.dto;


import java.io.Serializable;



import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 操作履歴情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OperationHistoryUpdateRequest extends UserAddRequest implements Serializable {
    /**
     * 操作履歴ID
     */

    private Long id;
}
