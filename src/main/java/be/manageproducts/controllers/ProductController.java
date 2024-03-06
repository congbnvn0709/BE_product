package be.manageproducts.controllers;

import be.manageproducts.ResponseData;
import be.manageproducts.dto.product.request.ProductDTO;
import be.manageproducts.dto.product.response.ProductResponse;
import be.manageproducts.dto.product.response.ProductSearchResponse;
import be.manageproducts.dto.product.request.SearchProductDTO;
import be.manageproducts.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/searchProduct")
    public ResponseData getListProduct(@RequestBody SearchProductDTO searchDTO) {
        return productService.getListProduct(searchDTO);
    }

    @PostMapping("/createProduct")
    public ResponseData createProduct(@ModelAttribute ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }

    @PutMapping("/updateProduct")
    public ResponseData updateProduct(@ModelAttribute ProductDTO productDTO){
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseData deleteProduct(@PathVariable("id") Integer id){
        return productService.deleteProduct(id);
    }

    @GetMapping("/findProductById/{id}")
    public ResponseData getDetailProduct(@PathVariable("id") Integer id){
        return productService.getDetailProduct(id);
    }
}
