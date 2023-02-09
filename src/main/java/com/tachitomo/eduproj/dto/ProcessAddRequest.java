/**
 * @author Go
 * 2022/11/25
 */
package com.tachitomo.eduproj.dto;


import java.io.Serializable;



import lombok.Data;
/**
 * 処理情報登録 リクエストデータ
 */
@Data
public class ProcessAddRequest implements Serializable {
    /**
     * 処理名（記号名）
     */

    private String proccessName;
    /**
     * 処理名（日本語名）
     */

    private String proccessDisplayName;
    /**
     * 画面ID（記号名）
     */

    private String screenName;
    /**
     * 画面名（日本語名）
     */

    private String screenDisplayName;    
}
