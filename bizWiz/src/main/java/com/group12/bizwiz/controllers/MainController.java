package com.group12.bizwiz.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.group12.bizwiz.services.UserService;
import com.group12.bizwiz.services.ProductService;
import com.group12.bizwiz.services.CustomerService;
import com.group12.bizwiz.services.InvoiceService;
import com.group12.bizwiz.models.LoginUser;
import com.group12.bizwiz.models.User;
import com.group12.bizwiz.models.Product;
import com.group12.bizwiz.models.Customer;
import com.group12.bizwiz.models.Invoice;

@Controller
public class MainController {
	@Autowired
	private UserService uServ;
	@Autowired
	private ProductService pServ;
	@Autowired
	private CustomerService cServ;
	@Autowired
	private InvoiceService iServ;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/bizwiz";
	}
	
	//LOGIN PAGE
	@GetMapping("/bizwiz")
	public String login(
			@ModelAttribute("newUserView") User user, 
			@ModelAttribute("newLoginView") LoginUser loginUser){
		return "login.jsp";
	}
	//LOGIN
	@PostMapping("/bizwiz/login") 
	public String login(@Valid @ModelAttribute("newLoginView") LoginUser loginUser, 
			BindingResult result, HttpSession session, 
			@ModelAttribute("newUserView")User user) {
	 //authenticate user
			uServ.authenticateUser(loginUser, result);
			if(result.hasErrors()) {
				return "login.jsp";
			}
		User loggedInUser= uServ.findByEmail(loginUser.getEmail());
		
		session.setAttribute("loggedInUser", loggedInUser);
		return "redirect:/bizwiz/invoices";

	}
	//REGISTER
	@PostMapping("/bizwiz/register")
	public String register(@Valid @ModelAttribute("newUserView") User user, 
		BindingResult result, 
		HttpSession session, 
		@ModelAttribute("newLoginView") LoginUser loginUser) {
 //validate user
		uServ.validate(user, result);
		if(result.hasErrors()) {
			return "login.jsp";
		}
 //register user
		uServ.registerUser(user, result);
 
 //put user in session
		session.setAttribute("loggedInUser", user);
		return "redirect:/bizwiz/invoices";
	}
	
	//LOGOUT
	@GetMapping("/bizwiz/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
///CUSTOMER CUSTOMER CUSTOMER CUSTOMER CUSTOMER CUSTOMER CUSTOMER CUSTOMER CUSTOMER CUSTOMER CUSTOMER CUSTOMER CUSTOMER CUSTOMER 
	//SEE ALL CUSTOMERS DASHBOARD
	@GetMapping("/bizwiz/customers")
	public String allCustomers(HttpSession session, Model model) {
		if(session.getAttribute("loggedInUser")!=null) {
			User user=(User)session.getAttribute("loggedInUser");
			User thisUser = uServ.findById(user.getId());
			model.addAttribute("allCustomersView", cServ.allCustomers());
			model.addAttribute("thisUserView",thisUser);
			return "allcustomers.jsp";
		} else {
			return "redirect:/";
		}
		
	}
	//ADD CUSTOMER
	@GetMapping("/bizwiz/customers/add")
	public String newCustomer(HttpSession session, @ModelAttribute("newCustomerView") Customer c) {
		if(session.getAttribute("loggedInUser")!=null) {
			return "newcustomer.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	@PostMapping("/bizwiz/customers/add")
	public String addCustomer(@Valid @ModelAttribute("newCustomerView") Customer c, BindingResult result) {
		if(result.hasErrors()) {
			return "newcustomer.jsp";
		} else {
			cServ.addCustomer(c);
			return "redirect:/bizwiz/customers";
		}
	}
	//GET ONE CUSTOMER
	@GetMapping("/bizwiz/customers/{id}")
	public String customerDetail(@PathVariable Long id, Model model, HttpSession session) {
		if(session.getAttribute("loggedInUser")!=null) {
			model.addAttribute("user", uServ.findById(id));
			Customer c = cServ.findCustomerById(id);
				model.addAttribute("oneCustomerView", c);
			return "onecustomer.jsp";
		} else {
			return "redirect:/";
		}
	}
	//EDIT CUSTOMER
	@GetMapping("/bizwiz/customers/{id}/edit")
	public String editCustomer(@PathVariable Long id, Model model, HttpSession session) {
		if(session.getAttribute("loggedInUser")!=null) {
			Customer c = cServ.findCustomerById(id);
			model.addAttribute("oneCustomerView", c);
			return "editcustomer.jsp";
		} else {
			return "redirect:/bizwiz/customers";
		}
	}
	@PutMapping("/bizwiz/customers/{id}/edit")
	public String upadteCustomer(@Valid @ModelAttribute("oneBlogView")Customer c, BindingResult result) {
		if(result.hasErrors()) {
			return "editcustomer.jsp";
		} else {
			cServ.updateCustomer(c);
			return "redirect:/bizwiz/customers";
		}
	}
	
	//DELETE CUSTOMER
	@DeleteMapping("/bizwiz/customers/{id}/delete")
	public String deleteCustomer(@PathVariable("id") Long id) {	
			cServ.deleteCustomer(id);
			return "redirect:/bizwiz/customers";
	}
	
	

	
//PRODUCTS AND SERVICES PRODUCTS AND SERVICES PRODUCTS AND SERVICES PRODUCTS AND SERVICES PRODUCTS AND SERVICES 
	//SEE ALL PRODUCTS DASHBOARD
		@GetMapping("/bizwiz/products")
		public String allProducts(HttpSession session, Model model) {
			if(session.getAttribute("loggedInUser")!=null) {
				User user=(User)session.getAttribute("loggedInUser");
				User thisUser = uServ.findById(user.getId());
				model.addAttribute("allProductsView", pServ.allProducts());
				model.addAttribute("thisUserView",thisUser);
				return "allproducts.jsp";
			} else {
				return "redirect:/";
			}
			
		}
		//ADD PRODUCT
		@GetMapping("/bizwiz/products/add")
		public String newProduct(HttpSession session, @ModelAttribute("newProductView") Product p) {
			if(session.getAttribute("loggedInUser")!=null) {
				return "newproduct.jsp";
			}
			else {
				return "redirect:/";
			}
		}
		@PostMapping("/bizwiz/products/add")
		public String addProduct(@Valid @ModelAttribute("newProductView") Product p, BindingResult result) {
			if(result.hasErrors()) {
				return "newproduct.jsp";
			} else {
				pServ.addProduct(p);
				return "redirect:/bizwiz/products";
			}
		}
		//GET ONE PRODUCT
		@GetMapping("/bizwiz/products/{id}")
		public String productDetail(@PathVariable Long id, Model model, HttpSession session) {
			if(session.getAttribute("loggedInUser")!=null) {
				model.addAttribute("user", uServ.findById(id));
				Product p = pServ.findProductById(id);
					model.addAttribute("oneProductView", p);
				return "oneproduct.jsp";
			} else {
				return "redirect:/";
			}
		}
		//EDIT PRODUCT
		@GetMapping("/bizwiz/products/{id}/edit")
		public String editProduct(@PathVariable Long id, Model model, HttpSession session) {
			if(session.getAttribute("loggedInUser")!=null) {
				Product p = pServ.findProductById(id);
				model.addAttribute("oneProductView", p);
				return "editproduct.jsp";
			} else {
				return "redirect:/bizwiz/products";
			}
		}
		@PutMapping("/bizwiz/products/{id}/edit")
		public String upadteProduct(@Valid @ModelAttribute("oneBlogView")Product p, BindingResult result) {
			if(result.hasErrors()) {
				return "editproduct.jsp";
			} else {
				pServ.updateProduct(p);
				return "redirect:/bizwiz/products";
			}
		}
		
		//DELETE PRODUCT
		@DeleteMapping("/bizwiz/products/{id}/delete")
		public String deleteProduct(@PathVariable("id") Long id) {	
				pServ.deleteProduct(id);
				return "redirect:/bizwiz/products";
		}
	
//INVOICES INVOICES INVOICES INVOICES INVOICES INVOICES INVOICES INVOICES INVOICES INVOICES INVOICES INVOICES INVOICES INVOICES INVOICES 
		//SEE ALL INVOICES DASHBOARD
			@GetMapping("/bizwiz/invoices")
			public String allInvoices(HttpSession session, Model model) {
				if(session.getAttribute("loggedInUser")!=null) {
					User user=(User)session.getAttribute("loggedInUser");
					User thisUser = uServ.findById(user.getId());
					model.addAttribute("allInvoicesView", iServ.allInvoices());
					model.addAttribute("thisUserView",thisUser);
					return "dashboard.jsp";
				} else {
					return "redirect:/";
				}
				
			}
			//ADD INVOICE
			@GetMapping("/bizwiz/invoices/add")
			public String newInvoice(HttpSession session, Model model, @ModelAttribute("newInvoiceView") Invoice i) {
				if(session.getAttribute("loggedInUser")!=null) {
					model.addAttribute("customerSelectView", cServ.allCustomers());
					return "newinvoice1.jsp";
				}
				else {
					return "redirect:/";
				}
			}
			@PostMapping("/bizwiz/invoices/add")
			public String addInvoice(@Valid @ModelAttribute("newInvoiceView") Invoice i, BindingResult result) {
				if(result.hasErrors()) {
					return "newinvoice1.jsp";
				} else {
					iServ.addInvoice(i);
					return "redirect:/bizwiz/invoices/{id}";
				}
			}
			//GET ONE INVOICE
			@GetMapping("/bizwiz/invoices/{id}")
			public String invoiceDetail(@PathVariable Long id, Model model, HttpSession session) {
				if(session.getAttribute("loggedInUser")!=null) {
					model.addAttribute("user", uServ.findById(id));
					Invoice i = iServ.findInvoiceById(id);
					model.addAttribute("oneInvoiceView", i);
					return "oneinvoice.jsp";
				} else {
					return "redirect:/";
				}
			}
			//EDIT INVOICE
			@GetMapping("/bizwiz/invoices/{id}/edit")
			public String editInvoice(@PathVariable Long id, Model model, HttpSession session) {
				if(session.getAttribute("loggedInUser")!=null) {
					Invoice i = iServ.findInvoiceById(id);
					model.addAttribute("oneInvoiceView", i);
					return "editinvoice.jsp";
				} else {
					return "redirect:/bizwiz/invoices";
				}
			}
			@PutMapping("/bizwiz/invoices/{id}/edit")
			public String upadteInvoice(@Valid @ModelAttribute("oneBlogView")Invoice i, BindingResult result) {
				if(result.hasErrors()) {
					return "editinvoice.jsp";
				} else {
					iServ.updateInvoice(i);
					return "redirect:/bizwiz/invoices";
				}
			}
			
			//DELETE INVOICE
			@DeleteMapping("/bizwiz/invoices/{id}/delete")
			public String deleteInvoice(@PathVariable("id") Long id) {	
					iServ.deleteInvoice(id);
					return "redirect:/bizwiz/invoices";
			}
		
	
}