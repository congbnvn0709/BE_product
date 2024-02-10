package be.manageproducts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    String name;
    String price;
    String image;
    String product_type;
    String status;
    Timestamp created_at;
    Timestamp updated_at;
}
