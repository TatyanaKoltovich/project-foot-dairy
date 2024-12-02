package by.tms.projectfootdairy.controller;


import by.tms.projectfootdairy.entity.Product;
import by.tms.projectfootdairy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String addProduct(Model model) {
        return "addproduct";
    }

    @PostMapping
    public String addProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/product/addproduct";
    }

}
