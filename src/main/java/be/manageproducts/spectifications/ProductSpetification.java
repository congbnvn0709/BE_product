package be.manageproducts.spectifications;

import be.manageproducts.enums.Constants;
import be.manageproducts.models.Product;
import be.manageproducts.models.Product_;
import be.manageproducts.repositorys.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ProductSpetification {

    private final ProductRepository productRepository;

    public static Specification<Product> containName(String name) {
        if (Objects.isNull(name)) {
            return null;
        }
        return (root, query, cb) -> cb.like(cb.upper(root.get(Product_.NAME)), "%" + name.toUpperCase() + "%");
    }

    public static Specification<Product> hasProductType(String productType) {
        if (Objects.isNull(productType)) {
            return null;
        }
        return (root, query, cb) -> cb.equal(root.get(Product_.PRODUCT_TYPE), productType);
    }

    public static Specification<Product> statusActive() {
        return (root, query, cb) -> cb.equal(root.get(Product_.STATUS), Constants.ACTIVE);
    }

    public List<Product> searchProduct(String name, String productType) {

        Specification<Product> specification = Specification.where(containName(name)).and(hasProductType(productType)).and(statusActive());
        return productRepository.findAll(specification);
    }
}
