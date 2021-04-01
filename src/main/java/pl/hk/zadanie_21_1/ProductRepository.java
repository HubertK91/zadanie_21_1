package pl.hk.zadanie_21_1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product("Masło",2.50,ProductCategory.FOOD));
        products.add(new Product("Chleb",2.00,ProductCategory.FOOD));
        products.add(new Product("Pralka",1250,ProductCategory.AGD));
        products.add(new Product("Lodówka",1000,ProductCategory.AGD));
        products.add(new Product("Opona",200,ProductCategory.OTHER));
        products.add(new Product("Okulary",300,ProductCategory.OTHER));
    }

    public List<Product> findAll() {
        return products;
    }

    public List<Product> findByCategory(String productCategory){
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().getDescription().equals(productCategory)) {
                result.add(product);
            }
        }
        return result;
    }

    public void add(Product product){
        products.add(product);
    }
}
