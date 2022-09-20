package application;

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
	}

}
