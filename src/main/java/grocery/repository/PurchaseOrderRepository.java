package grocery.repository;

import org.springframework.data.repository.CrudRepository;

import grocery.pojos.PurchaseOrder;

public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, Integer> {

}
