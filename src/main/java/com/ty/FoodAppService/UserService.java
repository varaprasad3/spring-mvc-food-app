package com.ty.FoodAppService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.FoodAppDao.UserDao;
import com.ty.FoodAppDto.User;

@Component
public class UserService {
	@Autowired
    UserDao dao ;
	public User saveUser(User user) {
		return dao.saveUser(user) ;
	}
	public List<User> getUserAndEmaiLAndPassword(String email , String password) {
		return dao.getUserByEmailAndPassword(email, password) ;	
	}
	public void updateUser(User user ) {
		dao.updateUser(user);
	}
}
