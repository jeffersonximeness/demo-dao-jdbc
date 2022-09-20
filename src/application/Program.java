package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
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
		seller2 = sellerDao.findById(2);
		seller2.setName("Gregory X");
		sellerDao.update(seller2);
		System.out.println("Updated! " + seller2);
		
		System.out.println("\n-------TEST 6: seller delete-------");
		sellerDao.deleteById(11);
		System.out.println("Deleted!");
		
		System.out.println("\n-------TEST 7: FindAll-------");
		listSellers = sellerDao.findAll();
		
		for (Seller seller : listSellers) {
			System.out.println(seller);
		}
		
		System.out.println("\n-------TEST 8: department Insert-------");
		department = new Department(null, "Development");
		departmentDao.insert(department);
		System.out.println("Inserted! New id = " + department.getId());
		
		System.out.println("\n-------TEST 9: department FindById-------");
		department = departmentDao.findById(5);
		System.out.println(department);
		
		System.out.println("\n-------TEST 10: department Update-------");
		department = departmentDao.findById(10);
		department.setName("Security");
		departmentDao.update(department);
		System.out.println("Updated! " + department);
		
		System.out.println("\n-------TEST 11: department DeleteById-------");
		departmentDao.deleteById(5);
		System.out.println("Deleted");
		
		System.out.println("\n-------TEST 12: department FinAll-------");
		List<Department> listDep = departmentDao.findAll();
		System.out.println("Deleted");
		
		for (Department dep : listDep) {
			System.out.println(dep);
		}
	}

}
