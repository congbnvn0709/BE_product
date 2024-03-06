package be.manageproducts.repositorys;

import be.manageproducts.dto.product.request.SearchProductDTO;
import be.manageproducts.models.Product;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    Optional<Product> findProductById(Integer id);

    @Modifying(flushAutomatically = true)
    @Query(value = "update products set status = '0' where id = :id", nativeQuery = true)
    void deleteProduct(@Param("id") Integer id);

}
