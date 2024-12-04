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

    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @GetMapping("/productList")
    public String productList(Model model) {
        model.addAttribute("productList", productService.findAll());
       return "productList";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute Product product) {
        productService.save(product);

        return "redirect:/product/addProduct";
    }

}
