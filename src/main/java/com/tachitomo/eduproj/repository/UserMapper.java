/**
 * @author Go
 * 2022/11/25
 */
package com.tachitomo.eduproj.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.tachitomo.eduproj.dto.UserAddRequest;
import com.tachitomo.eduproj.dto.UserSearchRequest;
import com.tachitomo.eduproj.dto.UserUpdateRequest;
import com.tachitomo.eduproj.entity.User;

/**
 * ユーザー情報 Mapper
 */
@Mapper
@Transactional
public interface UserMapper {
    /**
     * ユーザー情報検索
     * @param user 検索用リクエストデータ
     * @return 検索結果
     */
    List<User> search(UserSearchRequest user);
    
    /**
     * ユーザー情報全件検索
     * @param なし
     * @return 検索結果
     */
    List<User> findAll();
    /**
     * ユーザー情報主キー検索
     * @param id 主キー
     * @return 検索結果
     */
    User findById(Long id);
    
    /**
     * ユーザー情報ユーザー名前検索
     * @param ユーザー名前
     * @return 検索結果
     */
    User findByUsername(String username);    

    /**
     * ユーザー情報登録
     * @param userRequest 登録用リクエストデータ
     */
    void save(UserAddRequest userRequest);
    /**
     * ユーザー情報更新
     * @param userUpdateRequest 更新用リクエストデータ
     */
    void update(UserUpdateRequest userUpdateRequest);
    /**
     * ユーザー情報の削除
     * @param id ID
     */
    void delete(Long id);    
}
