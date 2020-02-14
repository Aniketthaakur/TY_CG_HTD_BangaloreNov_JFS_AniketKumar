package com.capgemini.forestrymanagementsystemspring.controller;

//import java.util.Arrays;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestrymanagementsystemspring.dto.AdminResponce;
import com.capgemini.forestrymanagementsystemspring.dto.ClientResponse;
import com.capgemini.forestrymanagementsystemspring.dto.ContractorResponse;
import com.capgemini.forestrymanagementsystemspring.dto.HaulierResponse;
import com.capgemini.forestrymanagementsystemspring.dto.LandResponse;
import com.capgemini.forestrymanagementsystemspring.dto.OrderResponse;
import com.capgemini.forestrymanagementsystemspring.dto.ProductResponse;
import com.capgemini.forestrymanagementsystemspring.dto.UserAdmin;
import com.capgemini.forestrymanagementsystemspring.dto.UserClient;
import com.capgemini.forestrymanagementsystemspring.dto.UserContractor;
import com.capgemini.forestrymanagementsystemspring.dto.UserHaulier;
import com.capgemini.forestrymanagementsystemspring.dto.UserLand;
import com.capgemini.forestrymanagementsystemspring.dto.UserOrder;
import com.capgemini.forestrymanagementsystemspring.dto.UserProduct;
import com.capgemini.forestrymanagementsystemspring.service.AdminService;
import com.capgemini.forestrymanagementsystemspring.service.ClientService;
import com.capgemini.forestrymanagementsystemspring.service.LandService;
import com.capgemini.forestrymanagementsystemspring.service.SchedulerService;

