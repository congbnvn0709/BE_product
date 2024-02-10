package be.manageproducts.serviceImpls;

import be.manageproducts.dto.ProductDTO;
import be.manageproducts.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductImpl implements ProductService {
    @Override
    public List<ProductDTO> getListProduct() {
        return null;
    }
}
