package grocery.repository;

import org.springframework.data.repository.CrudRepository;

import grocery.pojos.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
