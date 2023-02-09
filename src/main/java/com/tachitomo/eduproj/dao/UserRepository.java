
/**
 * @author Go
 * 2022/11/25
 *
 */
package com.tachitomo.eduproj.dao;

import com.tachitomo.eduproj.dto.UserAddRequest;
import com.tachitomo.eduproj.dto.UserSearchRequest;
import com.tachitomo.eduproj.dto.UserUpdateRequest;
import com.tachitomo.eduproj.entity.User;
import com.tachitomo.eduproj.repository.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements UserMapper {

    @Autowired
    private SqlSession sqlSession;
    
    /**
     * ユーザー情報検索
     * @param user 検索用リクエストデータ
     * @return 検索結果
     */
    public List<User> search(UserSearchRequest user){
    	return sqlSession.selectList("com.tachitomo.eduproj.repository.UserMapper.search", user);    	
    }
    
    /**
     * ユーザー情報全件検索
     * @return 検索結果
     */
    public List<User> findAll(){
    	return sqlSession.selectList("com.tachitomo.eduproj.repository.UserMapper.findAll");
    }   
	
    /**
     * 主キー検索
     * @param id ID
     * @return エンティティ
     */
    public User findById(Long id) {
        return sqlSession.selectOne("com.tachitomo.eduproj.repository.UserMapper.findById", id);
    }	
    
    /**
     * ユーザー情報ユーザー名前検索
     * @param username
     * @return 検索結果
     */
    public User findByUsername(String username) {
    	return sqlSession.selectOne("com.tachitomo.eduproj.repository.UserMapper.findByUsername", username);
    }    
    
    /**
     * ユーザー情報登録
     * @param userRequest 登録用リクエストデータ
     */
    public void save(UserAddRequest userRequest) {
    	int insertCount = sqlSession.insert("com.tachitomo.eduproj.repository.UserMapper.save", userRequest);
        if (insertCount == 0) {
            throw new OptimisticLockingFailureException("楽観ロックエラー");
        }       	
    }   
    
    /**
     * ユーザー情報更新
     * @param userUpdateRequest 更新用リクエストデータ
     */
    public void update(UserUpdateRequest userUpdateRequest) {
    	int updateCount = sqlSession.update("com.tachitomo.eduproj.repository.UserMapper.update", userUpdateRequest);
        if (updateCount == 0) {
            throw new OptimisticLockingFailureException("楽観ロックエラー");
        }
    }
    
    /**
     * ユーザー情報更新
     * @param userUpdateRequest 更新用リクエストデータ
     */
    public void updateAvailability(UserUpdateRequest userUpdateRequest) {
    	int updateCount = sqlSession.update("com.tachitomo.eduproj.repository.UserMapper.updateAvailability", userUpdateRequest);
        if (updateCount == 0) {
            throw new OptimisticLockingFailureException("楽観ロックエラー");
        }
    }
    
    /**
     * ユーザー情報の削除
     * @param id ID
     */
    public void delete(Long id) {
    	int deleteCount =  sqlSession.delete("com.tachitomo.eduproj.repository.UserMapper.delete", id);
        if (deleteCount == 0) {
            throw new OptimisticLockingFailureException("楽観ロックエラー");
        }    	
    }     
    
    /**
     * ユーザー権限の情報を取る
     * @param id
     * @return
     */
	public User findByUserInfo(Long id) {
		return sqlSession.selectOne("com.tachitomo.eduproj.repository.UserMapper.findByUserInfo", id);
	}   
}
