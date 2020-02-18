package grocery.repository;
import org.springframework.data.repository.CrudRepository;
import grocery.pojos.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
