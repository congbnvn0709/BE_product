package be.manageproducts.repositorys;

import be.manageproducts.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Integer> {

    List<Product> getAll();
}
