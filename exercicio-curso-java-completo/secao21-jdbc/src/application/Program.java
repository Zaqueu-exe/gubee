package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(2);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        list.forEach(System.out::println);

        System.out.println("\n=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        list.forEach(System.out::println);

        System.out.println("\n=== TEST 4: seller insert ===");
        Seller newSelller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(newSelller);
        System.out.println("Inserted! New id = " + newSelller.getId());

        System.out.println("\n=== TEST 5: seller update ===");
        seller = sellerDao.findById(7);
        seller.setName("Ana Paula");
        seller.setEmail("anapaula@gmail.com");
        sellerDao.update(seller);
        list = sellerDao.findAll();
        list.forEach(System.out::println);

        System.out.println("\n=== TEST 6: seller delete ===");
        sellerDao.deleteById(9);
        list = sellerDao.findAll();
        list.forEach(System.out::println);
    }
}
