//package edu.mum.coffee.service;
//
//
//import java.security.Principal;
//import java.util.List;
//
//
//import javax.validation.Valid;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//import org.springframework.ui.Model;
//
//import org.springframework.validation.BindingResult;
//
//import org.springframework.web.bind.annotation.GetMapping;
//
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//import org.springframework.web.bind.annotation.PostMapping;
//
//import org.springframework.web.bind.annotation.RequestMethod;
//
//
//import edu.mum.coffee.domain.Person;
//
//import edu.mum.coffee.domain.Product;
//
//import edu.mum.coffee.service.OrderService;
//
//import edu.mum.coffee.service.PersonService;
//
//import edu.mum.coffee.service.ProductService;
//
//
//@Controller
//public class HomeController {
//	
//	
//@Autowired
//	private ProductService products;
//	
//	
//@Autowired
//	private PersonService personService;
//	
//	
//@Autowired
//	private OrderService orderService;
//	
//	
////***************product mapping*******************//
//
//	@GetMapping("/products/list")
//	public String getAllProducts(Model model) {
//		model.addAttribute("products",products.getAllProduct());	
//		return "productList";
//	}
//	@GetMapping("/products/manage")
//	public String ManageProducts() {		
//		return "productManagement";
//	}
//	
//	@GetMapping("/product/create")
//	public String createProduct(Product product,Model model ) {	
//		model.addAttribute("product", product);
//		return "productAdd";
//	}
//	
//	@PostMapping("/product/create")
//	public String addProduct(@Valid Product product,BindingResult result) {
//		
//		String view = "productAddSuccess";
//		if (!result.hasErrors()) {
//		
//			products.save(product);
//		}else {
//			view ="productAdd";
//		}
//		
//		return view;	
//		}
//	
//	@GetMapping("/product/remove")
//	public String removeProduct() {	
//		
//		return "productRemove";
//	}
//	
//	@PostMapping("/product/remove")
//	public String DeleteProduct(int id,
// Model model) {        
//		
//Product product=products.getProduct(id);
//		
//model.addAttribute("product",product);
//		 
//products.delete(product);
//		
//return "removalSucess";
//	}
//	
//		
////***********Customer Mapping*******************//
//	
//	@GetMapping("/customers/manage")
//	public String manageCustomers(Product product) {	
//		
//		return "customerManagement";
//	}
//	
//	@GetMapping("/customer/profile")
//	public String customerProfile(Product product) {	
//		
//		return "customerProfileAdd";
//	}
//	
//	@PostMapping("/customer/add/profile")
//	public String AddCustomer(Person person,Model model) {			
//		personService.savePerson(person);
//		model.addAttribute("person", person);
//		return "customerAddSuccess";
//	}	
//	
//	@GetMapping("/customers/list")
//	public String customersList() {	
//		
//		return "customersList";
//	}
//	
//	
//	@PostMapping("/cutomers/list")
//	public String getcustomerByEmail(String email,Model model) {	
//		model.addAttribute("cust",personService.findByEmail(email));
//		return "customerData";
//	}
//		
//	//**************** order mapping*********************//
//	
//
//	@GetMapping("/orders/manage")
//	public String  orderManagement(){
//		
//		return "orderManagement";
//	}
//	
//	
//	@GetMapping("/orders/list")
//	public String  ordersList(Model model){
//		
//model.addAttribute("orders",orderService.findAll());
//		
//		return "ordersList";
//	}
//	
//	//************************************************************************//
//	
//	@GetMapping({"/secure"})
//	public String securePage() {
//		return "secure";
//	}
//	
//
//	
//	
//	@GetMapping({"/admin"})
//	public String adminPage() {
//		return "admin";
//	}
//	
//	@GetMapping({"/order"})
//	public String placeOrder(Model model) {
//		
//		return "order";
//	}
//	
//	//********************user profile*************************//
//	
//	@GetMapping({"/user"})
//	public String userPage() {
//		return "user";
//	}
//	
//	@PostMapping("/user")
//	public String backToUser(){		
//		return "redirect:/user";
//	}
//	
//	@GetMapping("/user/profile")
//	public String profile(Principal principal, Model model) {
//		String userEmail=principal.getName();
//		List<Person> persons=personService.findByEmail(userEmail);
//		Person user=null;
//		for(Person person:persons){
//			if(person.getEmail().equals(userEmail)){
//		         user=person;
//		         break;
//			}
//		}
//		
//    model.addAttribute("person",user);
//		
//		
//		return "profile";
//	}
//	
//	
//	
//	@GetMapping("/user/profile/update")
//	public String updateUserProfie(){
//		
//		
//		return "updateUserProfile";
//	}
//	
//	@PostMapping("/user/profile/update")
//	public String UpdatePersonProfile(Person person, @ModelAttribute("userData") Person user){
//		
//		person.setEmail(user.getEmail());
//		person.setEnable(true);
//		
//		personService.removePerson(user);
//		personService.savePerson(person);		
//		return "successUpdateProfile";
//	}
//	
//	@ModelAttribute("userData")
//	public Person userData(Principal principal){
//		
//		String userEmail=principal.getName();
//		List<Person> persons=personService.findByEmail(userEmail);
//		Person user=null;
//		for(Person person:persons){
//			if(person.getEmail().equals(userEmail)){
//		         user=person;
//		         break;
//			}
//		}
//		
//		return user;
//	}
//	
//	
//}
