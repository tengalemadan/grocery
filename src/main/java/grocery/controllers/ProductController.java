package grocery.controllers;

import java.io.IOException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import exceptions.ResourceNotFound;
import grocery.pojos.Product;
import grocery.repository.ProductRepository;

/**
 * @author Madanbalaji.tengale 
 * This controller for all CRUD operation perform on
 * Product Table
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController // for @Controller and @ResponseBody
@RequestMapping(value = "/products")
public class ProductController {
	// Dependency of productRepo for all CRUD operation
	@Autowired
	private ProductRepository product;

	public ProductController() {
		System.out.println("in productcontroller...");
	}

	// Method used for upload products
	@PostMapping("/uploadproduct")
	public String addProduct(@RequestParam MultipartFile imageFile, @RequestParam String name, @RequestParam double qty,
			@RequestParam String type, @RequestParam double price, @RequestParam String unit,
			@RequestParam double discount, @RequestParam boolean isOrganic) {
		Product p = new Product(name, price, type, qty, unit, isOrganic, discount);
		try {
			p.setProductImg(imageFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		product.save(p);
		return "Product added with Image";
	}

	// get all products from database
	@GetMapping("/productlist")
	public Iterable<Product> getAllProducts() {
		// This returns a JSON or XML with the all products
		return product.findAll();
	}

	// delete product by id
	@DeleteMapping("/deleteproduct/{id}")
	public String deleteProductById(@PathVariable("id") Integer id) throws ResourceNotFound {
		if (id == null) {
			return "null id not allowed Provide valid id";
		}
		Product pro = product.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Product not found for this id :: " + id));
		if (pro != null) {
			product.delete(pro);
		} else {
			return "Something went wrong..";
		}

		return "deleted";
	}

	// update product details
	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<Product> updateProductDetails(@PathVariable int id,
			@Valid @RequestBody Product productDetails) throws ResourceNotFound {
		Product pro = product.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Product not found for this id :: " + id));
		// update  product details
		pro.setPrice(productDetails.getPrice());
		pro.setDiscount(productDetails.getDiscount());
		pro.setQty(productDetails.getQty());
		pro.setUnit(productDetails.getUnit());
		pro.setOrganic(productDetails.isOrganic());
		final Product updatedProduct = product.save(pro);
		return ResponseEntity.ok(updatedProduct);
	}

}
