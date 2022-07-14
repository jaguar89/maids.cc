package maids.cc.quiz2.products;

import maids.cc.quiz2.errors.products.FailedToSaveProductException;
import maids.cc.quiz2.errors.products.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) throws FailedToSaveProductException {
        try {
            return productRepository.save(product);
        } catch (Exception ex) {
            throw new FailedToSaveProductException(ex.getMessage());
        }
    }

    public Product updateProduct(long productId, Product newProduct) throws ProductNotFoundException {

        var oldProductOptional = productRepository.findById(productId);
        if (!oldProductOptional.isPresent()) {
            throw new ProductNotFoundException("Product Not Found.");
        }
        var oldProduct = oldProductOptional.get();
        var newName = newProduct.getName();
        if (newName != null && !newName.equalsIgnoreCase("")) {
            oldProduct.setName(newName);
        }
        oldProduct.setCategory(newProduct.getCategory());
        oldProduct.setDescription(newProduct.getDescription());
        oldProduct.setCreatedAt(newProduct.getCreatedAt());
        return productRepository.save(oldProduct);

    }
}
