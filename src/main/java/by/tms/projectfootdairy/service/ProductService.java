package by.tms.projectfootdairy.service;

import by.tms.projectfootdairy.entity.Product;
import by.tms.projectfootdairy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public void delete(Product product, Long id) {
        productRepository.deleteById(id);
    }


}
