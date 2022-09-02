package com.ty.FoodAppController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.FoodAppDto.Admin;
import com.ty.FoodAppDto.FoodOrder;
import com.ty.FoodAppDto.Item;
import com.ty.FoodAppDto.Product;
import com.ty.FoodAppDto.User;
import com.ty.FoodAppService.AdminService;
import com.ty.FoodAppService.ProductService;
import com.ty.FoodAppService.UserService;

@Controller
public class FoodController {
	@Autowired
	AdminService adminService;

	@Autowired
	UserService service;

	@Autowired
	ProductService productService;

	@RequestMapping("/addadmin")
	public ModelAndView addAdmin() {
		Admin admin = new Admin();
		ModelAndView andView = new ModelAndView("login.jsp");
		admin.setEmail("vp@gmail.com");
		admin.setPassword("vp123");
		adminService.saveAdmin(admin);
		return andView;
	}

	@RequestMapping("/adminfeatures")
	public ModelAndView adminFeature(@RequestParam("uname") String email, @RequestParam("psw") String password) {
		Admin admin = adminService.getAdminById(1);

		if (email.equalsIgnoreCase(admin.getEmail()) && password.equals(admin.getPassword())) {
			ModelAndView andView = new ModelAndView("admin.jsp");
			andView.addObject("msg", "login successfull");
			return andView;
		} else {
			ModelAndView andView = new ModelAndView("login.jsp");
			andView.addObject("msg", "get out from my motherland");
			return andView;
		}
	}

	@RequestMapping("/adduser")
	public ModelAndView addUser() {
		ModelAndView andView = new ModelAndView("addUser.jsp");
		User user = new User();
		andView.addObject("user", user);
		return andView;
	}

	@RequestMapping("/saveUser")
	public ModelAndView saveUser(@ModelAttribute User user) {
		ModelAndView andView = new ModelAndView("admin.jsp");
		service.saveUser(user);
		return andView;
	}

	@RequestMapping("/loginuser")
	public ModelAndView loginUser(@RequestParam String uname, @RequestParam String psw, HttpSession httpSession) {
		List<User> users = service.getUserAndEmaiLAndPassword(uname, psw);
		if (users.size() > 0) {
			User user = users.get(0);
			httpSession.setAttribute("user", user);
			ModelAndView andView = new ModelAndView("UserNavigation.jsp");
			return andView;
		} else {
			ModelAndView andView = new ModelAndView("loginuser.jsp");
			andView.addObject("msg", "enter proper credentials");
			return andView;
		}
	}

	@RequestMapping("/addproduct")
	public ModelAndView addProduct() {
		ModelAndView andView = new ModelAndView("addProduct.jsp");
		Product product = new Product();
		andView.addObject("product", product);
		return andView;
	}

	@RequestMapping("/saveProduct")
	public ModelAndView saveProduct(@ModelAttribute Product product) {
		ModelAndView andView = new ModelAndView("admin.jsp");
		productService.saveProduct(product);
		return andView;
	}

	@RequestMapping("/productslist")
	public ModelAndView getAllProducts() {
		ModelAndView andView = new ModelAndView("allproducts.jsp");
		List<Product> products = productService.getAllProducts();
		andView.addObject("products", products);
		return andView;
	}

	@RequestMapping("/editproduct")
	public ModelAndView editProduct(@RequestParam int id) {
		ModelAndView andView = new ModelAndView("updateproduct.jsp");
		Product product = productService.getProductById(id);
		andView.addObject("product", product);
		return andView;
	}

	@RequestMapping("/updateproduct")
	public ModelAndView updateProduct(@ModelAttribute Product product) {
		ModelAndView andView = new ModelAndView("admin.jsp");
		productService.updateProduct(product);
		return andView;
	}

	@RequestMapping("/deleteproduct")
	public ModelAndView deleteProduct(@RequestParam int id) {
		ModelAndView andView = new ModelAndView("admin.jsp");
		productService.deleteProductById(id);
		return andView;
	}

	@RequestMapping("/takefoodorder")
	public ModelAndView takefoodorder() {
		FoodOrder foodOrder = new FoodOrder();
		ModelAndView andView = new ModelAndView("foodOrder.jsp");
		andView.addObject("foodOrder", foodOrder);
		return andView;
	}

	@RequestMapping("/addfoodorder")
	public ModelAndView addFoodOrder(@ModelAttribute FoodOrder foodOrder, HttpSession httpSession) {
		httpSession.setAttribute("foodOrder", foodOrder);
		httpSession.setAttribute("list", new ArrayList<Item>());
		ModelAndView andView = new ModelAndView("/menu");
		return andView;
	}

	@RequestMapping("/menu")
	public ModelAndView menu() {
		List<Product> products = productService.getAllProducts();
		ModelAndView andView = new ModelAndView("menu.jsp");
		andView.addObject("products", products);
		return andView;
	}

	@RequestMapping("/additem")
	public ModelAndView additem(@RequestParam int id) {
//    	FoodOrder foodOrder = (FoodOrder)httpSession.getAttribute("foodOrder") ;
		Product product = productService.getProductById(id);
		Item item = new Item();
		item.setName(product.getName());
		item.setCost(product.getCost());
		ModelAndView andView = new ModelAndView("item.jsp");
		andView.addObject("item", item);
		return andView;
	}

	@RequestMapping("/putitem")
	public ModelAndView putitem(HttpSession httpSession, @ModelAttribute Item item) {

		item.setCost(item.getQuantity() * item.getCost());

		FoodOrder foodOrder = (FoodOrder) httpSession.getAttribute("foodOrder");

		item.setFoodOrder(foodOrder);
		List<Item> items = (ArrayList<Item>) httpSession.getAttribute("list");
		items.add(item);
		foodOrder.setItems(items);
		foodOrder.setCost(foodOrder.getCost() + item.getCost());
		ModelAndView andView = new ModelAndView("/menu");
		return andView;
	}

	@RequestMapping("/submitorder")
	public ModelAndView submitOrder(HttpSession httpSession) {
		FoodOrder foodOrder = (FoodOrder) httpSession.getAttribute("foodOrder");
		List<FoodOrder> foodOrders = new ArrayList<FoodOrder>();

		User user = (User) httpSession.getAttribute("user");
		foodOrder.setUser(user);
		foodOrders.add(foodOrder);
		user.setFoodOrders(foodOrders);

		ModelAndView andView = new ModelAndView("/itemslist");
		service.updateUser(user);
		return andView;
	}

	@RequestMapping("/itemslist")
	public ModelAndView items(HttpSession httpSession) {
		FoodOrder foodOrder = (FoodOrder) httpSession.getAttribute("foodOrder");
		List<Item> items = foodOrder.getItems();
		ModelAndView andView = new ModelAndView("item.jsp");
		andView.addObject("itemslist", items);
		return andView;
	}
}
