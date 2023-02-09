/**
 * @author Go
 * 2022/11/30
 */
package com.tachitomo.eduproj.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.tachitomo.eduproj.dto.UserRoleAddRequest;
import com.tachitomo.eduproj.dto.UserRoleUpdateRequest;
import com.tachitomo.eduproj.entity.UserRole;

/**
 * 必要権限情報 Mapper
 */
@Mapper
@Transactional
public interface UserRoleMapper {
    
    /**
     * 所有権限情報全件検索
     * @param なし
     * @return 検索結果
     */
    List<UserRole> findAll();
    /**
     * 所有権限情報主キー検索
     * @param id 主キー
     * @return 検索結果
     */
    UserRole findById(Long id);
    
    /**
     * 所有権限情報ユーザーID検索
     * @param userId ユーザーID
     * @return 検索結果
     */
    List<UserRole> findByUserId(Long userId);    

    /**
     * 所有権限情報登録
     * @param userRoleRequest 登録用リクエストデータ
     */
    void insert(UserRoleAddRequest userRoleRequest);
    /**
     * 所有権限情報更新
     * @param userUpdateRequest 更新用リクエストデータ
     */
    void update(UserRoleUpdateRequest userRoleUpdateRequest);
    /**
     * 所有権限情報の削除
     * @param id ID
     */
    void delete(Long id);    
}
