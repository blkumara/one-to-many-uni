package com.ty.One_To_Many;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteMobileSim {
	public static void main(String[] args) {
		
		

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Mobile mobile=entityManager.find(Mobile.class, 3);
		List<Sim> list=mobile.getSims();
		
		entityTransaction.begin();
		for (Sim sim : list) {
			entityManager.remove(sim);
		}
		entityManager.remove(mobile);
		entityTransaction.commit();
		
		System.out.println("Deleted");
	}
}
