package by.tms.projectfootdairy.repository;

import by.tms.projectfootdairy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {
}
