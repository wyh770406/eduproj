/**
 * @author Go
 * 2022/11/30
 */
package com.tachitomo.eduproj.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.tachitomo.eduproj.dto.OperationHistoryAddRequest;
import com.tachitomo.eduproj.dto.OperationHistoryUpdateRequest;
import com.tachitomo.eduproj.entity.OperationHistory;

/**
 * 操作履歴情報 Mapper
 */
@Mapper
@Transactional
public interface OperationHistoryMapper {
    
    /**
     * 操作履歴情報全件検索
     * @param なし
     * @return 検索結果
     */
    List<OperationHistory> findAll();
    /**
     * 操作履歴情報主キー検索
     * @param id 主キー
     * @return 検索結果
     */
    OperationHistory findById(Long id);
    
    /**
     * 操作履歴情報登録
     * @param operationHistoryRequest 登録用リクエストデータ
     */
    void insert(OperationHistoryAddRequest operationHistoryRequest);
    /**
     * 操作履歴情報更新
     * @param operationHistoryUpdateRequest 更新用リクエストデータ
     */
    void update(OperationHistoryUpdateRequest operationHistoryUpdateRequest);
    /**
     * 操作履歴情報の削除
     * @param id ID
     */
    void delete(Long id);    
}
