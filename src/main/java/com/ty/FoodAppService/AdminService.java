package com.ty.FoodAppService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.FoodAppDao.AdminDao;
import com.ty.FoodAppDto.Admin;

@Component
public class AdminService {
	@Autowired
	AdminDao adminDao ;
   public Admin saveAdmin(Admin admin) {
	  return adminDao.saveAdmin(admin);
   }
   public Admin getAdminById(int id) {
	  return adminDao.getAdminById(id) ;
   }
}
