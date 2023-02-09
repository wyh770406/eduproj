
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

import com.tachitomo.eduproj.dto.RoleAddRequest;
import com.tachitomo.eduproj.dto.RoleUpdateRequest;
import com.tachitomo.eduproj.entity.Role;
import com.tachitomo.eduproj.repository.RoleMapper;

@Repository
public class RoleRepository implements RoleMapper {

    @Autowired
    private SqlSession sqlSession;
       
    /**
     * 権限情報全件検索
     * @param なし
     * @return 検索結果
     */
    public List<Role> findAll(){
    	return sqlSession.selectList("com.tachitomo.eduproj.repository.RoleMapper.findAll");
    }   
	
    /**
     * 主キー検索
     * @param id ID
     * @return エンティティ
     */
    public Role findById(Long id) {
        return sqlSession.selectOne("com.tachitomo.eduproj.repository.RoleMapper.findById", id);
    }	
    
    /**
     * 権限情報登録
     * @param roleRequest 登録用リクエストデータ
     */
    public void insert(RoleAddRequest roleRequest) {
    	int insertCount = sqlSession.insert("com.tachitomo.eduproj.repository.RoleMapper.insert", roleRequest);
        if (insertCount == 0) {
            throw new OptimisticLockingFailureException("楽観ロックエラー");
        }       	
    }   
    
    /**
     * 権限情報更新
     * @param roleUpdateRequest 更新用リクエストデータ
     */
    public void update(RoleUpdateRequest roleUpdateRequest) {
    	int updateCount = sqlSession.update("com.tachitomo.eduproj.repository.UserMapper.update", roleUpdateRequest);
        if (updateCount == 0) {
            throw new OptimisticLockingFailureException("楽観ロックエラー");
        }
    }    
    
    /**
     * 権限情報の削除
     * @param id ID
     */
    public void delete(Long id) {
    	int deleteCount =  sqlSession.delete("com.tachitomo.eduproj.repository.RoleMapper.delete", id);
        if (deleteCount == 0) {
            throw new OptimisticLockingFailureException("楽観ロックエラー");
        }    	
    }      
}
