package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("-------TEST 1: seller FindById-------");
		Seller seller1 = sellerDao.findById(3);
		System.out.println(seller1);
		
		System.out.println("\n-------TEST 2: seller FindByDepartment-------");
		Department department = new Department(2, null);
		List<Seller> listSellers = sellerDao.findByDepartment(department);
		
		for (Seller seller : listSellers) {
			System.out.println(seller);
		}
		
		System.out.println("\n-------TEST 3: seller FindAll-------");
		listSellers = sellerDao.findAll();
		
		for (Seller seller : listSellers) {
			System.out.println(seller);
		}
		
		System.out.println("\n-------TEST 4: seller Insert-------");
		Seller seller2 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(seller2);
		System.out.println("Inserted! New id = " + seller2.getId());
		
		System.out.println("\n-------TEST 5: seller update-------");
		seller2 = sellerDao.findById(10);
		seller2.setName("Gregory X");
		sellerDao.update(seller2);
		System.out.println("Updated! " + seller2);
		
		System.out.println("\n-------TEST 6: seller delete-------");
		sellerDao.deleteById(11);
		System.out.println("Deleted!");
		
		System.out.println("\n-------FindAll-------");
		listSellers = sellerDao.findAll();
		
		for (Seller seller : listSellers) {
			System.out.println(seller);
		}
	}

}
