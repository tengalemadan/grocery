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
import grocery.pojos.Product;
import grocery.pojos.PurchaseOrder;
import grocery.repository.PurchaseOrderRepository;

/**
 * @author Madanbalaji.tengale 
 * This controller for all CRUD operation perform on
 * PurchaseOrder Table
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController // for @Controller and @ResponseBody
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private PurchaseOrderRepository orderRepo;

	// place order details
	@PostMapping("/placeorder")
	public boolean orderDetails(@RequestBody PurchaseOrder order,@PathVariable int cust_id,@PathVariable int prod_id) {
		PurchaseOrder orderDetails = new PurchaseOrder(order.isOrderPlaced(), order.getTotalAmount(), order.getDeliveryDate(),new Customer(cust_id), new Product(prod_id));
		orderRepo.save(orderDetails);
		return true;
	}
	
	// get all order list details
	@GetMapping("/orderlist")
	public Iterable<PurchaseOrder> allOrdersList() {
		return orderRepo.findAll();
	}

	// 
	@PutMapping("/updateorderdetails/{id}")
	public ResponseEntity<PurchaseOrder> updateOrderDetails(@PathVariable int id,
			@Valid @RequestBody PurchaseOrder orderDetails) throws ResourceNotFound {
		PurchaseOrder order = orderRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Order details not found for this id :: " + id));
		// update delivery date
		order.setDeliveryDate(orderDetails.getDeliveryDate());
		//update order status
		order.setOrderPlaced(orderDetails.isOrderPlaced());
		final PurchaseOrder updatedOrderDetails = orderRepo.save(order);
		return ResponseEntity.ok(updatedOrderDetails);
	}

	// cancel order
	@DeleteMapping("/deleteorder/{id}")
	public String deleteOrderById(@PathVariable("id") Integer id) throws ResourceNotFound {
		if (id == null) {
			return "null id not allowed Provide valid id";
		}
		PurchaseOrder order = orderRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Order details not found for this id :: " + id));
		if (order != null) {
			orderRepo.delete(order);
		} else {
			return "Something went wrong..";
		}

		return "Deleted Order Details";
	}

}
