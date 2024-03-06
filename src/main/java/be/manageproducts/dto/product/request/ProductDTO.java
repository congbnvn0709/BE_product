package be.manageproducts.dto.product.request;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Integer id;
    private String name;
    private String price;
    private MultipartFile imageFile;
    private String productType;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String imageUrl;
}
