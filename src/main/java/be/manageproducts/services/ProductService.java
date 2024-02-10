package be.manageproducts.services;

import be.manageproducts.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getListProduct();
}
