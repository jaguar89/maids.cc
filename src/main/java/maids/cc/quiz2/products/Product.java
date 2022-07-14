package maids.cc.quiz2.products;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    @NotBlank(message = "Please add product name.")
    private String name;
    private String description;
    private String category;
    @CreationTimestamp
    private LocalDate createdAt;

    public Product() {
    }

    public Product(long id, String name, String description, String category, LocalDate createdAt) {
        this.productId = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.createdAt = createdAt;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
