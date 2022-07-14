package maids.cc.quiz2.sales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import maids.cc.quiz2.clients.Client;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    private LocalDate createdAt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private String seller;
    private double total;
    private int quantity;
    private double price;

    public Sale() {
    }

    public Sale(String seller, double total, int quantity, double price) {
        this.seller = seller;
        this.total = total;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", client=" + client +
                ", seller='" + seller + '\'' +
                ", total=" + total +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
