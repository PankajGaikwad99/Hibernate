package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.CarDTO;

public class CarDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	private static void closeConnection() {
		entityManagerFactory.close();
		entityManager.close();
		try {
			entityTransaction.rollback();
		} catch (Exception e) {
			System.out.println("The Transaction is commited");
		}
	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	public static void main(String[] args) {

		openConnection();
		entityTransaction.begin();

		CarDTO dto = new CarDTO();
		dto.setCarNo(1);
		dto.setCarName("Q7");
		dto.setBrandName("Audi");

		CarDTO dto1 = new CarDTO();
		dto1.setCarNo(2);
		dto1.setCarName("Swift");
		dto1.setBrandName("Suzuki");

		CarDTO dto2 = new CarDTO();
		dto2.setCarNo(3);
		dto2.setCarName("Mustang GT");
		dto2.setBrandName("Ford");

		entityManager.persist(dto);
		entityManager.persist(dto1);
		entityManager.persist(dto2);

		entityTransaction.commit();
		closeConnection();

	}
}
