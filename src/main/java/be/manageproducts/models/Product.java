package be.manageproducts.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @JsonProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String price;
    String image;
    String product_type;
    String status;
    Timestamp created_at;
    Timestamp updated_at;
}
