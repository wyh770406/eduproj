package com.tachitomo.eduproj.controller;

/**
 * @author Go
 * createDate 2022/11/25
 * ログインコントローラークラス
 */



import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;


import com.tachitomo.eduproj.dto.BusinessErrorDto;
import com.tachitomo.eduproj.entity.User;
import com.tachitomo.eduproj.entity.UserRole;
import com.tachitomo.eduproj.service.OperationHistoryService;
import com.tachitomo.eduproj.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tachitomo.eduproj.dto.UserAddRequest;
import com.tachitomo.eduproj.dto.UserSearchRequest;
import com.tachitomo.eduproj.dto.UserUpdateRequest;
import com.tachitomo.eduproj.entity.User;
import com.tachitomo.eduproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
@Controller
public class UserController {

	/**
	 * ユーザー情報 Service
	 */
	@Autowired
	private UserService userService;

	/**
	 * ユーザー情報一覧画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping(value = "/user/list")
	public String displayList(Model model) {
		List<User> userList = userService.findAll();
		model.addAttribute("userlist", userList);
		model.addAttribute("userSearchRequest", new UserSearchRequest());
		return "user/search";
	}

	/**
	 * ユーザー新規登録画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping(value = "/user/add")
	public String displayAdd(Model model) {
		model.addAttribute("userAddRequest", new UserAddRequest());
		return "user/add";
	}

	/**
	 * ユーザー編集画面を表示
	 * @param id ユーザーID
	 * @param model Model
	 * @return ユーザー編集画面
	 */
	@GetMapping("/user/{id}/edit")
	public String displayEdit(@PathVariable Long id, Model model) {
		User user = userService.findById(id);
		UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
		userUpdateRequest.setId(user.getId());
		userUpdateRequest.setUsername(user.getUsername());
		userUpdateRequest.setPassword(user.getPassword());
		userUpdateRequest.setDisplayName(user.getDisplayName());
		model.addAttribute("userUpdateRequest", userUpdateRequest);
		return "user/edit";
	}

	/**
	 * ユーザー情報検索
	 * @param userSearchRequest リクエストデータ
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@RequestMapping(value = "/user/search", method = RequestMethod.POST)
	public String search(@ModelAttribute UserSearchRequest userSearchRequest, Model model) {
		List<User> userList = userService.search(userSearchRequest);
		model.addAttribute("userlist", userList);
		return "user/search";
	}

	/**
	 * ユーザー情報削除（論理削除）
	 * @param id ユーザーID
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping("/user/{id}/delete")
	public String delete(@PathVariable Long id, Model model) {
		// ユーザー情報の削除
		userService.delete(id);
		return "redirect:/user/list";
	}

	/**
	 * ユーザー新規登録
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String create(@Validated @ModelAttribute UserAddRequest userRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "user/add";
		}
		// ユーザー情報の登録
		userService.save(userRequest);
		return "redirect:/user/list";
	}

	/**
	 * ユーザー更新
	 * @param UserUpdateRequest リクエストデータ
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public String update(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "user/edit";
		}
		// ユーザー情報の更新
		userService.update(userUpdateRequest);
		return "redirect:/user/list";
	}
}
