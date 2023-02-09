
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

import com.tachitomo.eduproj.dto.OperationHistoryAddRequest;
import com.tachitomo.eduproj.dto.OperationHistoryUpdateRequest;
import com.tachitomo.eduproj.entity.OperationHistory;
import com.tachitomo.eduproj.repository.OperationHistoryMapper;

@Repository
public class OperationHistoryRepository implements OperationHistoryMapper {

    @Autowired
    private SqlSession sqlSession;
       
    /**
     * 操作履歴情報全件検索
     * @param なし
     * @return 検索結果
     */
    public List<OperationHistory> findAll(){
    	return sqlSession.selectList("com.tachitomo.eduproj.repository.OperationHistoryMapper.findAll");
    }   
	
    /**
     * 主キー検索
     * @param id ID
     * @return エンティティ
     */
    public OperationHistory findById(Long id) {
        return sqlSession.selectOne("com.tachitomo.eduproj.repository.OperationHistoryMapper.findById", id);
    }	
    
    /**
     * 操作履歴情報登録
     * @param operationHistoryRequest 登録用リクエストデータ
     */
    public void insert(OperationHistoryAddRequest operationHistoryRequest) {
    	int insertCount = sqlSession.insert("com.tachitomo.eduproj.repository.OperationHistoryMapper.insert", operationHistoryRequest);
        if (insertCount == 0) {
            throw new OptimisticLockingFailureException("楽観ロックエラー");
        }       	
    }   
    
    /**
     * 操作履歴情報更新
     * @param operationHistoryUpdateRequest 更新用リクエストデータ
     */
    public void update(OperationHistoryUpdateRequest operationHistoryUpdateRequest) {
    	int updateCount = sqlSession.update("com.tachitomo.eduproj.repository.OperationHistoryMapper.update", operationHistoryUpdateRequest);
        if (updateCount == 0) {
            throw new OptimisticLockingFailureException("楽観ロックエラー");
        }
    }    
    
    /**
     * 操作履歴情報の削除
     * @param id ID
     */
    public void delete(Long id) {
    	int deleteCount =  sqlSession.delete("com.tachitomo.eduproj.repository.OperationHistoryMapper.delete", id);
        if (deleteCount == 0) {
            throw new OptimisticLockingFailureException("楽観ロックエラー");
        }    	
    }      
}
