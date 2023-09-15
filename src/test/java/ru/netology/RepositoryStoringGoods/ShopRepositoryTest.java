package ru.netology.RepositoryStoringGoods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(11, "Telephone", 30_000);
    Product product2 = new Product(22, "Book", 300);
    Product product3 = new Product(300, "Car", 3_000_000);


    @Test
    public void addProductInRepository() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

//    @Test
//    public void deleteProductInRepository() {
//        repo.add(product1);
//        repo.add(product2);
//        repo.add(product3);
//        repo.removeById(1);
//
//        Product[] expected = { product2, product3 };
//        Product[] actual = repo.findAll();
//
//        Assertions.assertArrayEquals(expected, actual);
//
// }

    @Test
    public void deleteProductInRepository2() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> {
                    repo.removeById(445);
                });
    }
}