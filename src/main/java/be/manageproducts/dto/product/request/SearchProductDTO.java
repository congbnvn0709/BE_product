package be.manageproducts.dto.product.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchProductDTO {
    private String name;
    private String productType;
    private Integer pageIndex;
    private Integer pageSize;
}