@RestController
public class ForestryController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private LandService landService;

	@Autowired
	private SchedulerService schedulerService;

	// Admin operations...................................

	@PostMapping(path = "/loginadmin", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponce login(@RequestBody UserAdmin bean) {
		String adminBean = adminService.login(bean.getName(), bean.getPassword());
		AdminResponce responce = new AdminResponce();
		if (adminBean != null) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Employee found for the credentials");

		} else {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("Invalid credentials");
		}
		return responce;
	}

	@PostMapping(path = "/addclient", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponce addClient(@RequestBody UserClient bean) {
		AdminResponce responce = new AdminResponce();
		if (adminService.addClient(bean)) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Employee registered");
		} else {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("Email already Exits" + ".");
		}
		return responce;
	}

	@GetMapping(path = "/getproduct", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<UserProduct> getAllProduct() {
		ProductResponse responce = new ProductResponse();
		Set<UserProduct> beans = adminService.getAllProduct();
		if (beans.isEmpty()) {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("data not found  ");

		} else {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("data found ");
			responce.setBeans(beans);
		}
		return adminService.getAllProduct();
	}

//	@GetMapping(path = "/showcontracts", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Set<UserContractor> showContracts() {
//		AdminResponce responce = new AdminResponce();
//		Set<UserContractor> beans = adminService.showContracts();
//		if (beans.isEmpty()) {
//			responce.setStatusCode(401);
//			responce.setMessage("Failure");
//			responce.setDescription("data not found  ");
//		} else {
//			responce.setStatusCode(201);
//			responce.setMessage("Success");
//			responce.setDescription("data found ");
//		}
//		return adminService.showContracts();
//	}

	@DeleteMapping(path = "/delete/{id}")
	public AdminResponce deleteClient(@PathVariable("id") int customerId) {
		AdminResponce responce = new AdminResponce();

		adminService.deleteClient(customerId);
		responce.setStatusCode(201);
		responce.setMessage("Success");
		responce.setDescription("Employee Details Deleted");

		return responce;
	}

	// Client
	// Operations..............................................................

	@GetMapping(path = "/getclient", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<UserClient> getAllClient() {
		ClientResponse responce = new ClientResponse();
		Set<UserClient> beans = clientService.getAllClient();
		if (beans.isEmpty()) {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("data not found  ");
		} else {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("data found ");
			responce.setBeans(beans);
		}
		return clientService.getAllClient();
	}

	@PostMapping(path = "/update-contract", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContractorResponse updateContract(@RequestBody UserContractor contract) {
		ContractorResponse responce = new ContractorResponse();

		if (clientService.updateContract(contract,contract.getHaulierId())) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Password change ");
		} else {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("Password Not change ");
			
		}
		return responce;
	}

	@DeleteMapping(path = "/deletecontract/{id}")
	public AdminResponce deleteContract(@PathVariable("id") int haulierId) {
		AdminResponce responce = new AdminResponce();

		clientService.deleteContract(haulierId);
		responce.setStatusCode(201);
		responce.setMessage("Success");
		responce.setDescription("Employee Details Deleted");

		return responce;
	}
	
	@GetMapping(path = "/getcontract", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<UserClient> contractInformation() {
		ContractorResponse responce = new ContractorResponse();
		Set<UserContractor> beans = clientService.contractInformation();
		if (beans.isEmpty()) {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("data not found  ");
		} else {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("data found ");
			responce.setBeans(beans);
		}
		return clientService.getAllClient();
	}

	
	@PostMapping(path = "/addproduct", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponce addProduct(@RequestBody UserProduct bean) {
		AdminResponce responce = new AdminResponce();
		if (clientService.addProduct(bean)) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Employee registered");
		} else {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("Email already Exits" + ".");
		}
		return responce;
	}
	
	@DeleteMapping(path = "/deleteproduct/{id}")
	public AdminResponce deleteProduct(@PathVariable("id") int prouctId) {
		AdminResponce responce = new AdminResponce();

		clientService.deleteProduct(prouctId);
		responce.setStatusCode(201);
		responce.setMessage("Success");
		responce.setDescription("Employee Details Deleted");

		return responce;
	}

	@PostMapping(path = "/updateproduct", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContractorResponse updateProduct(@RequestBody UserProduct product) {
		ContractorResponse responce = new ContractorResponse();
		

		if (clientService.updateProduct(product.getProductName(),product.getProductId())) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Password change ");
		} else {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("Password Not change ");
			
		}
		return responce;
	}

	@GetMapping(path = "/getorder", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<UserClient> showOrder() {
		OrderResponse responce = new OrderResponse();
		Set<UserOrder> beans = clientService.showOrder();
		if (beans.isEmpty()) {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("data not found  ");
		} else {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("data found ");
			responce.setBeans(beans);
		}
		return clientService.getAllClient();
	}
	
	@PostMapping(path = "/clientlogin", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AdminResponce clientLogin(@RequestBody UserAdmin bean) {
		String adminBean = clientService.clientLogin(bean.getName(), bean.getPassword());
		AdminResponce responce = new AdminResponce();
		if (adminBean != null) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Employee found for the credentials");

		} else {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("Invalid credentials");
		}
		return responce;
	}

	// land operations
	
	
	@PostMapping(path = "/addLandRecord", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse addLandRecord(@RequestBody UserLand bean) {
		LandResponse responce = new LandResponse();
		if (landService.addLandRecord(bean)) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Employee registered");
		} else {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("Email already Exits" + ".");
		}
		return responce;
	}
	
	@PutMapping(path = "/modifypayment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse paymentStatus(@RequestBody UserLand land) {
		LandResponse response = new LandResponse();
	
		if (landService.paymentStatus(land.getParcelPaymentSlip(), land.getParcelID())) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Payment Status updated");
	
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product not found");
		}
		return response;
	}

	@PutMapping(path = "/updatePaymentDescription", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse updatePaymentDescription(@RequestBody UserLand land) {
		LandResponse response = new LandResponse();
	
		if (landService.updatePaymentDescription(land.getPaymentDescription(), land.getParcelID())) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Payment Status updated");
	
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product not found");
		}
		return response;
	}
	@GetMapping(path = "/getall-land-details", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<UserClient> getAllLandDetails() {
		LandResponse responce = new LandResponse();
		Set<UserLand> beans = landService.getAllLandDetails();
		if (beans.isEmpty()) {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("data not found  ");
		} else {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("data found ");
			responce.setBeans(beans);
		}
		return clientService.getAllClient();
	}
// scheduler operations....

	@PostMapping(path = "/addorder", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OrderResponse addOrder(@RequestBody UserOrder bean) {
		OrderResponse responce = new OrderResponse();
		if (schedulerService.addOrder(bean)) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Employee registered");
		} else {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("Email already Exits" + ".");
		}
		return responce;
	}
	@PostMapping(path = "/addhaulier", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HaulierResponse addHaulier(@RequestBody UserHaulier bean) {
		HaulierResponse responce = new HaulierResponse();
		if (schedulerService.addHaulier(bean)) {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("Employee registered");
		} else {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("Email already Exits" + ".");
		}
		return responce;
	}

	@GetMapping(path = "/getAllHaulier", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<UserHaulier> getAllHaulier() {
		HaulierResponse responce = new HaulierResponse();
		Set<UserHaulier> beans = schedulerService.getAllHaulier();
		if (beans.isEmpty()) {
			responce.setStatusCode(401);
			responce.setMessage("Failure");
			responce.setDescription("data not found  ");
		} else {
			responce.setStatusCode(201);
			responce.setMessage("Success");
			responce.setDescription("data found ");
			responce.setBeans(beans);
		}
		return schedulerService.getAllHaulier();
	}

	@PutMapping(path = "/update-haulier", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HaulierResponse updateHaulier(@RequestBody UserHaulier bean) {
		HaulierResponse response = new HaulierResponse();
		
		if (schedulerService.updateHaulier(bean.getHaulierPhoneNo(), bean.getHaulierName())) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Payment Status updated");
	
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product not found");
		}
		return response;
	}
	
}

