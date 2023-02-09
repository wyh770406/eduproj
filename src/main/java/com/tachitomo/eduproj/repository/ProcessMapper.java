/**
 * @author Go
 * 2022/11/30
 */
package com.tachitomo.eduproj.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.tachitomo.eduproj.dto.ProcessAddRequest;
import com.tachitomo.eduproj.dto.ProcessUpdateRequest;
import com.tachitomo.eduproj.entity.Role;

/**
 * 処理情報 Mapper
 */
@Mapper
@Transactional
public interface ProcessMapper {
    
    /**
     * 処理情報全件検索
     * @param なし
     * @return 検索結果
     */
    List<Role> findAll();
    /**
     * 処理情報主キー検索
     * @param id 主キー
     * @return 検索結果
     */
    Role findById(Long id);
    
    /**
     * 処理情報登録
     * @param processRequest 登録用リクエストデータ
     */
    void insert(ProcessAddRequest processRequest);
    /**
     * 処理情報更新
     * @param processUpdateRequest 更新用リクエストデータ
     */
    void update(ProcessUpdateRequest processUpdateRequest);
    /**
     * 処理情報の削除
     * @param id ID
     */
    void delete(Long id);    
}
