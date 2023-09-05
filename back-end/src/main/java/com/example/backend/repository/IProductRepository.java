package com.example.backend.repository;

import com.example.backend.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product p where p.name like %:name% and p.type_product_id  like %:typeId% order by p.amount", nativeQuery = true)
    Page<Product> getProductByNameAndType(Pageable pageable, @Param("name") String name, @Param("typeId") String typeId);

    @Modifying
    @Query(value = "insert into product ( name, amount, date_input, type_product_id) values ( :#{#product.name}, :#{#product.amount}, :#{#product.dateInput}, :#{#product.typeProduct})", nativeQuery = true)
    void createProduct(@Param("product") Product product);

    @Modifying
    @Query(value = "delete from product where id = :id", nativeQuery = true)
    void deleteProduct(@Param("id") Integer id);

    @Modifying
    @Query(value = "update product p set p.name=:#{#p.name}, p.amount=:#{#p.amount},p.date_input=:#{#p.dateInput}, p.type_product_id = :#{#p.typeProduct.id} where p.id = :#{#p.id}", nativeQuery = true)
    void editProduct(@Param("p") Product p);

    @Query(value = "select * from product where product.id=:id", nativeQuery = true)
    Product findProductById(@Param("id") Integer id);
}
