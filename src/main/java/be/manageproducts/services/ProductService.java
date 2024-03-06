package be.manageproducts.services;

import be.manageproducts.ResponseData;
import be.manageproducts.dto.product.request.ProductDTO;
import be.manageproducts.dto.product.response.ProductResponse;
import be.manageproducts.dto.product.response.ProductSearchResponse;
import be.manageproducts.dto.product.request.SearchProductDTO;

public interface ProductService {
    ResponseData getListProduct(SearchProductDTO searchProductDTO);

    ResponseData createProduct(ProductDTO productDTO);

    ResponseData updateProduct(ProductDTO productDTO);
    ResponseData deleteProduct(Integer id);
    ResponseData getDetailProduct(Integer id);
}
