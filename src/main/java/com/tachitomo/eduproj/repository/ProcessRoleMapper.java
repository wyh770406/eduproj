/**
 * @author Go
 * 2022/11/30
 */
package com.tachitomo.eduproj.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.tachitomo.eduproj.dto.ProcessRoleAddRequest;
import com.tachitomo.eduproj.dto.ProcessRoleUpdateRequest;
import com.tachitomo.eduproj.entity.ProcessRole;

/**
 * 所有権限情報 Mapper
 */
@Mapper
@Transactional
public interface ProcessRoleMapper {
    
    /**
     * 必要権限情報全件検索
     * @param なし
     * @return 検索結果
     */
    List<ProcessRole> findAll();
    /**
     * 必要権限情報主キー検索
     * @param id 主キー
     * @return 検索結果
     */
    ProcessRole findById(Long id);
    
    /**
     * 必要権限情報ユーザーID検索
     * @param ユーザーID
     * @return 検索結果
     */
    List<ProcessRole> findByUserId(Long userId);    

    /**
     * 必要権限情報登録
     * @param processRoleRequest 登録用リクエストデータ
     */
    void insert(ProcessRoleAddRequest processRoleRequest);
    /**
     * 必要権限情報更新
     * @param processRoleUpdateRequest 更新用リクエストデータ
     */
    void update(ProcessRoleUpdateRequest processRoleUpdateRequest);
    /**
     * 必要権限情報の削除
     * @param id ID
     */
    void delete(Long id);    
}
