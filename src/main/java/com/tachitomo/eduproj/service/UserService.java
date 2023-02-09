/**
 * @author Go
 * 2022/11/25
 */
package com.tachitomo.eduproj.service;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tachitomo.eduproj.dao.UserRepository;
import com.tachitomo.eduproj.dto.UserAddRequest;
import com.tachitomo.eduproj.dto.UserSearchRequest;
import com.tachitomo.eduproj.dto.UserUpdateRequest;
import com.tachitomo.eduproj.entity.User;
/**
 * ユーザー情報 Service
 */
@Service
public class UserService {
    /**
     * ユーザー情報 Mapper
     */
    @Autowired
    private UserRepository userMapper;
    
    /**
     * ユーザー情報全件検索
     * @return 検索結果
     */
    public List<User> findAll() {
        return userMapper.findAll();
    }
    
    /**
     * ユーザー情報主キー検索
     * @return 検索結果
     */
    public User findById(Long id) {
        return userMapper.findById(id);
    }
    
    
    /**
     * ユーザー情報検索
　　　* @param userSearchRequest リクエストデータ
     * @return 検索結果
     */
    public List<User> search(UserSearchRequest userSearchRequest) {
        return userMapper.search(userSearchRequest);
    }
    
    /**
     * ユーザ情報登録
     * @param userAddRequest リクエストデータ
     */
    @Transactional
    public void save(UserAddRequest userAddRequest) {
        userMapper.save(userAddRequest);
    }
    /**
     * ユーザ情報更新
     * @param userEditRequest リクエストデータ
     */
    @Transactional
    public void update(UserUpdateRequest userUpdateRequest) {
        userMapper.update(userUpdateRequest);
    }
    /**
     * ユーザ情報更新
     * @param userEditRequest リクエストデータ
     */
    @Transactional
    public void updateAvailability(UserUpdateRequest userUpdateRequest) {
        userMapper.updateAvailability(userUpdateRequest);
    }
    /**
     * ユーザー情報削除
     * @param id
     */
    @Transactional
    public void delete(Long id) {
        userMapper.delete(id);
    }    
    
	public User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}  
	
	/**
	 * ユーザー権限の情報を取る
	 * @param id
	 * @return
	 */
	public User findByUserInfo(Long id) {
		return userMapper.findByUserInfo(id);
	} 
    
	public List<Object> authenticate(String username, String password){		
		User user = this.findByUsername(username);
		if(user == null){
			return Arrays.asList(false, null);
		}else{
			if(password.trim().equals(user.getPassword().trim())) return Arrays.asList(true, user);
			else return Arrays.asList(false, user);
		}
	}
	
	
	public void updAfterLogin(Long userId, boolean isLoginSucc, String strState, int nowSuccTimes, int nowErrTimes, int nowVerNumber) {
		Date sysDate = new Date();
		Timestamp nowTime = new Timestamp(sysDate.getTime());
		
		UserUpdateRequest userUpdObj = new UserUpdateRequest();		
		userUpdObj.setState(strState);


		if (isLoginSucc) {
			userUpdObj.setLoginSuccessTime(nowTime);	
			int updSuccTimes = nowSuccTimes+1;
			userUpdObj.setLoginSuccessTimes(updSuccTimes);
			
		}else {
			userUpdObj.setLoginFailureTime(nowTime);
			int updErrTimes = nowErrTimes+1;			
			userUpdObj.setLoginFailureTimes(updErrTimes);			
		}
		
		//userUpdObj.setUpdateTime(nowTime);
		userUpdObj.setUpdateUser(userId);	
		userUpdObj.setId(userId);
		int updVerNumber = nowVerNumber + 1;
		userUpdObj.setVersionNumber(updVerNumber);	
		this.update(userUpdObj);  		
	}
}
