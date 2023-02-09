/**
 * @author Go
 * 2022/11/30
 */
package com.tachitomo.eduproj.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.tachitomo.eduproj.dto.RoleAddRequest;
import com.tachitomo.eduproj.dto.RoleUpdateRequest;
import com.tachitomo.eduproj.entity.Role;

/**
 * 権限情報 Mapper
 */
@Mapper
@Transactional
public interface RoleMapper {
    
    /**
     * 権限情報全件検索
     * @param なし
     * @return 検索結果
     */
    List<Role> findAll();
    /**
     * 権限情報主キー検索
     * @param id 主キー
     * @return 検索結果
     */
    Role findById(Long id);
    
    /**
     * 権限情報登録
     * @param userRoleRequest 登録用リクエストデータ
     */
    void insert(RoleAddRequest roleRequest);
    /**
     * 権限情報更新
     * @param userUpdateRequest 更新用リクエストデータ
     */
    void update(RoleUpdateRequest roleUpdateRequest);
    /**
     * 権限情報の削除
     * @param id ID
     */
    void delete(Long id);    
}
