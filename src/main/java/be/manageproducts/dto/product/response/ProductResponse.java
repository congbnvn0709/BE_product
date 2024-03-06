package be.manageproducts.dto.product.response;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Integer id;
    private String name;
    private String price;
    private String imageUrl;
    private String productType;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
