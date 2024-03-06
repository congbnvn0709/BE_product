package be.manageproducts.dto.product.response;

import be.manageproducts.dto.product.request.ProductDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProductSearchResponse {
   private Integer totalElements;
   private Integer totalPages;
   List<ProductDTO> productDTOList;
}
