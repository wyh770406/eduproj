
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

import com.tachitomo.eduproj.dto.ProcessRoleAddRequest;
import com.tachitomo.eduproj.dto.ProcessRoleUpdateRequest;
import com.tachitomo.eduproj.entity.ProcessRole;
import com.tachitomo.eduproj.repository.ProcessRoleMapper;

@Repository
public class ProcessRoleRepository implements ProcessRoleMapper {

    @Autowired
    private SqlSession sqlSession;
       
    /**
     * 必要権限情報全件検索
     * @param なし
     * @return 検索結果
     */
    public List<ProcessRole> findAll(){
    	return sqlSession.selectList("com.tachitomo.eduproj.repository.ProcessRoleMapper.findAll");
    }   
	
    /**
     * 主キー検索
     * @param id ID
     * @return エンティティ
     */
    public ProcessRole findById(Long id) {
        return sqlSession.selectOne("com.tachitomo.eduproj.repository.ProcessRoleMapper.findById", id);
    }	
    
    /**
     * ユーザーID検索
     * @param userId UserID
     * @return 検索結果
     */
    public List<ProcessRole> findByUserId(Long userId) {
        return sqlSession.selectList("com.tachitomo.eduproj.repository.ProcessRoleMapper.findByUserId", userId);
    }
        
    
    /**
     * 必要権限情報登録
     * @param userRoleRequest 登録用リクエストデータ
     */
    public void insert(ProcessRoleAddRequest processRoleRequest) {
    	int insertCount = sqlSession.insert("com.tachitomo.eduproj.repository.ProcessRoleMapper.insert", processRoleRequest);
        if (insertCount == 0) {
            throw new OptimisticLockingFailureException("楽観ロックエラー");
        }       	
    }   
    
    /**
     * 必要権限情報更新
     * @param processRoleUpdateRequest 更新用リクエストデータ
     */
    public void update(ProcessRoleUpdateRequest processRoleUpdateRequest) {
    	int updateCount = sqlSession.update("com.tachitomo.eduproj.repository.ProcessRoleMapper.update", processRoleUpdateRequest);
        if (updateCount == 0) {
            throw new OptimisticLockingFailureException("楽観ロックエラー");
        }
    }    
    
    /**
     * 必要権限情報の削除
     * @param id ID
     */
    public void delete(Long id) {
    	int deleteCount =  sqlSession.delete("com.tachitomo.eduproj.repository.ProcessRoleMapper.delete", id);
        if (deleteCount == 0) {
            throw new OptimisticLockingFailureException("楽観ロックエラー");
        }    	
    }      
}
