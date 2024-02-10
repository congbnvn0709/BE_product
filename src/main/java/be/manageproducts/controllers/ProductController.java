package be.manageproducts.controllers;

import be.manageproducts.dto.ProductDTO;
import be.manageproducts.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<ProductDTO> getListProduct(){
        return productService.getListProduct();
    }
}
