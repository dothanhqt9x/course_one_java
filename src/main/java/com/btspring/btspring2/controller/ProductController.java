package com.btspring.btspring2.controller;
import com.btspring.btspring2.anotation.CheckLogin;
import com.btspring.btspring2.anotation.CheckRole;
import com.btspring.btspring2.model.dto.request.ProductRequestDTO;
import org.springframework.ui.Model;
import com.btspring.btspring2.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @CheckLogin
    @CheckRole("admin")
    @GetMapping("")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product/product";
    }

    @CheckLogin
    @CheckRole("admin")
    @GetMapping("/search")
    public String getProductById(@RequestParam int id, Model model) {

        if(id <= 0 || id > productService.getAllProducts().size() || productService.getProductById(id) == null ) {
            return "product/product-result-error";
        }
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("valudId", id);

        return "product/product-result";
    }

    @CheckLogin
    @CheckRole("admin")
    @GetMapping("/add")
    public String addProduct() {
        return "product/product-add";
    }

    @CheckLogin
    @CheckRole("admin")
    @PostMapping("/add")
    public String addProduct(@ModelAttribute ProductRequestDTO productRequestDTO) {
        productService.addProduct(productRequestDTO);
        return "/product/product-add-success";
    }

}
