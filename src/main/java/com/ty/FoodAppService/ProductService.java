package com.ty.FoodAppService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.FoodAppDao.ProductDao;
import com.ty.FoodAppDto.Product;

@Component
public class ProductService {
	@Autowired
     ProductDao dao ;
	public Product saveProduct(Product product) {
		return dao.saveProduct(product) ;
	}
	public List<Product> getAllProducts() {
		return dao.getAllProducts() ;
	}
	public Product getProductById(int id) {
		return dao.getProductById(id) ;
	}
	public Product updateProduct(Product product) {
		return dao.updateProduct(product) ;
	}
	public Product deleteProductById(int id) {
		return dao.deleteProductById(id) ;
	}
}
