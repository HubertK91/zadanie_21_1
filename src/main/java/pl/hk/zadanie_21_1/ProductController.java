package pl.hk.zadanie_21_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping("/")
    public String home(String name, double price, ProductCategory category) {
        Product product = new Product(name, price, category);
        productRepository.add(product);
        return "index.html";
    }

    @GetMapping("/lista")
    public String printByCategory(Model model, @RequestParam(name = "kategoria", required = false) String category) {
        if (category != null) {
            List<Product> products = productRepository.findByCategory(category);
            model.addAttribute("products", products);
            model.addAttribute("sumProducts", products.stream().mapToDouble(Product::getPrice)
                    .sum());
            return "products";
        } else {
            List<Product> allProducts = productRepository.findAll();
            model.addAttribute("products", allProducts);
            model.addAttribute("sumProducts", allProducts.stream().mapToDouble(Product::getPrice)
                    .sum());
            return "products";
        }
    }
}
