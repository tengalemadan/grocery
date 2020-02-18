package grocery.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import exceptions.ResourceNotFound;
import grocery.pojos.Customer;

import grocery.repository.CustomerRepository;

/**
 * @author Madanbalaji.tengale 
 * This controller for all CRUD operation perform on
 * CustomersTable Table
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController // for @Controller and @ResponseBody
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository custRepo;

	// Register user
	@PostMapping("/registercustomer")
	public boolean registerCustomer(@RequestBody Customer cust) {
		Customer register = new Customer(cust.getCustomerName(), cust.getCustomerAddress(), cust.getContactNo(),
				cust.getEmail(), cust.getPassword());
		custRepo.save(register);
		return true;
	}

	// get all customer
	@GetMapping("/customerlist")
	public Iterable<Customer> allCustomerList() {
		return custRepo.findAll();
	}

	// update customer details
	@PutMapping("/updatecustomer/{id}")
	public ResponseEntity<Customer> updateCustomerDetails(@PathVariable int id,
			@Valid @RequestBody Customer customerDetails) throws ResourceNotFound {
		Customer cust = custRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Product not found for this id :: " + id));
		// update details
		cust.setContactNo(customerDetails.getContactNo());
		cust.setCustomerAddress(customerDetails.getCustomerAddress());
		cust.setCustomerName(customerDetails.getCustomerName());
		cust.setEmail(customerDetails.getEmail());
		cust.setPassword(customerDetails.getPassword());
		final Customer updatedCustomer = custRepo.save(cust);
		return ResponseEntity.ok(updatedCustomer);
	}

	// delete product by id
	@DeleteMapping("/deletecustomer/{id}")
	public String deleteCustomerById(@PathVariable("id") Integer id) throws ResourceNotFound {
		if (id == null) {
			return "null id not allowed Provide valid id";
		}
		Customer cust = custRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Product not found for this id :: " + id));
		if (cust != null) {
			custRepo.delete(cust);
		} else {
			return "Something went wrong..";
		}

		return "Deleted customer deatails";
	}

}
