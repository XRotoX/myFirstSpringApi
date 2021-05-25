package com.inptlabs.springlab.dao;

import com.inptlabs.springlab.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Id;
import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

    @RestResource(path = "/selectedProducts")
    public List<Product> findBySelectedIsTrue();

    @RestResource(path = "/keyword")
    public List<Product> findByNameContains(@Param("mc") String mc);

    @RestResource(path = "/promoProducts")
    public List<Product> findByPromotionIsTrue();

    @RestResource(path = "/availableProducts")
    public List<Product> findByAvailableIsTrue();
}
