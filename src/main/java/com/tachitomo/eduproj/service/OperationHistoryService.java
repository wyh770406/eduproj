/**
 * @author Go
 * 2022/11/25
 */
package com.tachitomo.eduproj.service;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tachitomo.eduproj.dao.OperationHistoryRepository;
import com.tachitomo.eduproj.dto.OperationHistoryAddRequest;
import com.tachitomo.eduproj.dto.OperationHistoryUpdateRequest;
import com.tachitomo.eduproj.entity.OperationHistory;
/**
 * 操作履歴情報 Service
 */
@Service
public class OperationHistoryService {
    /**
     * 操作履歴情報 Mapper
     */
    @Autowired
    private OperationHistoryRepository operationHistoryMapper;  
    
    /**
     * 操作履歴情報全件検索
     * @return 検索結果
     */
    public List<OperationHistory> findAll() {
        return operationHistoryMapper.findAll();
    }
    
    /**
     * 操作履歴情報主キー検索
     * @param id
     * @return 検索結果
     */
    public OperationHistory findById(Long id) {
        return operationHistoryMapper.findById(id);
    }
       
    /**
     * 操作履歴情報登録
     * @param operhisAddRequest リクエストデータ
     */
    @Transactional
    public void insert(OperationHistoryAddRequest operhisAddRequest) {
    	operationHistoryMapper.insert(operhisAddRequest);
    }
    /**
     * 操作履歴情報更新
     * @param operhisUpdateRequest リクエストデータ
     */
    @Transactional
    public void update(OperationHistoryUpdateRequest operhisUpdateRequest) {
    	operationHistoryMapper.update(operhisUpdateRequest);
    }
    /**
     * 操作履歴情報削除
     * @param id
     */
    @Transactional
    public void delete(Long id) {
    	operationHistoryMapper.delete(id);
    }    
    
    @Transactional
    public void loginOperHistory(Long userId, String username, String strReason, String strTarget, String strMessage){
		OperationHistoryAddRequest operHisInsertObj = new OperationHistoryAddRequest();

		Date sysDate = new Date();
		Timestamp nowTime = new Timestamp(sysDate.getTime());
		operHisInsertObj.setOperationTime(nowTime);
		operHisInsertObj.setCreateTime(nowTime);
		operHisInsertObj.setUpdateTime(nowTime);	
		operHisInsertObj.setCreateUser(userId);
		operHisInsertObj.setUpdateUser(userId);		
		operHisInsertObj.setUserId(userId);
		operHisInsertObj.setReason(strReason);		
		operHisInsertObj.setTargetKey(username);
		operHisInsertObj.setMessage(strMessage);		
		operHisInsertObj.setTarget(strTarget);        		
		this.insert(operHisInsertObj);    	
    }
         
}
