
/**
 * @author Go
 * 2022/11/30
 *
 */
package com.tachitomo.eduproj.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Repository;

import com.tachitomo.eduproj.dto.UserRoleAddRequest;
import com.tachitomo.eduproj.dto.UserRoleUpdateRequest;
import com.tachitomo.eduproj.entity.UserRole;
import com.tachitomo.eduproj.repository.UserRoleMapper;

@Repository
public class UserRoleRepository implements UserRoleMapper {

    @Autowired
    private SqlSession sqlSession;
       
    /**
     * 所有権限情報全件検索
     * @param なし
     * @return 検索結果
     */
    public List<UserRole> findAll(){
    	return sqlSession.selectList("com.tachitomo.eduproj.repository.UserRoleMapper.findAll");
    }   
	
    /**
     * 主キー検索
     * @param id ID
     * @return エンティティ
     */
    public UserRole findById(Long id) {
        return sqlSession.selectOne("com.tachitomo.eduproj.repository.UserRoleMapper.findById", id);
    }	
    
    /**
     * ユーザーID検索
     * @param userId UserID
     * @return 検索結果
     */
    public List<UserRole> findByUserId(Long userId) {
        return sqlSession.selectList("com.tachitomo.eduproj.repository.UserRoleMapper.findByUserId", userId);
    }
    
    /**
     * 所有権限情報登録
     * @param userRoleRequest 登録用リクエストデータ
     */
    public void insert(UserRoleAddRequest userRoleRequest) {
    	int insertCount = sqlSession.insert("com.tachitomo.eduproj.repository.UserRoleMapper.insert", userRoleRequest);
        if (insertCount == 0) {
            throw new OptimisticLockingFailureException("楽観ロックエラー");
        }       	
    }   
    
    /**
     * 所有権限情報更新
     * @param userRoleUpdateRequest 更新用リクエストデータ
     */
    public void update(UserRoleUpdateRequest userRoleUpdateRequest) {
    	int updateCount = sqlSession.update("com.tachitomo.eduproj.repository.UserRoleMapper.update", userRoleUpdateRequest);
        if (updateCount == 0) {
            throw new OptimisticLockingFailureException("楽観ロックエラー");
        }
    }    
    
    /**
     * 所有権限情報の削除
     * @param id ID
     */
    public void delete(Long id) {
    	int deleteCount =  sqlSession.delete("com.tachitomo.eduproj.repository.UserRoleMapper.delete", id);
        if (deleteCount == 0) {
            throw new OptimisticLockingFailureException("楽観ロックエラー");
        }    	
    }      
}
