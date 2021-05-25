package com.inptlabs.springlab;

import com.inptlabs.springlab.dao.CategoryRepository;
import com.inptlabs.springlab.dao.ProductRepository;
import com.inptlabs.springlab.dto.Category;
import com.inptlabs.springlab.dto.Product;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
public class SpringLabApplication implements CommandLineRunner {


    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;


    public static void main(String[] args) {
        SpringApplication.run(SpringLabApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {


        repositoryRestConfiguration.exposeIdsFor(Product.class, Category.class);

        /*
        categoryRepository.save(new Category(null, "Monitors", null, null));
        categoryRepository.save(new Category(null, "Headphones", null, null));
        categoryRepository.save(new Category(null, "Printers", null, null));

        Random r = new Random();

        categoryRepository.findAll().forEach(category -> {
            for (int i=0; i<10; i++){
                Product p = new Product();
                p.setName(RandomString.make(10));
                p.setCurrentPrice(100 + r.nextInt(10000));
                p.setPromotion(r.nextBoolean());
                p.setSelected(r.nextBoolean());
                p.setCategory(category);
                p.setPhotoName("demo.png");
                productRepository.save(p);
            }
        });
        */
    }

}
