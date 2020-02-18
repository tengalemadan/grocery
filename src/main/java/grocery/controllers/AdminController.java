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
import grocery.pojos.Admin;
import grocery.repository.AdminRepository;

/**
 * @author Madanbalaji.tengale 
 * This controller for all CRUD operation perform on
 * AdminTable Table
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController // for @Controller and @ResponseBody
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private AdminRepository adminRepo;

	// Register Admin
	@PostMapping("/registeradmin")
	public boolean registerAdmin(@RequestBody Admin admin) {
		Admin register = new Admin(admin.getAdminUserName(), admin.getPassword());
		adminRepo.save(register);
		return true;
	}

	// get all adminlist
	@GetMapping("/adminlist")
	public Iterable<Admin> allAdminList() {
		return adminRepo.findAll();
	}

	// change password
	@PutMapping("/updateadmin/{adminid}")
	public ResponseEntity<Admin> updateAdminDetails(@PathVariable int adminid,
			@Valid @RequestBody Admin adminDetails) throws ResourceNotFound {
		Admin admin = adminRepo.findById(adminid)
				.orElseThrow(() -> new ResourceNotFound("Admin details not found for this id :: " + adminid));
		// update details
		admin.setPassword(adminDetails.getPassword());
		final Admin updatedAdmin = adminRepo.save(admin);
		return ResponseEntity.ok(updatedAdmin);
	}

	// delete Admin by id
	@DeleteMapping("/deleteadmin/{id}")
	public String deleteAdminById(@PathVariable("id") Integer id) throws ResourceNotFound {
		if (id == null) {
			return "null id not allowed Provide valid id";
		}
		Admin admin = adminRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Admin details not found for this id :: " + id));
		if (admin != null) {
			adminRepo.delete(admin);
		} else {
			return "Something went wrong..";
		}

		return "Deleted Admin details";
	}

}
