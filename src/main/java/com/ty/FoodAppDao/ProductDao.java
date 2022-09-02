package com.ty.FoodAppDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.FoodAppDto.Product;
@Component
public class ProductDao {
	@Autowired
	EntityManagerFactory entityManagerFactory ;
    public Product saveProduct(Product product) {
    	EntityManager entityManager = entityManagerFactory.createEntityManager() ;
    	EntityTransaction entityTransaction = entityManager.getTransaction() ;
         	
        entityTransaction.begin();
        entityManager.persist(product);
        entityTransaction.commit();
        
        return product ;
    }
    
    public List<Product> getAllProducts() {
    	EntityManager entityManager = entityManagerFactory.createEntityManager() ;
    	Query query = entityManager.createQuery("select c from Product c", Product.class) ;
    	return query.getResultList() ;
    }
    public Product getProductById(int id) {
    	EntityManager entityManager = entityManagerFactory.createEntityManager() ;
    	return entityManager.find(Product.class, id) ;
    }
    public Product updateProduct(Product product) {
    	EntityManager entityManager = entityManagerFactory.createEntityManager() ;
    	EntityTransaction entityTransaction = entityManager.getTransaction() ;
         	
        entityTransaction.begin();
        entityManager.merge(product);
        entityTransaction.commit();
        
        return product ;
    }
    public Product deleteProductById(int id) {
    	EntityManager entityManager = entityManagerFactory.createEntityManager() ;
    	EntityTransaction entityTransaction = entityManager.getTransaction() ;
    	Product product = entityManager.find(Product.class, id) ;
    	entityTransaction.begin();
    	entityManager.remove(product);
    	entityTransaction.commit();
    	return product ;
    }
}
