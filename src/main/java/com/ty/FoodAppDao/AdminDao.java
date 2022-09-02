package com.ty.FoodAppDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.FoodAppDto.Admin;

@Component
public class AdminDao {
	@Autowired
	EntityManagerFactory entityManagerFactory ;
    public Admin saveAdmin(Admin admin) { 
    	EntityManager entityManager = entityManagerFactory.createEntityManager() ;
    	EntityTransaction entityTransaction = entityManager.getTransaction() ;
    	
    	entityTransaction.begin();
    	entityManager.persist(admin) ;
    	entityTransaction.commit();
    	return admin ;
    }
    public Admin getAdminById(int id) {
    	EntityManager entityManager = entityManagerFactory.createEntityManager() ;
    	
    	
    	return entityManager.find(Admin.class,id) ;
    }
}
