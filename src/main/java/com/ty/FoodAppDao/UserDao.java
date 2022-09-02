package com.ty.FoodAppDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.FoodAppDto.Product;
import com.ty.FoodAppDto.User;

@Component
public class UserDao {
	@Autowired
	EntityManagerFactory entityManagerFactory ;
    public User saveUser(User user) {
    	EntityManager entityManager = entityManagerFactory.createEntityManager() ;
    	EntityTransaction entityTransaction = entityManager.getTransaction() ;
         	
        entityTransaction.begin();
        entityManager.persist(user);
        entityTransaction.commit();
        
        return user ;
    }
    
    public List<User> getUserByEmailAndPassword(String email, String password) {
    	EntityManager entityManager = entityManagerFactory.createEntityManager() ;
    	Query query = entityManager.createQuery("select c from User c where c.email=?1 and c.password=?2") ;
    	query.setParameter(1, email) ;
    	query.setParameter(2, password) ;
    	return query.getResultList() ;
    }
    
    public List<User> getAllUsers() {
    	EntityManager entityManager = entityManagerFactory.createEntityManager() ;
    	Query query = entityManager.createQuery("select c from User c", User.class) ;
    	return query.getResultList() ;
    }
    public void updateUser(User user) {
    	EntityManager entityManager = entityManagerFactory.createEntityManager() ;
    	EntityTransaction entityTransaction = entityManager.getTransaction() ;
         	
        entityTransaction.begin();
        entityManager.merge(user);
        entityTransaction.commit();
        
        
    }
}
