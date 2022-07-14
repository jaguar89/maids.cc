package maids.cc.quiz2.products;

import maids.cc.quiz2.errors.products.FailedToSaveProductException;
import maids.cc.quiz2.errors.products.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/products")
public class ProductController {

    @Autowired
    private ProductService productService;



    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) throws FailedToSaveProductException {
       return productService.addProduct(product);
    }


    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product , @PathVariable("id") long productId) throws ProductNotFoundException {
       return productService.updateProduct(productId,product);
    }
}
